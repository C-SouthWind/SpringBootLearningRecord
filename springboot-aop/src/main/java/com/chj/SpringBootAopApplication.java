package com.chj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：chj
 * @date ：Created in 2021/2/15 16:35
 * @params :  aop启动类
 */
@RestController
@SpringBootApplication
public class SpringBootAopApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class,args);
    }

    @RequestMapping("/")
    public String index(){
        return "欢迎访问 springboot-aop";
    }
}
