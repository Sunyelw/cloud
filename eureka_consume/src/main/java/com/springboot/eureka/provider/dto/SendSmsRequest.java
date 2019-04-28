package com.springboot.eureka.provider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目名称:   pinkstone
 * 包:        com.migu.pinkstone.common.dto.request
 * 类名称:     com.migu.pinkstone.common.dto.SendSmsRequest
 * 类描述:     发送短信对象
 * 创建人:     huangyang
 * 创建时间:   2019/4/2 20:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendSmsRequest {

    /**
     * 请求头
     */
    private Header header;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 发送的手机号列表，多个地址以英文逗号分隔
     */
    private String addresses;

    /**
     * 发件人名称
     */
    private String senderName;

    /**
     * 短信内容
     */
    private String message;

    /**
     * 状态：event（事件）、alarm（告警）、alarm_recovery（告警恢复）
     */
    private String status;

    /**
     * 级别：serious（严重）、general（一般）、prompt（提示）
     */
    private String level;

    /**
     * 二级系统名称
     */
    private String secondarySys;

    /**
     * 一级系统名称
     */
    private String firstSys;
}
