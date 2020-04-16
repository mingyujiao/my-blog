package com.my.blog.controller;


import com.my.blog.config.WebLog;
import com.my.blog.entity.Tags;
import com.my.blog.entity.User;
import com.my.blog.service.ITagsService;
import com.my.blog.service.IUserService;
import com.my.blog.util.ResultBean;
import com.my.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 标签 前端控制器
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@RestController
@RequestMapping("/tags")
public class TagsController {


    @Autowired
    private ITagsService tagsService;

    /**
     * 根据ID获取用户信息，返回user对象
     * @return
     */
    @WebLog(description = "获取文章分类信息")
    @GetMapping("/tags/{tagsId}")
    public ResultBean findTagsById(@PathVariable String tagsId){
        return tagsService.getTagsById(tagsId);
    }

    /**
     * 添加文章分类
     * @param tags
     * @return
     */
    @WebLog(description = "添加文章分类信息")
    @PostMapping("save")
    public ResultBean saveTags(@Validated @RequestBody Tags tags){
        return tagsService.saveOrUpdateTags(tags);
    }

    @WebLog(description = "根据ID文章分类信息")
    @PostMapping("delTags")
    public ResultBean delTags(@Validated @RequestBody Tags tags){
        if (tags.getId() != null) {
            tagsService.removeById(tags.getId());
        }
        return ResultUtil.success(tags);
    }

    @WebLog(description = "获取所有分类信息")
    @PostMapping("getTagsList")
    public ResultBean getTagsList(){
        List<Tags> tagsList = tagsService.list();
        return ResultUtil.success(tagsList);
    }
}
