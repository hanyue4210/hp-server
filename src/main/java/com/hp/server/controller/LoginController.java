package com.hp.server.controller;

import com.hp.server.dto.SysUserLoginDTO;
import com.hp.server.entity.SysUser;
import com.hp.server.enumeration.TokenKeyEnum;
import com.hp.server.redis.RedisHelperImpl;
import com.hp.server.result.ResultBody;
import com.hp.server.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author:mengchen
 * @date:2020/5/19
 * @description:登录
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {
    @Resource
    private SysUserService sysUserService;
    private Long timeout = 365L;
    private TimeUnit timeUnit = TimeUnit.DAYS;

    @Resource
    private RedisHelperImpl<String,String> redisHelper;

    /**
     * 用户登录
     * @param dto 登录相关信息
     * @return
     */
    @PostMapping("/login")
    public ResultBody login(@RequestBody SysUserLoginDTO dto) {
        ResultBody result = new ResultBody();
        //用来存放添加的返回消息
        Map<String,Object> map = new HashMap<String,Object>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getLoginName(), dto.getPassword());
        try {
            subject.login(token);
            //获取当前用户权限
            List<String> listAuth = sysUserService.listAuth();

            map.put("token", subject.getSession().getId());
            map.put("role", listAuth);
            result.setMessage("登录成功");
            result.setMessageToUser("登录成功");
            result.setData(map);
        } catch (IncorrectCredentialsException e) {
            result.setCode(400);
            result.setMessage("密码错误");
            result.setMessageToUser("密码错误");
        } catch (LockedAccountException e) {
            result.setCode(400);
            result.setMessage("登录失败，该用户已被冻结");
            result.setMessageToUser("登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            result.setCode(400);
            result.setMessage("该用户不存在");
            result.setMessageToUser("该用户不存在");
        } catch (Exception e) {
            result.setCode(400);
            result.setMessage(e.getMessage());
            result.setMessageToUser("登录失败");
        }
        return result;
    }

    /**
     * 退出登录
     * @return
     */
    @PostMapping("/logout")
    public ResultBody logout() {
        ResultBody result = new ResultBody();
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
            result.setMessage("退出成功");
            result.setMessageToUser("退出成功");
        }  catch (Exception e) {
            result.setCode(400);
            result.setMessage(e.getMessage());
            result.setMessageToUser("退出失败");
        }
        return result;
    }

    /**
     * 查询登录用户信息
     * @return
     */
    @GetMapping("/getSysUserInfo")
    public ResultBody getSysUserInfo() {
        ResultBody result = new ResultBody();

        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("loginName", sysUser.getLoginName());
        map.put("userName", sysUser.getUserName());
        map.put("mobile", sysUser.getMobile());
        map.put("userType", sysUser.getUserType());

        //获取当前用户权限
        List<String> listAuth = sysUserService.listAuth();
        map.put("role", listAuth);

        result.setData(map);
        return result;
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public ResultBody unauth() {
        ResultBody result = new ResultBody();
        result.setCode(401);
        result.setMessage("未登录");
        result.setMessageToUser("未登录");
        return result;
    }

    /**
     * ModbusAdapter登录
     * @param dto 登录相关信息
     * @return
     */
    @PostMapping("/loginModbusAdapter")
    public ResultBody loginModbusAdapter(@RequestBody SysUserLoginDTO dto) {
        ResultBody result = new ResultBody();
        //用来存放添加的返回消息
        Map<String,Object> map = new HashMap<String,Object>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getLoginName(), dto.getPassword());
        try {
            subject.login(token);
            map.put("token", subject.getSession().getId());
            redisHelper.valuePut(TokenKeyEnum.ADMIN.getMessage()+ dto.getLoginName(), subject.getSession().getId().toString());
            redisHelper.expirse(TokenKeyEnum.ADMIN.getMessage()+ dto.getLoginName(), timeout, timeUnit);
            result.setMessage("登录成功");
            result.setMessageToUser("登录成功");
            result.setData(map);
        } catch (IncorrectCredentialsException e) {
            result.setCode(400);
            result.setMessage("密码错误");
            result.setMessageToUser("密码错误");
        } catch (LockedAccountException e) {
            result.setCode(400);
            result.setMessage("登录失败，该用户已被冻结");
            result.setMessageToUser("登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            result.setCode(400);
            result.setMessage("该用户不存在");
            result.setMessageToUser("该用户不存在");
        } catch (Exception e) {
            result.setCode(400);
            result.setMessage(e.getMessage());
            result.setMessageToUser("登录失败");
        }
        return result;
    }
}
