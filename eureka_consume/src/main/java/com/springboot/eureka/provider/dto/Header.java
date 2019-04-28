package com.springboot.eureka.provider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目名称:   pinkstone
 * 包:        com.migu.pinkstone.common.dto.request
 * 类名称:     com.migu.pinkstone.common.dto.Header
 * 类描述:     发送短信 请求头
 * 创建人:     huangyang
 * 创建时间:   2019/4/2 20:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Header {

    /**
     * 设备来源码(短信服务提供分配的编码)
     */
    private String sourceDeviceCode;

    /**
     * 认证来源秘钥=SHA256加密串（短信服务提供分配）+空格+时间戳
     */
    private String authenticatorSource;
}
