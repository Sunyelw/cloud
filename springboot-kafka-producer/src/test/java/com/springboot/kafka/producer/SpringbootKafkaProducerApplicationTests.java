package com.springboot.kafka.producer;

import com.springboot.kafka.producer.one.KafkaSimple;
import com.springboot.kafka.producer.three.KafkaWithBoot;
import com.springboot.kafka.producer.two.KafkaWithJava;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootKafkaProducerApplicationTests {


//    /**
//     *  first
//     */
//
//    @Autowired
//	private KafkaSimple kafkaSimple;
//
//	@Test
//	public void contextLoads() {
//
//        try {
//            kafkaSimple.simpleSendAndReceive();
//        } catch (Exception e) {
//            e.printStackTrace ();
//        }
//
//    }
//
//    /**
//     * second
//     */
//
//    @Autowired
//    private KafkaWithJava kafkaWithJava;
//
//    @Test
//    public void sendWithJava() {
//
//        kafkaWithJava.javaSend ();
//    }

    /**
     * third
     */

    @Autowired
    private KafkaWithBoot kafkaWithBoot;

    @Test
    public void sendWithBoot() {

        kafkaWithBoot.sendKafka ();
    }

}
