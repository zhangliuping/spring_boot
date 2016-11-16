package com.aug.demo.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
// @EnableScheduling
public class SchedulingConfig {

    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0/5 * * * * ?") // 每20秒执行一次
    public void scheduler() {
        System.out.println("scheduler : " + format.format(new Date()));
    }

    @Scheduled(fixedRate = 3000) // 每20秒执行一次
    public void scheduler1() {
        System.out.println("scheduler1 : " + format.format(new Date()));
    }
}
