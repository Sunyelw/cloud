package com.springboot.eureka.provider.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.eureka.provider.config
 * 类名称:     AutoCompleteConfig
 * 类描述:     配置文件自动提示
 * @see: spring-configuration-metadata.json / @EnableConfigurationProperties({AutoCompleteConfig.class})
 * 创建人:     huangyang
 * 创建时间:   2020/4/12 9:35
 */
@Data
@ConfigurationProperties(prefix = "hy.msg")
public class AutoCompleteConfig {

    private String name;
}
