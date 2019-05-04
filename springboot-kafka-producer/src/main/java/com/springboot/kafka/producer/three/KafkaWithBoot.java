package com.springboot.kafka.producer.three;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.kafka.producer.three
 * 类名称:     KafkaWithBoot
 * 类描述:     Even Quicker, with Spring Boot
 * 创建人:     huangyang
 * 创建时间:   2019/5/3 13:23
 */
@Component
@Slf4j
public class KafkaWithBoot {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaBoot;

    // ListenableFutureCallback

    public void sendKafka() {

        ListenableFuture<SendResult<Integer, String>> future = kafkaBoot.send ("sunic", "boot send");
        future.addCallback (new ListenableFutureCallback<SendResult<Integer, String>> () {

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                log.error ("Send SUCCESS: {}", result.toString ());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error ("Send ERROR: {}", ex.getMessage (), ex);
            }

        });
    }
}
