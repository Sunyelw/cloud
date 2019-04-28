package com.springboot.eureka.provider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目名称:   pinkstone
 * 包:        com.migu.pinkstone.common.dto.response
 * 类名称:     com.migu.pinkstone.common.dto.SendSmsResponse
 * 类描述:     发送短信响应
 * 创建人:     huangyang
 * 创建时间:   2019/4/2 20:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendSmsResponse {

    /**
     * 响应码
     */
    private String resultCode;

    /**
     * 描述
     */
    private String resultMessage;

    /**
     * 唯一值uuid
     */
    private String uuid;
}
