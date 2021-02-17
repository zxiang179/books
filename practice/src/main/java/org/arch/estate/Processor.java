package org.arch.estate;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.arch.estate.excel.ExcelUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.arch.estate.HttpUtils.SHANG_HAI_AREA;


/**
 * @Author: tianjin@pinduoduo.com
 * @Date: 2021/2/11 10:18 上午
 */
public class Processor {

    public static void main(String[] args) {
        try {
            ProvinceBO provinceBO = getData(DataSourceTypeEnum.HTTP_SOURCE);
            String fileName = "estate.xlsx";
            doCountProcessor(provinceBO, fileName);
            doPriceProcessor(provinceBO, fileName);

        } catch (IOException e) {
            System.out.println("error = " + e.getMessage());
        }
    }

    private static ProvinceBO getData(DataSourceTypeEnum type) {
        switch (type) {
            case FILE_SOURCE: {
                ObjectMapper mapper = new ObjectMapper();
                String jsonStr = InputUtils.getFileFromResource();
                try {
                    return mapper.readValue(jsonStr, ProvinceBO.class);
                } catch (IOException e) {
                    //
                }
            }
            break;
            case HTTP_SOURCE: {
                HttpResponse response = HttpUtils.doGet(SHANG_HAI_AREA);
                assert response != null;
                JSONObject jsonObject = HttpRequest.getJSONObjFromResponse(response);
                assert jsonObject != null;
                return HttpRequest.getProvinceFromData(jsonObject);
            }
            default:
                return null;
        }
        return null;
    }

    private static void doPriceProcessor(ProvinceBO provinceBO, String fileName) throws IOException {
        ArrayList<String> areas = new ArrayList<>();
        List<Map<String, Object>> values = new ArrayList<>();
        fillingData2(provinceBO, areas, values);

        ExcelUtils.writeExcel(fileName, "priceSheet", areas, values);
    }

    private static void doCountProcessor(ProvinceBO provinceBO, String fileName) throws IOException {
        ArrayList<String> areas = new ArrayList<>();
        List<Map<String, Object>> values = new ArrayList<>();
        fillingData(provinceBO, areas, values);

        ExcelUtils.writeExcel(fileName, "countSheet", areas, values);
    }

    private static void fillingData2(ProvinceBO provinceBO, ArrayList<String> areas, List<Map<String, Object>> values) {
        addTimeCol(areas, values);
        for (AreaBO area : provinceBO.getBubbleList()) {
            areas.add(area.getName());
            Map<String, Object> map = new HashMap<>();
            map.put(area.getName(), area.getPrice());
            values.add(map);
        }
    }

    private static void fillingData(ProvinceBO provinceBO, ArrayList<String> areas, List<Map<String, Object>> values) {
        addTimeCol(areas, values);
        for (AreaBO area : provinceBO.getBubbleList()) {
            areas.add(area.getName());
            Map<String, Object> map = new HashMap<>();
            map.put(area.getName(), area.getCount());
            values.add(map);
        }
    }

    private static void addTimeCol(ArrayList<String> areas, List<Map<String, Object>> values) {
        areas.add("时间");
        Map<String, Object> timeMap = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = simpleDateFormat.format(new Date());
        timeMap.put("时间", time);
        values.add(timeMap);
    }
}
