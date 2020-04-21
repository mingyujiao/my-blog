package com.my.blog.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.blog.entity.Article;
import com.my.blog.mapper.ArticleMapper;
import com.my.blog.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 文章列表 服务实现类
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Page<Article> queryArticlesByKey(String key, Integer offset, Integer limit) {

        Page<Article> page = new Page<>(offset, limit);

        Page<Article> pageList = articleMapper.selectPage(page, Wrappers.<Article>lambdaQuery().like(Article::getArticleTitle, key));

        return pageList;
    }
}
