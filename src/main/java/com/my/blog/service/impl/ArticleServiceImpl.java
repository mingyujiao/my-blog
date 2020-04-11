package com.my.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.blog.entity.Article;
import com.my.blog.mapper.ArticleMapper;
import com.my.blog.service.IArticleService;
import org.springframework.stereotype.Service;

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

}
