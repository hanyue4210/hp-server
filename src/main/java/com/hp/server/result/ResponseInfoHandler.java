package com.hp.server.result;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA.
 * User: ABC
 * Date: 2018/5/23
 * Time: 3:25 PM
 */
@RestControllerAdvice
public class ResponseInfoHandler {
    private static final Logger logger = LoggerFactory.getLogger(ResponseInfoHandler.class);

    @ExceptionHandler(value = ResponseInfoException.class)
    public ResultBody responseInfoExceptionHandler(ResponseInfoException exception) {
        ResponseInfoInterface responseInfoInterface = exception.getResponseInfoInterface();
        ResultBody resultBody = new ResultBody(responseInfoInterface);
        return resultBody;
    }

    @ExceptionHandler(value = CheckTokenException.class)
    public ResultBody checkTokenExceptionHandler(CheckTokenException exception) {
        ResponseInfoInterface responseInfoInterface = exception.getResponseInfoInterface();
        ResultBody resultBody = new ResultBody(responseInfoInterface);
        return resultBody;
    }

    @ExceptionHandler(BindException.class)
    public ResultBody invalidBind(BindException ex) {
        logger.error(ex.getMessage());
        ResultBody result = new ResultBody(ResponseInfoEnum.MISSING_PARAMETERS);
        result.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
        return result;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultBody invalidInput(MethodArgumentNotValidException ex) {
        logger.error(ex.getMessage());
        ResultBody result = new ResultBody(ResponseInfoEnum.MISSING_PARAMETERS);
        result.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
        return result;
    }
    @ExceptionHandler(UnauthorizedException.class)
    public ResultBody processException(UnauthorizedException ue) {
        logger.error(ue.getMessage());
        ResultBody result = new ResultBody(ResponseInfoEnum.AUTH_ERROR);
        result.setMessage(ue.getMessage());
        return result;
    }

    @ExceptionHandler
    public ResultBody processException(Exception e) {
        logger.error("", e);
        ResultBody result = new ResultBody(ResponseInfoEnum.SERVER_ERROR);
        result.setMessage(e.getMessage());
        return result;
    }
}
