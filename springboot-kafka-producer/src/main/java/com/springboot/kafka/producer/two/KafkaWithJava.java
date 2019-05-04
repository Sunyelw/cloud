package com.springboot.kafka.producer.two;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.kafka.producer.two
 * 类名称:     kafkaWithJava
 * 类描述:     With Java Configuration
 * 创建人:     huangyang
 * 创建时间:   2019/5/3 12:38
 */
@Component
@Slf4j
public class KafkaWithJava {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaJava;

    public void javaSend() {

        kafkaJava.send ("sunic", "This is a message which send with java config=====");
        kafkaJava.flush ();
    }
}
