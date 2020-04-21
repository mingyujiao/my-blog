package com.my.blog.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.blog.entity.MessageBoard;
import com.my.blog.mapper.MessageBoardMapper;
import com.my.blog.service.IMessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 留言 服务实现类
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@Service
public class MessageBoardServiceImpl extends ServiceImpl<MessageBoardMapper, MessageBoard> implements IMessageBoardService {

    @Autowired
    private MessageBoardMapper boardMapper;

    @Override
    public Page<MessageBoard> selectPage(Page<MessageBoard> page) {

        Page<MessageBoard> boardList = boardMapper.selectPage(page, Wrappers.<MessageBoard>lambdaQuery().orderByDesc(MessageBoard :: getId));

        return boardList;
    }
}
