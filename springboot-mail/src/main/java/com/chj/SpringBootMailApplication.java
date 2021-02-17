package com.chj;

import com.chj.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.io.File;
import java.util.ArrayList;

/**
 * @author ：chj
 * @date ：Created in 2021/2/17 16:40
 * @params :  启动类
 */
@SpringBootApplication
public class SpringBootMailApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMailApplication.class,args);
    }
}

@RestController
class sendMail{
    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("/")
    public String index()throws MessagingException{
        //简单邮件
        mailService.sendSimpleMail("1298365022@qq.com","Simple Mail","第一封简单邮件");

        //HTML 格式邮件（读取页面mail/mail中的内容）
        Context context = new Context();
        context.setVariable("username","我的小号");
        mailService.sendHtmlMail("1298365022@qq.com","HTML Mail",templateEngine.process("mail/mail",context));


        //HTML格式邮件，带附件（读取页面mail/attachment中的内容带附件）
        Context context2  = new Context();
        context2.setVariable("username","我的小号（带附件）");
        ArrayList<File> files = new ArrayList<>();
        //File对象
        files.add(new File("C:\\Users\\Administrator\\Desktop\\上传测试.txt"));
        files.add(new File("C:\\Users\\Administrator\\Desktop\\上传测试2.txt"));
        mailService.sendAttachmentsMail("1298365022@qq.com","Attachments Mail",templateEngine.process("mail/attachment",context2),files);

        return "欢迎访问 springboot-mail，邮件发送成功！";
    }
}
