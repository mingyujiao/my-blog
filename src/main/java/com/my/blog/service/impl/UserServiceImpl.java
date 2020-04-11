package com.my.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.blog.entity.User;
import com.my.blog.mapper.UserMapper;
import com.my.blog.service.IUserService;
import com.my.blog.util.PasswordUtil;
import com.my.blog.util.ResultBean;
import com.my.blog.util.ResultEnum;
import com.my.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

//    public User findUserById(Long userId){
//        return userMapper.selectById(userId);
//    }


    @Override
    public ResultBean saveOrUpdateUser(User user){

        // 先查询redis缓存中是否存在该用户
        User oldUser = (User) redisTemplate.opsForValue().get(user.getUsername());
        if (oldUser != null) {
            return ResultUtil.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName",user.getUsername());
        oldUser = userMapper.selectOne(queryWrapper);
        if (oldUser != null) {
            // 将该用户放入缓存中，主要测试玩
            // redisTemplate.opsForValue().set(user.getUsername(), user, 10, TimeUnit.SECONDS);
            redisTemplate.opsForValue().set(user.getUsername(), user);
            return ResultUtil.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
        }
        if (user.getId() == null) {
            String pwd = user.getPassword();
            user.setPassword(PasswordUtil.generate(pwd));
            user.setCreateTime(LocalDateTime.now());
            user.setLastLoginTime(LocalDateTime.now());
            userMapper.insert(user);
        } else {
            userMapper.update(user);
        }
        // 将该用户放入缓存中
        // 设置key的过期时间
        // redisTemplate.opsForValue().set(user.getUsername(), user, 10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        return ResultUtil.success(user);
    }



}
