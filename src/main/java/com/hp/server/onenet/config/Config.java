package com.hp.server.onenet.config;

import com.hp.server.onenet.exception.NBStatus;
import com.hp.server.onenet.exception.OnenetNBException;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by zhuocongbin
 * date 2018/3/15
 * Loading global properties
 */
public class Config {
    public static String domainName;
    static {
        Properties properties = new Properties();
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("application.properties"));
            domainName = (String)properties.get("domainName");
        } catch (IOException e) {
            throw new OnenetNBException(NBStatus.LOAD_CONFIG_ERROR);
        }
    }
    public static String getDomainName() {
        return domainName;
    }
}
