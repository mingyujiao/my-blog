package com.my.blog.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2020/4/9 19:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean<T> {
    private Integer code;
    private String msg;
    private boolean succ;
    private T data;
}
