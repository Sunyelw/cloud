package com.springboot.kafka.producer.three;

import com.springboot.kafka.producer.utils.CommonConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.kafka.producer.three
 * 类名称:     KafkaProducer
 * 类描述:     kafka produce
 * 创建人:     huangyang
 * 创建时间:   2019/5/4 10:15
 */
@Component
@Slf4j
public class KafkaProducer {

    private Map<String, Object> producerConfigs(){
        Map<String, Object> props = new HashMap <> ();
        props.put (ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, CommonConst.BROKER_SERVER);
        props.put (ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put (ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return props;
    }

    @Bean(name = "factoryBoot")
    public ProducerFactory<Integer, String> producerFactory() {
        return new DefaultKafkaProducerFactory <> (producerConfigs ());
    }

    @Bean()
    public KafkaTemplate<Integer, String> kafkaBoot(
            @Qualifier(value = "factoryBoot") ProducerFactory<Integer, String> producerFactory) {
        return new KafkaTemplate <> (producerFactory);
    }
}
