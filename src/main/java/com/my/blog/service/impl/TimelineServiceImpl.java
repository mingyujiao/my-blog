package com.my.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.blog.entity.Timeline;
import com.my.blog.mapper.TimelineMapper;
import com.my.blog.service.ITimelineService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 时间轴 服务实现类
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@Service
public class TimelineServiceImpl extends ServiceImpl<TimelineMapper, Timeline> implements ITimelineService {

}
