package com.my.blog.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.blog.entity.Article;
import com.my.blog.entity.Timeline;
import com.my.blog.mapper.ArticleMapper;
import com.my.blog.mapper.TimelineMapper;
import com.my.blog.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Autowired
    private TimelineMapper timelineMapper;

    @Override
    public Page<Article> queryArticlesByKey(String key, Integer offset, Integer limit) {

        Page<Article> page = new Page<>(offset, limit);

        return articleMapper.selectPage(page, Wrappers.<Article>lambdaQuery().like(Article::getArticleTitle, key).or().like(Article::getCategories, key));
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public void saveArticle(Article article) {

        long articleId = System.currentTimeMillis();

        String timeLine = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);

        Timeline timeline = Timeline.builder().build().setTimeline(timeLine).setCreateTime(LocalDateTime.now());

        timelineMapper.insert(timeline);

        article.setArticleId(articleId);
        article.setTimeline(timeLine);
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        articleMapper.insert(article);
    }

    @Override
    public Page<Article> queryArticleListByTimeLine(String timeLine, Integer offset, Integer limit) {
        Page<Article> page = new Page<>(offset, limit);

        return articleMapper.selectPage(page, Wrappers.<Article>lambdaQuery().eq(Article::getTimeline, timeLine));
    }

    @Override
    public Page<Article> queryArticleListByVisits(Integer offset, Integer limit) {

        Page<Article> page = new Page<>(offset, limit);

        return articleMapper.selectPage(page, Wrappers.<Article>lambdaQuery().orderByDesc(Article::getVisits));
    }
}
