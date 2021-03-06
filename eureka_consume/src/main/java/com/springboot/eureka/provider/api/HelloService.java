package com.springboot.eureka.provider.api;

import com.springboot.eureka.provider.config.RibbonBalanceRuleConfig;
import com.springboot.eureka.provider.config.FeignClientConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 项目名称:   pinkstone
 * 包:        com.migu.pinkstone.service
 * 类名称:     HelloService
 * 类描述:     hello world
 * 创建人:     huangyang
 * 创建时间:   2019/4/3 10:13
 */
@EnableConfigurationProperties()
@Configuration
@RibbonClient(name = "ribbon-eureka-provider", configuration = RibbonBalanceRuleConfig.class)
@FeignClient(value = "eureka-provider", configuration = FeignClientConfig.class)
public interface HelloService {

    @RequestMapping(value = "/home", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    String home();
}
