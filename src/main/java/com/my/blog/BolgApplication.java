package com.my.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jiaomingyu5778@gmail.com
 */
@SpringBootApplication
@MapperScan("com.my.blog.mapper")
public class BolgApplication {

    public static void main(String[] args) {
        SpringApplication.run(BolgApplication.class, args);
    }

}
