package com.springboot.eureka.provider.config;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.eureka.provider.config
 * 类名称:     cloud
 * 类描述:     避免被扫描, 配合启动类注解
 *             @ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {AvoidScan.class})})使用
 * 创建人:     huangyang
 * 创建时间:   2020/4/10 16:32
 */
public @interface AvoidScan {
}
