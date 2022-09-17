package com.hp.server.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hp.server.service.DeviceService;
import com.hp.server.service.OperationService;
import com.hp.server.utils.OneNetUtil;
import com.hp.server.vo.OneNetReceiveVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * @author:mengchen
 * @date:2020/5/22
 * @description:OneNet相关接口
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/oneNet")
public class OneNetControler {
    @Value("${oneNet.token}")
    private String token;//用户自定义token和OneNet第三方平台配置里的token一致

    @Resource
    private OperationService operationService;
    @Autowired
    DeviceService deviceService;

    private static Logger logger = LoggerFactory.getLogger(OneNetControler.class);

    /**
     * 功能描述：第三方平台数据接收。<p>
     * <ul>注:
     *     <li>1.OneNet平台为了保证数据不丢失，有重发机制，如果重复数据对业务有影响，数据接收端需要对重复数据进行排除重复处理。</li>
     *     <li>2.OneNet每一次post数据请求后，等待客户端的响应都设有时限，在规定时限内没有收到响应会认为发送失败。
     *          接收程序接收到数据时，尽量先缓存起来，再做业务逻辑处理。</li>
     * </ul>
     *
     * @param body 数据消息
     * @return 任意字符串。OneNet平台接收到http 200的响应，才会认为数据推送成功，否则会重发。
     */
    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    @ResponseBody
    public String receive(@RequestBody String body) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        logger.info("data receive:  body String --- " + body);
        /************************************************
         *  解析数据推送请求，非加密模式。
         *  如果是明文模式使用以下代码
         **************************************************/
        /*************明文模式  start****************/
        OneNetUtil.BodyObj obj = OneNetUtil.resolveBody(body, false);
        logger.info("data receive:  body Object --- " + obj);
        if (obj != null) {
            boolean dataRight = OneNetUtil.checkSignature(obj, token);
            if (dataRight) {
                logger.info("data receive: content" + obj.toString());
                ArrayList<OneNetReceiveVo> receiveList = new ArrayList<OneNetReceiveVo>();
                if (obj.getMsg().toString().indexOf("[") > -1) {
                     receiveList = (ArrayList<OneNetReceiveVo>) JSONArray.parseArray(obj.getMsg().toString(), OneNetReceiveVo.class);
                } else {
                    OneNetReceiveVo oneNetReceiveVo = JSON.parseObject(obj.getMsg().toString(), OneNetReceiveVo.class);
                    receiveList.add(oneNetReceiveVo);
                }

                if (obj.getMsg().toString().indexOf("login_type") > -1) {
                    // 更新设备状态
                    deviceService.updateDeviceStatus(receiveList.get(0).getImei(),receiveList.get(0).getStatus());
                } else {
                    // 向服务器插入oneNet接收到的数据
                    operationService.saveOperation(receiveList);
                }


            } else {
                logger.info("data receive: signature error");
            }

        } else {
            logger.info("data receive: body empty error");
        }
        /*************明文模式  end****************/


        /********************************************************
         *  解析数据推送请求，加密模式
         *
         *  如果是加密模式使用以下代码
         ********************************************************/
        /*************加密模式  start****************/
//        Util.BodyObj obj1 = Util.resolveBody(body, true);
//        logger.info("data receive:  body Object--- " +obj1);
//        if (obj1 != null){
//            boolean dataRight1 = Util.checkSignature(obj1, token);
//            if (dataRight1){
//                String msg = Util.decryptMsg(obj1, aeskey);
//                logger.info("data receive: content" + msg);
//            }else {
//                logger.info("data receive:  signature error " );
//            }
//        }else {
//            logger.info("data receive: body empty error" );
//        }
        /*************加密模式  end****************/
        return "ok";
    }

    /**
     * 功能说明： URL&Token验证接口。如果验证成功返回msg的值，否则返回其他值。
     *
     * @param msg       验证消息
     * @param nonce     随机串
     * @param signature 签名
     * @return msg值
     */

    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    @ResponseBody
    public String check(@RequestParam(value = "msg") String msg,
                        @RequestParam(value = "nonce") String nonce,
                        @RequestParam(value = "signature") String signature) throws UnsupportedEncodingException {

        logger.info("url&token check: msg:{} nonce{} signature:{}", msg, nonce, signature);
        if (OneNetUtil.checkToken(msg, nonce, signature, token)) {
            return msg;
        } else {
            return "error";
        }

    }


}
