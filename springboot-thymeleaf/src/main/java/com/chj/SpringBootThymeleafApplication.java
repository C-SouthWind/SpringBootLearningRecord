package com.chj;

import com.chj.model.UserVo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author ：chj
 * @date ：Created in 2021/2/16 19:19
 * @params :  启动类
 */
@SpringBootApplication
@Controller
public class SpringBootThymeleafApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootThymeleafApplication.class,args);
    }

    @RequestMapping("/")
    public ModelAndView index(){
        ArrayList<UserVo> userVos = new ArrayList<>();
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setUsername("chj1");
        userVo.setPassword("1234");
        userVo.setCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        userVos.add(userVo);
        UserVo userVo2 = new UserVo();
        userVo2.setId(2);
        userVo2.setUsername("chj2");
        userVo2.setPassword("12345");
        userVo2.setCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        userVos.add(userVo2);

        ModelAndView mv=new ModelAndView();
        mv.addObject("newText","你好，springboot-thymeleaf");
        mv.addObject("gender","1");
        mv.addObject("userList",userVos);
        mv.addObject("loginUser",userVo);
        mv.setViewName("index.html");
        return mv;
    }
}
