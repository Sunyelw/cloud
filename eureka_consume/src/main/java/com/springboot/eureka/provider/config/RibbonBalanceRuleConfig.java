package com.springboot.eureka.provider.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.eureka.provider.config
 * 类名称:     RibbonBalanceRuleConfig
 * 类描述:     负载策略
 * 创建人:     huangyang
 * 创建时间:   2020/4/10 14:07
 */
@Configuration
@AvoidScan
public class RibbonBalanceRuleConfig {

    @Bean
    public IRule ribbonRule() {
        return new HyRule();
    }
}
