package com.chj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：chj
 * @date ：Created in 2021/2/17 15:16
 * @params :  启动类
 */

//jar包
@SpringBootApplication
public class SpringBootJarWarApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJarWarApplication.class,args);
    }
}
/*
//War包
@SpringBootApplication
class SpringbooWarApplication extends SpringBootServletInitializer implements WebApplicationInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbooWarApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbooWarApplication.class, args);
    }
}*/

/**
 * 测试controller
 */
@RestController
class IndexController{

    @GetMapping("/")
    String index(){
        return "欢迎访问 springboot-jar-war";
    }
}