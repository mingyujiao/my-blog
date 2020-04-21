package com.my.blog.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2020/4/21 20:42
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public Producer producer() {
        Properties properties = new Properties();
        properties.put(Constants.KAPTCHA_BORDER, "no");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "236,56,56");
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "241,220,190");
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_TO, "255,255,255");
        properties.put(Constants.KAPTCHA_NOISE_COLOR, "240,129,85");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, 5);

        Config config = new Config(properties);

        DefaultKaptcha producer = new DefaultKaptcha();
        producer.setConfig(config);

        return producer;
    }
}
