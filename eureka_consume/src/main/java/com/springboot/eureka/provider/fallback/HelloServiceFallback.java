package com.springboot.eureka.provider.fallback;

import com.springboot.eureka.provider.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.eureka.provider.fallback
 * 类名称:     HelloServiceFallback
 * 类描述:     1
 * 创建人:     huangyang
 * 创建时间:   2020/4/12 18:46
 */
@Component
@Slf4j
public class HelloServiceFallback implements HelloService {

    @Override
    public String home(){
        log.error("fallback_from_hello...");
        return "error return";
    }

//    @Override
//    public HelloService create(Throwable throwable){
//        log.error("fallback_from_hello...");
//        return null;
//    }
}
