package com.my.blog.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.blog.config.WebLog;
import com.my.blog.entity.MessageBoard;
import com.my.blog.entity.User;
import com.my.blog.service.IMessageBoardService;
import com.my.blog.util.ResultBean;
import com.my.blog.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 留言 前端控制器
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@RestController
@RequestMapping
@Slf4j
public class MessageBoardController {

    @Autowired
    private IMessageBoardService iMessageBoardService;

    @WebLog(description = "获取留言")
    @GetMapping("/getMessageBoard")
    public ResultBean getMessageBoard(int offset, int limit){
        Page<MessageBoard> page = new Page<>(offset, limit);
        Page<MessageBoard> boardList = iMessageBoardService.selectPage(page);
        return ResultUtil.success(boardList);
    }

    @WebLog(description = "保存留言信息")
    @PostMapping("/messageBoardSave")
    public ResultBean saveMessageBoard(@Valid @RequestBody MessageBoard board){
        board.setCreateTime(LocalDateTime.now());
        iMessageBoardService.save(board);
        return ResultUtil.success();
    }

    @WebLog(description = "根据ID查询留言信息")
    @GetMapping("/messageBoard/{id}")
    public ResultBean findUserById(@NotNull(message = "ID不能为空") @PathVariable String id){
        MessageBoard board = iMessageBoardService.getById(id);
        return ResultUtil.success(board);
    }
}
