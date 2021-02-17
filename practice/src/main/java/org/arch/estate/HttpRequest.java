package org.arch.estate;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author: tianjin@pinduoduo.com
 * @Date: 2021/2/17 8:55 下午
 */
public class HttpRequest {

    public static JSONObject getJSONObjFromResponse(HttpResponse response) {
        try {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {//请求成功执行
                HttpEntity entity = response.getEntity();//获取返回的数据
                String entityStr = EntityUtils.toString(entity);//转换成字符串
                JSONObject fullData = JSONObject.parseObject(entityStr);//转换成JSON格式
                return JSONObject.parseObject(fullData.get("data").toString());//返回的数据就是我需要去解析的
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ProvinceBO getProvinceFromData(JSONObject dataJson) {
        return JSONObject.parseObject(dataJson.toJSONString(), ProvinceBO.class);
    }
}
