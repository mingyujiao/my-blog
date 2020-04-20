package com.my.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.blog.entity.CurrentUserInfo;
import com.my.blog.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
public interface UserMapper extends BaseMapper<User> {

    CurrentUserInfo queryUserInfoByName (@Param("username") String username);

}
