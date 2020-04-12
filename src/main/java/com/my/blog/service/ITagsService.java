package com.my.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.my.blog.entity.Tags;
import com.my.blog.util.ResultBean;

/**
 * <p>
 * 标签 服务类
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
public interface ITagsService extends IService<Tags> {
    ResultBean<Tags> saveOrUpdateTags(Tags tags);

    ResultBean<Tags> getTagsById(String id);
}
