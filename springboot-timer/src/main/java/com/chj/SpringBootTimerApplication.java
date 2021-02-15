package com.chj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author ：chj
 * @date ：Created in 2021/2/16 18:48
 * @params :  启动类
 */
@SpringBootApplication
@EnableScheduling//允许支持定时器
public class SpringBootTimerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTimerApplication.class,args);
    }
}
