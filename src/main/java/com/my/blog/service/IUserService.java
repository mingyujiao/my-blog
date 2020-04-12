package com.my.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.my.blog.entity.User;
import com.my.blog.util.ResultBean;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
public interface IUserService extends IService<User> {

    ResultBean saveOrUpdateUser(User user);

    ResultBean delUserById(User user);
}
