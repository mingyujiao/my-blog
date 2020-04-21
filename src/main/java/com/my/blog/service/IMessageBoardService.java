package com.my.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.my.blog.entity.MessageBoard;

import java.util.List;

/**
 * <p>
 * 留言 服务类
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
public interface IMessageBoardService extends IService<MessageBoard> {
    Page<MessageBoard> selectPage(Page<MessageBoard> page);
}
