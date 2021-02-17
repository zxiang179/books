package org.arch.estate.excel;


import com.google.common.collect.Maps;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.util.Map;

/**
 * @Author: tianjin@pinduoduo.com
 * @Date: 2021/2/17 3:52 下午
 */
public class ExcelStylesUtil {

    /**
     * 设置格式
     */
    public static Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = Maps.newHashMap();

        // 标题样式
        XSSFCellStyle titleStyle = (XSSFCellStyle) wb.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.CENTER); // 水平对齐
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直对齐
        titleStyle.setLocked(true); // 样式锁定
        titleStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 16);
        titleFont.setBold(true);
        titleFont.setFontName("微软雅黑");
        titleStyle.setFont(titleFont);
        styles.put("title", titleStyle);

        // 文件头样式
        XSSFCellStyle headerStyle = (XSSFCellStyle) wb.createCellStyle();
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex()); // 前景色
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 颜色填充方式
        headerStyle.setWrapText(true);
        headerStyle.setBorderRight(BorderStyle.THIN); // 设置边界
        headerStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        Font headerFont = wb.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        titleFont.setFontName("微软雅黑");
        headerStyle.setFont(headerFont);
        styles.put("header", headerStyle);

        Font cellStyleFont = wb.createFont();
        cellStyleFont.setFontHeightInPoints((short) 12);
        cellStyleFont.setColor(IndexedColors.BLUE_GREY.getIndex());
        cellStyleFont.setFontName("微软雅黑");

        // 正文样式A
        XSSFCellStyle cellStyleA = (XSSFCellStyle) wb.createCellStyle();
        cellStyleA.setAlignment(HorizontalAlignment.CENTER); // 居中设置
        cellStyleA.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyleA.setWrapText(true);
        cellStyleA.setBorderRight(BorderStyle.THIN);
        cellStyleA.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleA.setBorderLeft(BorderStyle.THIN);
        cellStyleA.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleA.setBorderTop(BorderStyle.THIN);
        cellStyleA.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleA.setBorderBottom(BorderStyle.THIN);
        cellStyleA.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleA.setFont(cellStyleFont);
        styles.put("cellA", cellStyleA);

        // 正文样式B:添加前景色为浅黄色
        XSSFCellStyle cellStyleB = (XSSFCellStyle) wb.createCellStyle();
        cellStyleB.setAlignment(HorizontalAlignment.CENTER);
        cellStyleB.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyleB.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        cellStyleB.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyleB.setWrapText(true);
        cellStyleB.setBorderRight(BorderStyle.THIN);
        cellStyleB.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleB.setBorderLeft(BorderStyle.THIN);
        cellStyleB.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleB.setBorderTop(BorderStyle.THIN);
        cellStyleB.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleB.setBorderBottom(BorderStyle.THIN);
        cellStyleB.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleB.setFont(cellStyleFont);
        styles.put("cellB", cellStyleB);

        return styles;
    }

    /**
     * 将源文件的内容复制到新Excel文件(可供理解Excel使用,使用价值不大)
     *
     * @param srcFilepath 源文件全路径
     * @param desFilepath 目标文件全路径
     */
//    public static void writeExcel(String srcFilepath, String desFilepath)
//            throws IOException, EncryptedDocumentException, InvalidFormatException {
//        FileOutputStream outputStream = null;
//        String suffiex = getSuffiex(desFilepath);
//        if (StringUtils.isBlank(suffiex)) {
//            throw new IllegalArgumentException("文件后缀不能为空");
//        }
//        Workbook workbook_des;
//        if ("xls".equals(suffiex.toLowerCase())) {
//            workbook_des = new HSSFWorkbook();
//        } else {
//            workbook_des = new XSSFWorkbook();
//        }
//
//        Workbook workbook = getWorkbook(srcFilepath);
//        if (workbook != null) {
//            int numberOfSheets = workbook.getNumberOfSheets();
//            for (int k = 0; k < numberOfSheets; k++) {
//                Sheet sheet = workbook.getSheetAt(k);
//                Sheet sheet_des = workbook_des.createSheet(sheet.getSheetName());
//                int rowNos = sheet.getLastRowNum();
//                for (int i = 0; i <= rowNos; i++) {
//                    Row row = sheet.getRow(i);
//                    Row row_des = sheet_des.createRow(i);
//                    if (row != null) {
//                        int columNos = row.getLastCellNum();
//                        for (int j = 0; j < columNos; j++) {
//                            Cell cell = row.getCell(j);
//                            Cell cell_des = row_des.createCell(j);
//                            if (cell != null) {
//                                cell.setCellType(CellType.STRING);
//                                cell_des.setCellType(CellType.STRING);
//                                cell_des.setCellValue(cell.getStringCellValue());
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        try {
//            outputStream = new FileOutputStream(desFilepath);
//            workbook_des.write(outputStream);
//        } finally {
//            if (outputStream != null) {
//                outputStream.close();
//            }
//            if (workbook != null) {
//                workbook_des.close();
//            }
//        }
//    }

    /**
     * 读取指定Sheet页的表头
     *
     * @param filepath filepath 文件全路径
     * @param sheetNo  sheet序号,从0开始,必填
     */
//    public static Row readTitle(String filepath, int sheetNo)
//            throws IOException, EncryptedDocumentException, InvalidFormatException {
//        Row returnRow = null;
//        Workbook workbook = getWorkbook(filepath);
//        if (workbook != null) {
//            Sheet sheet = workbook.getSheetAt(sheetNo);
//            returnRow = readTitle(sheet);
//        }
//        return returnRow;
//    }

    /**
     * 读取指定Sheet页的表头
     */
//    public static Row readTitle(Sheet sheet) {
//        Row returnRow = null;
//        int totalRow = sheet.getLastRowNum();// 得到excel的总记录条数
//        for (int i = 0; i < totalRow; i++) {// 遍历行
//            Row row = sheet.getRow(i);
//            if (row == null) {
//                continue;
//            }
//            returnRow = sheet.getRow(0);
//            break;
//        }
//        return returnRow;
//    }

    /**
     * 读取指定Sheet也的内容
     *
     * @param filepath filepath 文件全路径
     * @param sheetNo  sheet序号,从0开始,如果读取全文sheetNo设置null
     */
//    public static String readExcel(String filepath, Integer sheetNo)
//            throws EncryptedDocumentException, InvalidFormatException, IOException {
//        StringBuilder sb = new StringBuilder();
//        Workbook workbook = getWorkbook(filepath);
//        if (workbook != null) {
//            if (sheetNo == null) {
//                int numberOfSheets = workbook.getNumberOfSheets();
//                for (int i = 0; i < numberOfSheets; i++) {
//                    Sheet sheet = workbook.getSheetAt(i);
//                    if (sheet == null) {
//                        continue;
//                    }
//                    sb.append(readExcelSheet(sheet));
//                }
//            } else {
//                Sheet sheet = workbook.getSheetAt(sheetNo);
//                if (sheet != null) {
//                    sb.append(readExcelSheet(sheet));
//                }
//            }
//        }
//        return sb.toString();
//    }

//    private static String readExcelSheet(Sheet sheet) {
//        StringBuilder sb = new StringBuilder();
//
//        if (sheet != null) {
//            int rowNos = sheet.getLastRowNum();// 得到excel的总记录条数
//            for (int i = 0; i <= rowNos; i++) {// 遍历行
//                Row row = sheet.getRow(i);
//                if (row != null) {
//                    int columNos = row.getLastCellNum();// 表头总共的列数
//                    for (int j = 0; j < columNos; j++) {
//                        Cell cell = row.getCell(j);
//                        if (cell != null) {
//                            cell.setCellType(CellType.STRING);
//                            sb.append(cell.getStringCellValue() + " ");
//                            // System.out.print(cell.getStringCellValue() + " ");
//                        }
//                    }
//                    // System.out.println();
//                }
//            }
//        }
//
//        return sb.toString();
//    }

}

