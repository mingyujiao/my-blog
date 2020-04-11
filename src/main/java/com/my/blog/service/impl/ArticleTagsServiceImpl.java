package com.my.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.blog.entity.ArticleTags;
import com.my.blog.mapper.ArticleTagsMapper;
import com.my.blog.service.IArticleTagsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章标签 服务实现类
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@Service
public class ArticleTagsServiceImpl extends ServiceImpl<ArticleTagsMapper, ArticleTags> implements IArticleTagsService {

}
