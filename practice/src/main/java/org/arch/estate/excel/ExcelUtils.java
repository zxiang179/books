package org.arch.estate.excel;


import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author: tianjin@pinduoduo.com
 * @Date: 2021/2/17 11:05 上午
 */
public class ExcelUtils {

    // @Value("${file_base_path}")
    // private static String fileBasePath;//文件的基础路径
    // private static String fileBasePath = System.getProperty("user.dir") + File.separator + "excel" + File.separator;;//文件的基础路径

    public static final String OFFICE_EXCEL_XLS = "xls";
    public static final String OFFICE_EXCEL_XLSX = "xlsx";

    /**
     * 根据文件路径获取Workbook对象
     *
     * @param filepath 文件全路径
     */
    public static Workbook getWorkbook(String filepath)
            throws EncryptedDocumentException, InvalidFormatException, IOException {
        InputStream is = null;
        Workbook wb = null;
        if (StringUtils.isBlank(filepath)) {
            throw new IllegalArgumentException("文件路径不能为空");
        } else {
            String suffiex = getSuffiex(filepath);
            if (StringUtils.isBlank(suffiex)) {
                throw new IllegalArgumentException("文件后缀不能为空");
            }
            if (OFFICE_EXCEL_XLS.equals(suffiex) || OFFICE_EXCEL_XLSX.equals(suffiex)) {
                try {
                    is = new FileInputStream(filepath);
                    wb = WorkbookFactory.create(is);
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (wb != null) {
                        wb.close();
                    }
                }
            } else {
                throw new IllegalArgumentException("该文件非Excel文件");
            }
        }
        return wb;
    }

    /**
     * 获取后缀
     *
     * @param filepath filepath 文件全路径
     */
    private static String getSuffiex(String filepath) {
        if (StringUtils.isBlank(filepath)) {
            return "";
        }
        int index = filepath.lastIndexOf(".");
        if (index == -1) {
            return "";
        }
        return filepath.substring(index + 1);
    }

    /**
     * 创建Excel文件
     *
     * @param filePath  filepath 文件全路径
     * @param sheetName 新Sheet页的名字
     * @param titles    表头
     * @param values    每行的单元格
     */
    public static boolean writeExcel(String filePath, String sheetName,
                                     List<String> titles,
                                     List<Map<String, Object>> values
    ) throws IOException {
        boolean success;
        OutputStream outputStream = null;
        Workbook workbook = getOneWorkbook(filePath);
        // 生成一个表格
        Sheet sheet = getOneSheet(sheetName, workbook);
        // 生成样式
        Map<String, CellStyle> styles = ExcelStylesUtil.createStyles(workbook);
        // 存储标题在Excel文件中的序号
        Map<String, Integer> titleOrder = initTitles(ExcelStylesUtil.createStyles(workbook), sheet, titles);
        // 写入正文
        fillingContent(values, sheet, titleOrder, styles);

        try {
            outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            success = true;
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            workbook.close();
        }
        return success;

    }


    /**
     * 创建Excel文件
     *
     * @param fileName filepath 文件全路径
     * @param titles   表头
     * @param values   每行的单元格
     */
    public static boolean modifyExcel(String fileName, String sheetName,
                                      List<String> titles,
                                      List<Map<String, Object>> values
    ) throws IOException {
        boolean success;
        Workbook wb = getOneWorkbook(fileName);
        XSSFSheet sheet = (XSSFSheet) getOneSheet(sheetName, wb);

        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);
        // 生成样式
        Map<String, CellStyle> styles = ExcelStylesUtil.createStyles(wb);
        Map<String, Integer> titleOrder = initTitles(ExcelStylesUtil.createStyles(wb), sheet, titles);
        // 写入正文
        fillingContent(values, sheet, titleOrder, styles);
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileName);
            outputStream.flush();
            wb.write(outputStream);
            success = true;
        } finally {
            assert outputStream != null;
            outputStream.close();
            wb.close();
        }
        return success;
    }


    private static void setCellValue(Object targetVal, Cell cell) {
        // 判断object的类型
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (targetVal instanceof Double) {
            cell.setCellValue((Double) targetVal);
        } else if (targetVal instanceof Date) {
            String time = simpleDateFormat.format((Date) targetVal);
            cell.setCellValue(time);
        } else if (targetVal instanceof Calendar) {
            Calendar calendar = (Calendar) targetVal;
            String time = simpleDateFormat.format(calendar.getTime());
            cell.setCellValue(time);
        } else if (targetVal instanceof Boolean) {
            cell.setCellValue((Boolean) targetVal);
        } else if (targetVal instanceof Integer) {
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue((Integer) targetVal);
        } else if (targetVal instanceof Long) {
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue((Long) targetVal);
        } else {
            if (targetVal != null) {
                cell.setCellValue(targetVal.toString());
            }
        }
    }

    private static Map<String, Integer> initTitles(Map<String, CellStyle> styles, Sheet sheet, List<String> titles) {
        Row row = sheet.createRow(0);
        // 存储标题在Excel文件中的序号
        Map<String, Integer> titleOrder = Maps.newHashMap();
        for (int i = 0; i < titles.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(styles.get("header"));
            String title = titles.get(i);
            cell.setCellValue(title);
            titleOrder.put(title, i);
        }
        return titleOrder;
    }

    private static Sheet getOneSheet(String sheetName, Workbook workbook) {
        Sheet sheet;

        try {
            sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                return sheet;
            }
        } catch (Throwable th) {
            //
        }

        if (StringUtils.isBlank(sheetName)) {
            // name 为空则使用默认值
            sheet = workbook.createSheet();
        } else {
            sheet = workbook.createSheet(sheetName);
        }
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);
        return sheet;
    }

    private static Workbook getOneWorkbook(String filePath) {
        Workbook workbook;

        // 读取已有文件
        try {
            FileInputStream is = new FileInputStream("estate.xlsx");
            workbook = WorkbookFactory.create(is);
            if (workbook != null) {
                return workbook;
            }
        } catch (Throwable th) {
            //
        }

        // 创建新的excel文件
        String suffix = getSuffiex(filePath);
        if ("xls".equals(suffix.toLowerCase())) {
            workbook = new HSSFWorkbook();
        } else {
            workbook = new XSSFWorkbook();
        }
        return workbook;
    }

    private static void fillingContent(List<Map<String, Object>> values, Sheet sheet, Map<String, Integer> titleOrder, Map<String, CellStyle> styles) {
        Iterator<Map<String, Object>> iterator = values.iterator();
        // 行号
        int index = sheet.getLastRowNum() + 1;
        Row row = sheet.createRow(index);
        while (iterator.hasNext()) {
            Map<String, Object> value = iterator.next();
            for (Map.Entry<String, Object> map : value.entrySet()) {
                // 获取列名
                String title = map.getKey();
                // 根据列名获取列号
                int i = titleOrder.get(title);
                // 在指定序号处创建cell
                Cell cell = row.createCell(i);
                // 设置cell的样式
                if (index % 2 == 1) {
                    cell.setCellStyle(styles.get("cellA"));
                } else {
                    cell.setCellStyle(styles.get("cellB"));
                }
                // 获取列的值
                Object object = map.getValue();
                setCellValue(object, cell);
            }
            index++;
        }
    }
}