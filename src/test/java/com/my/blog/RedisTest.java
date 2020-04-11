package com.my.blog;

import com.my.blog.entity.User;
import com.my.blog.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2020/4/10 20:59
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void redisTest() {
        // redis存储数据
        String key = "name";
        redisTemplate.opsForValue().set(key, "qiuwei");
        // 获取数据
        String value = (String) redisTemplate.opsForValue().get(key);
        System.out.println("key:" + key + "value：" + value);
        User user = userMapper.selectById(1);
        String userKey = user.getUsername();
        redisTemplate.opsForValue().set(userKey, user);
        User newUser = (User) redisTemplate.opsForValue().get(userKey);
        System.out.println("key:" + userKey + "value：" + newUser);
    }

}
