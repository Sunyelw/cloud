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
public class TaskOne {

    @Scheduled(cron = "0 7 0 * * ?")
    public void taskRn() throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        Thread th = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread th1 = Thread.currentThread();
                    System.out.println(th1.getName() + " xxx " + i + " yyy");
                    th1.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        th.start();


        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " === " + i);
            Thread.currentThread().sleep(1000);
        }
    }
}
