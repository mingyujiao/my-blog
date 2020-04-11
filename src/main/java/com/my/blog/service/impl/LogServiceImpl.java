package com.my.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.blog.entity.Log;
import com.my.blog.mapper.LogMapper;
import com.my.blog.service.ILogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志 服务实现类
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
