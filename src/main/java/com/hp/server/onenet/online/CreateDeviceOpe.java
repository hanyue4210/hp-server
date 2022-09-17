package com.hp.server.onenet.online;

import com.hp.server.onenet.entity.CommonEntity;
import com.hp.server.onenet.utils.HttpSendCenter;
import org.json.JSONObject;
import okhttp3.Callback;


/**
 * Created by zhuocongbin
 * date 2018/3/16
 * apiKey: the product of api-key which can be found on OneNET
 */
public class CreateDeviceOpe extends BasicOpe{
    public CreateDeviceOpe(String apiKey) {
        super(apiKey);
    }
    @Override
    public JSONObject operation(CommonEntity commonEntity, JSONObject body) {
        return HttpSendCenter.post(this.apiKey, commonEntity.toUrl(), body);
    }
    @Override
    public void operation(CommonEntity commonEntity, JSONObject body, Callback callback) {
        HttpSendCenter.postAsync(this.apiKey, commonEntity.toUrl(), body, callback);
    }

}
