package com.chj;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：chj
 * @date ：Created in 2021/2/16 19:03
 * @params :  启动类
 */
@SpringBootApplication
public class SpringBootBannerApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new  SpringApplication(SpringBootBannerApplication.class);
        //banner 默认开始  如果想关闭
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
