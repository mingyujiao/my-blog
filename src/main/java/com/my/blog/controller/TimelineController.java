package com.my.blog.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.blog.entity.Timeline;
import com.my.blog.service.ITimelineService;
import com.my.blog.util.ResultBean;
import com.my.blog.util.ResultUtil;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

/**
 * <p>
 * 时间轴 前端控制器
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@RestController
@RequestMapping
@Validated
@Slf4j
public class TimelineController {

    @Autowired
    private ITimelineService timelineService;

    @GetMapping("/getTimeline")
    public ResultBean getTimeline(@Min(value = 1, message = "最小为1") int offset,
                                  @Min(value = 1,message = "页数最小为1") int limit){
        Page<Timeline> page = new Page<>(offset, limit);

        Page<Timeline> timelinePage = timelineService.page(page, Wrappers.<Timeline>lambdaQuery().orderByDesc(Timeline::getId));

        return ResultUtil.success(timelinePage);
    }

}
