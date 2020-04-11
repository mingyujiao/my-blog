package com.my.blog.config;

import java.lang.annotation.*;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2020/4/11 21:24
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {

    /**
     * 日志描述信息
     *
     * @return
     */
    String description() default "";
}
