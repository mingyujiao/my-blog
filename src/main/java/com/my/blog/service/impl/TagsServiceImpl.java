package com.my.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.blog.entity.Tags;
import com.my.blog.mapper.TagsMapper;
import com.my.blog.service.ITagsService;
import com.my.blog.util.ResultBean;
import com.my.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 标签 服务实现类
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements ITagsService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TagsMapper tagsMapper;

    @Override
    public ResultBean<Tags> saveOrUpdateTags(Tags tags) {
        if (tags.getId() == null) {
            tagsMapper.insert(tags);
        } else {
            tagsMapper.updateById(tags);
        }

        return ResultUtil.success();
    }

    @Override
    public ResultBean<Tags> getTagsById(String id) {
        Tags tags = (Tags) redisTemplate.opsForHash().get("tags", id);

        if (Objects.nonNull(tags)) {
            return ResultUtil.success(tags);
        }
        tags = tagsMapper.selectById(id);
        if (Objects.isNull(tags)) {
            // 设置过期时间，防止内存击穿
            redisTemplate.opsForHash().put("tags", id, Tags.builder().build());
            redisTemplate.expire("tags", 100, TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForHash().put("tags", id, tags);
        }
        return ResultUtil.success(tags);
    }
}
