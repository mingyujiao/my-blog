package com.my.blog.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.my.blog.config.WebLog;
import com.my.blog.util.ResultBean;
import com.my.blog.util.ResultEnum;
import com.my.blog.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2020/4/21 19:49
 */
@RestController
@RequestMapping("/captcha")
@Slf4j
public class KaptchaController {

    @Autowired
    public Producer producer;

    @GetMapping("/get")
    public void get(HttpSession session, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        log.info("生成验证码：captcha:{}", text);
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    @PostMapping("/verify")
    @ResponseBody
    public ResultBean verify(String captcha, HttpSession session) {
        String sessionCaptcha = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!StringUtils.hasLength(sessionCaptcha)) {
            return ResultUtil.error(ResultEnum.NOT_GET_CAPTCHA.getCode(), ResultEnum.NOT_GET_CAPTCHA.getMsg());
        }

        if (!sessionCaptcha.equalsIgnoreCase(captcha)) {
            return ResultUtil.error(ResultEnum.CAPTCHA_VERIFY_FAILED.getCode(), ResultEnum.CAPTCHA_VERIFY_FAILED.getMsg());
        }
        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, System.currentTimeMillis());
        return ResultUtil.success();
    }

}