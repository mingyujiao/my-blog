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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


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

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Async
    public ResultBean saveOrUpdateUser(User user){
        logger.debug("线程正在执行这个方法：Thread{}",Thread.currentThread().getName());
        // 先查询redis缓存中是否存在该用户
        User oldUser = (User) redisTemplate.opsForHash().get("user", user.getUsername());
        if (oldUser != null) {
            return ResultUtil.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName",user.getUsername());
        oldUser = userMapper.selectOne(queryWrapper);
        if (oldUser != null) {
            // 将该用户放入缓存中，主要测试玩
            // redisTemplate.opsForValue().set(user.getUsername(), user, 10, TimeUnit.SECONDS);
            redisTemplate.opsForHash().put("user", user.getUsername(), user);
            return ResultUtil.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
        }
        if (user.getId() == null) {
            String pwd = user.getPassword();
            user.setPassword(PasswordUtil.generate(pwd));
            user.setCreateTime(LocalDateTime.now());
            user.setLastLoginTime(LocalDateTime.now());
            userMapper.insert(user);
        } else {
            userMapper.updateById(user);
        }
        redisTemplate.opsForHash().put("user" ,user.getUsername(), user);
        return ResultUtil.success(user);
    }

    @Override
    public ResultBean delUserById(User user) {
        if (user.getId() == null) {
            return ResultUtil.error(ResultEnum.PARAMETER_ERROR.getCode(), ResultEnum.PARAMETER_ERROR.getMsg());
        }
        redisTemplate.delete(user.getUsername());

        userMapper.deleteById(user.getId());

        return ResultUtil.success();
    }

    @Override
    public User queryUserByName(String username) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.select("id","username", "password").eq("username", username);
        List<User> users = userMapper.selectList(wrapper);

        return users.size() > 0 ? users.get(0) : null;
    }


}
