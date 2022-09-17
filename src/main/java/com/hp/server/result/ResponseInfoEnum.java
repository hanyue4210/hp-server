package com.hp.server.result;

/**
 * Created with IntelliJ IDEA.
 * User: ABC
 * Date: 2018/5/23
 * Time: 3:15 PM
 */
public enum ResponseInfoEnum implements ResponseInfoInterface {

    SUCCESS(200, "ok", "成功"),
    ERROR(400, "Error!", "错误!"),
    MISSING_PARAMETERS(400, "Missing parameters!", "缺少参数!"),
    INVALID_CODE(400, "Invalid code!", "无效的code!"),
    INVALID_ACCESS_TOKEN(400, "Invalid access token!", "无效的accessToken!"),
    UNIONID_EMPTY(400, "UnionId is empty!", "unionId为空!"),
    TRACK_EMPTY(400, "TrackId is empty!", "track为空!"),
    MISSING_PARAMETERS1(400, "Missing parameters!", "isShared=true uid必传!"),
    CODE_INCORRECT(400, "Code is incorrect!", "验证码不正确!"),
    PARSING_UNIONID_FAILED(400, "Parsing unionid failed!", "解析unionId失败!"),
    EMAIL_CODE_INCORRECT(400, "Email code is incorrect!", "邮箱验证码不正确!"),
    UNKNOWN_TYPE(400, "The type is unknown!", "不认识的类型!"),
    UNION_ID_DO_NOT_MATCH(400, "Union id don't match!", "unionid不匹配!"),
    MISSING_HEADERS(400, "Missing headers!", "缺少头文件!"),
    USER_REGISTERED(400, "User registered!", "用户已注册!"),
    REGISTER_FAILED(400, "Register failed!", "注册失败!"),
    THIRD_PARTY_LOGIN_FAILED(400, "Third party login failed!", "第三方登录失败!"),
    PHONE_NUMBER_OR_CAPTCHA_INCORRECT(400, "Phone number or captcha is incorrect!", "手机号码或验证码不正确!"),
    PHONE_NUMBER_INCORRECT(400, "Phone number is incorrect!", "手机号码不正确!"),
    PASSWORD_ILLEGAL(400, "Minimum 4 digits, maximum 20 digits!", "密码最短6位最长16位!"),
    PASSWORD_INCORRECT(400, "Incorrect password!", "密码不正确!"),
    PHONE_NUM_BINDING(400, "Phone number is already bound!", "手机号码已绑定!"),
    USER_NOT_REGISTERED(400, "User is not registered!", "用户还未注册!"),
    CAPTCHA_INCORRECT(400, "the captcha is incorrect!", "验证码不正确!"),
    ADD_ADDRESS_ERROR(400, "Failed to add address!", "新增地址失败!"),
    UPDATE_ADDRESS_ERROR(400, "Failed to update address!", "更新地址失败!"),
    UPDATE_PROFILE_FAILED(400, "Failed to update profile!", "更新个人资料失败!"),
    EMAIL_OR_EMPNO_INCORRECT(400, "Email or empNo is incorrect!", "邮箱或工号不正确!"),

    SORT_EXIST(400, "Sort already exist!", "序号已存在!"),
    MISSING_HEADERS1(40000, "Missing headers!", "缺少头文件!"),
    TOKEN_INCORRECT_OR_HAS_EXPIRED(40001, "The token is incorrect or has expired!", "token不正确或者已过期!"),
    INVALID_OPENID(40002, "Invalid openId!", "无效的openId!"),
    UNBIND_PHONE_NUM(40003, "Unbind phoneNum!", "请绑定手机号!"),
    REPEAT_ORDER(40004, "repeat order!", "重复订单!"),
    OVER_AGING(40005, "over aging!", "超过积分时效!"),
    REPEAT(40006, "repeat!", "重复!"),

    SERVER_ERROR(500, "server error!", "系统错误!"),

    SecretIdNotFound(201, "SecretIdNotFound!", "密钥不存在!"),

    Illegal_signature(202, "Illegal_signature!", "签名不合法!"),

    Signature_expired(203, "Signature_expired!", "签名已过期!"),

    Signature_failure(204, "Signature_failure!", "签名失败!"),

    InvalidSecretId(205, "InvalidSecretId!", "密钥非法!"),

    AUTH_ERROR(501, "auth error!", "权限认证失败!"),
    ;
    private int code;
    private String message;
    private String messageToUser;

    ResponseInfoEnum(int code, String message, String messageToUser) {
        this.code = code;
        this.message = message;
        this.messageToUser = messageToUser;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getMessageToUser() {
        return messageToUser;
    }


}
