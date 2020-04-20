package com.my.blog.controller;


import com.my.blog.config.WebLog;
import com.my.blog.entity.CurrentUserInfo;
import com.my.blog.entity.User;
import com.my.blog.mapper.UserMapper;
import com.my.blog.service.IUserService;
import com.my.blog.service.impl.UserServiceImpl;
import com.my.blog.util.ResultBean;
import com.my.blog.util.ResultEnum;
import com.my.blog.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@RestController
@RequestMapping
@Validated
@Slf4j
public class UserController {

    public static String LOGIN_NAME_KEY = "LOGIN_NAME";

    @Autowired
    private IUserService iUserService;


    /**
     * 根据ID获取用户信息，返回user对象
     * @return
     */
    @WebLog(description = "根据用户ID查询用户信息")
    @GetMapping("/userId/{userId}")
    public ResultBean findUserById(@NotNull(message = "ID不能为空") @PathVariable String userId){
        User user = iUserService.getById(userId);
        return ResultUtil.success(user);
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @WebLog(description = "添加用户信息")
    @PostMapping("save")
    public ResultBean saveUser(@Validated @RequestBody User user) {
        return iUserService.saveOrUpdateUser(user);
    }

    @WebLog(description = "根据ID删除用户信息")
    @PostMapping("delUser")
    public ResultBean delUser(@Validated @RequestBody User user){
        return iUserService.delUserById(user);
    }

    @GetMapping("/getCurrentUser")
    @WebLog(description = "获取用户信息")
    public ResultBean getCurrentUser(HttpSession session) {

        String loginName = (String) session.getAttribute(LOGIN_NAME_KEY);
        CurrentUserInfo currentUserInfo = iUserService.queryUserInfoByName(loginName);

        return ResultUtil.success(currentUserInfo);
    }

    @PostMapping("/login")
    @WebLog(description = "用户登录")
    public ResultBean login(@NotEmpty(message = "请输入用户名") String username,
                            @NotEmpty(message = "请输入密码") String password,
                            HttpSession session){
        //此Subject就是开头提到的  代表当前用户
        Subject subject = SecurityUtils.getSubject();
        //用请求的用户名和密码创建UsernamePasswordToken(此类来自shiro包下)
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        //调用subject.login进行验证，验证不通过则会抛出AuthenticationException异常，然后自定义返回信息
        try {
            subject.login(usernamePasswordToken);
        } catch (Exception e) {
            if (e instanceof AuthenticationException) {
                return ResultUtil.error(ResultEnum.LOGIN_ERROR.getCode(), ResultEnum.LOGIN_ERROR.getMsg());
            }
            log.error("用户登录接口异常：{}", e.getMessage());
        }

        //下面的是自定义的代码，随你怎么写
        session.setAttribute(LOGIN_NAME_KEY, username);

        return ResultUtil.success();
    }

    @PostMapping("/logout")
    @WebLog
    public ResultBean logout(HttpSession session) {
        session.removeAttribute(LOGIN_NAME_KEY);

        return ResultUtil.success();
    }
}
