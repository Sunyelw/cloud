package com.springboot.kafka.consumer.listener.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "seckafka.consumer")
@Data
public class SecKafkaConsumerProperties {
    private String servers;

    private int retries;

    private int batchSize;

    private int bufferMemory;

    private String groupId;

    private int autoCommitInterval;

    private int sessionTimeout;

    private String autoOffsetReset;

    private int concurrency;

    private int pollTimeout;
}
