package com.hp.server.onenet.online;

import com.hp.server.onenet.entity.CommonEntity;
import org.json.JSONObject;

import okhttp3.Callback;

/**
 * Created by zhuocongbin
 * date 2018/3/16
 */
public abstract class BasicOpe {
    protected String apiKey;
    public BasicOpe(String apiKey) {
        this.apiKey = apiKey;
    }
    public abstract JSONObject operation(CommonEntity commonEntity, JSONObject body);
    public abstract void operation(CommonEntity commonEntity, JSONObject body, Callback callback);
}
