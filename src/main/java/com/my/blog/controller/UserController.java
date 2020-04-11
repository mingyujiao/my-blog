package com.my.blog.controller;


import com.my.blog.config.WebLog;
import com.my.blog.entity.User;
import com.my.blog.service.IUserService;
import com.my.blog.util.ResultBean;
import com.my.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 根据ID获取用户信息，返回user对象
     * @return
     */
    @WebLog
    @GetMapping("/userId/{userId}")
    public ResultBean findUserById(@PathVariable String userId){
        User user = iUserService.getById(userId);
        return ResultUtil.success(user);
    }

    @WebLog
    @PostMapping("save")
    public ResultBean saveUser(@Validated @RequestBody User user){
//        if(bindingResult.hasErrors()) {
//            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
//            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(), defaultMessage);
//        }

        return iUserService.saveOrUpdateUser(user);
    }


}
