package com.hp.server.aspect;

import com.hp.server.enumeration.TokenKeyEnum;
import com.hp.server.redis.RedisHelperImpl;
import com.hp.server.result.CheckTokenException;
import com.hp.server.result.ResponseInfoEnum;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户身份验证
 */
@Aspect
@Order(-99)
@Component
public class CheckIdentityTokenAspect {
    private static final Logger logger = LoggerFactory.getLogger(CheckIdentityTokenAspect.class);

    @Autowired
    private RedisHelperImpl<String,String> reditHelper;

    @Pointcut("@annotation(com.hp.server.aspect.CheckIdentityToken)")
    public void checkTokenAnnotation() {

    }

    @Before("checkTokenAnnotation()")
    public void doBeforeGet(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String loginName = request.getHeader("loginName");
        String token = request.getHeader("token");

        if (StringUtils.isBlank(loginName) || StringUtils.isBlank(token)) {
            throw new CheckTokenException(ResponseInfoEnum.MISSING_HEADERS);
        }
        String remoteToken = reditHelper.getValue(TokenKeyEnum.ADMIN.getMessage() + loginName);
        logger.debug("a_uid {},localToken {},remoteToken {}",loginName,token,remoteToken);

        if(!token.equals(remoteToken)) {
        	 logger.error("a_uid {},localToken {},remoteToken {}",loginName,token,remoteToken);
             throw new CheckTokenException(ResponseInfoEnum.TOKEN_INCORRECT_OR_HAS_EXPIRED);
        }
    }

}
