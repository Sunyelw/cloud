package com.springboot.kafka.producer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.kafka.producer.consumer
 * 类名称:     KafkaListener
 * 类描述:     kafka @Listener
 * 创建人:     huangyang
 * 创建时间:   2019/5/4 11:13
 */
@Component
@Slf4j
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "sunic", containerFactory = "factoryBoot")
    public void listen() {

    }

}
