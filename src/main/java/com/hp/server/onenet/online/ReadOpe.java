package com.hp.server.onenet.online;


import com.hp.server.onenet.entity.CommonEntity;
import com.hp.server.onenet.utils.HttpSendCenter;
import org.json.JSONObject;

import okhttp3.Callback;

/**
 * Created by zhuocongbin
 * date 2018/3/15
 * apiKey: the product of api-key which can be found on OneNET
 */
public class ReadOpe extends BasicOpe{
    public ReadOpe(String apiKey) {
        super(apiKey);
    }
    @Override
    public JSONObject operation(CommonEntity commonEntity, JSONObject body) {
        return HttpSendCenter.get(apiKey, commonEntity.toUrl());
    }
    @Override
    public void operation(CommonEntity commonEntity, JSONObject body, Callback callback) {
        HttpSendCenter.getAsync(apiKey, commonEntity.toUrl(), callback);
    }

}
