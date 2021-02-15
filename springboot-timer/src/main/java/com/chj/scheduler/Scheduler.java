package com.chj.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：chj
 * @date ：Created in 2021/2/16 18:50
 * @params :  定时器
 */
@Component
public class Scheduler {
    private final static Logger log = LoggerFactory.getLogger(Scheduled.class);

    @Scheduled(cron = "0/30 * * * * ?")
    public void test(){
        log.info("这句话每30秒打印一次   "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.err.println("这句话每30秒打印一次   "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
