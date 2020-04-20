package com.my.blog.controller;


import com.my.blog.config.WebLog;
import com.my.blog.util.ResultBean;
import com.my.blog.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 留言 前端控制器
 * </p>
 *
 * @author jiaomingyu5778@gmail.com
 * @since 2020-04-07
 */
@RestController
@RequestMapping("/messageBoard")
public class MessageBoardController {

    @WebLog(description = "获取留言")
    @GetMapping("/getMessageBoard")
    public ResultBean getMessageBoard(){
        return ResultUtil.success();
    }
}
