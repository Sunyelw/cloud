package com.springboot.kafka.consumer.listener.kafkaconsumer;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.Collections;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.kafka.consumer.listener.kafkaconsumer
 * 类名称:     HandleConsumer
 * 类描述:     手动消费
 * 创建人:     huangyang
 * 创建时间:   2019/6/28 15:22
 */
@RestController
@Slf4j
public class HandleConsumer {


    @Autowired
    private KafkaConsumer<String, String> secKafkaConsumer;

    @RequestMapping("/consume")
    public String consumer() {

        String respStr = "message is：";

        TopicPartition tp = new TopicPartition("sun-topic", 2);
        // 订阅Topic
        secKafkaConsumer.assign(Collections.singletonList(tp));
        // 拉取消息
        ConsumerRecords<String, String> records = secKafkaConsumer.poll(Duration.ofMillis(1000).toMillis());
        // 消费处理
        for (ConsumerRecord<String, String> record : records) {

            log.error("topic: {}", record.topic());
            log.error("partition: {}", record.partition());
            log.error("offset: {}", record.offset());
            log.error("key: {}", record.key());
            log.error("value: {}", record.value());

            respStr += JSONObject.toJSONString(record);
        }

        return respStr;
    }
}
