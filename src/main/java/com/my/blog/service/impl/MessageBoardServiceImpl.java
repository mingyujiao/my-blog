package com.my.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.blog.entity.MessageBoard;
import com.my.blog.mapper.MessageBoardMapper;
import com.my.blog.service.IMessageBoardService;
import org.springframework.stereotype.Service;

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

}
