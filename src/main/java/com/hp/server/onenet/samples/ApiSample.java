package com.hp.server.onenet.samples;


import com.hp.server.onenet.entity.Resources;
import com.hp.server.onenet.online.ResourcesOpe;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhuocongbin
 * date 2018/3/15
 */
public class ApiSample {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiSample.class);

    public static void main(String[] args) {
        String apiKey = "EeF=WcSxUsxqCkORLeDnvsZIHqY=";
        String imei = "868163042637501";
        Integer writeResId = 6018;
        // Write
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res_id", writeResId);
        jsonObject.put("val", "data1");
        jsonArray.put(jsonObject);
        JSONObject data = new JSONObject();
        data.put("data", jsonArray);
        // Execute
        //下发命令内容，JSON格式
        JSONObject body = new JSONObject();
        body.put("args", data);
        // Resource
        ResourcesOpe resourcesOpe = new ResourcesOpe(apiKey);
        Resources resources = new Resources(imei);
//        LOGGER.info(resourcesOpe.operation(resources, body).toString());
        String s = resourcesOpe.operation(resources, body).toString();

    }
}
