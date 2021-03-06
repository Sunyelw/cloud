package com.spring.task.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 项目名称:   pinkstone
 * 包:        com.spring.task.schedule
 * 类名称:     TaskOne
 * 类描述:     task one
 * 创建人:     huangyang
 * 创建时间:   2019/4/8 18:54
 */
@Component
public class TaskThree {

    @Scheduled(cron = "0/1 * * * 2 ?")
    public void taskThree() throws InterruptedException {

        System.out.println("TaskThree start..");
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + " THREE =====================" + i + "==========");
        }
        System.out.println("TaskThree end..");
    }
}
