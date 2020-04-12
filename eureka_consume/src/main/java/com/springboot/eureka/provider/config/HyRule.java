package com.springboot.eureka.provider.config;

import com.netflix.loadbalancer.RandomRule;
import lombok.extern.slf4j.Slf4j;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.eureka.provider.config
 * 类名称:     HyRule
 * 类描述:     测试 ribbon 并发策略
 * 创建人:     huangyang
 * 创建时间:   2020/4/10 15:47
 */
@Slf4j
class HyRule extends RandomRule {

    HyRule() {
        super();
        log.error("hy_rule_load...");
    }
}
