package com.my.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.my.blog.entity.Article;

import java.util.List;

/**
 * <p>
 * 文章列表 服务类
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
public interface IArticleService extends IService<Article> {

    Page<Article> queryArticlesByKey(String key, Integer offset, Integer limit);
}
