package com.my.blog.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.blog.config.WebLog;
import com.my.blog.entity.Article;
import com.my.blog.service.IArticleService;
import com.my.blog.util.ResultBean;
import com.my.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 * 文章列表 前端控制器
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@RestController
@RequestMapping
@Validated
public class ArticleController {

    @Autowired
    private IArticleService iArticleService;

    @GetMapping("/queryArticles")
    @WebLog(description = "查询文章列表")
    public ResultBean queryArticles(String key,
                                    @Min(value = 1, message = "最小为1") int offset,
                                    @Min(value = 1,message = "页数最小为1") int limit){

        Page<Article> articleList = iArticleService.queryArticlesByKey(key, offset, limit);

        return ResultUtil.success(articleList);
    }

    @PostMapping("/publishArticle")
    @WebLog(description = "添加文章")
    public ResultBean publishArticle(@Validated Article article) throws UnsupportedEncodingException {

        long articleId = System.currentTimeMillis();
        article.setArticleId(articleId);
        article.setTimeline(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        iArticleService.save(article);
        return ResultUtil.success();
    }
}
