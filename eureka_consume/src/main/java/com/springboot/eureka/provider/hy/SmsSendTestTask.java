package com.springboot.eureka.provider.hy;


import com.springboot.eureka.provider.dto.Header;
import com.springboot.eureka.provider.dto.JsonUtil;
import com.springboot.eureka.provider.dto.SendSmsRequest;
import com.springboot.eureka.provider.dto.SendSmsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称:   pinkstone
 * 包:        com.migu.pinkstone.hy
 * 类名称:     SmsSendTestTask
 * 类描述:     生产短信_发送task
 * 创建人:     huangyang
 * 创建时间:   2019/4/3 9:50
 */
@Slf4j
@RestController
public class SmsSendTestTask {

    @Autowired
    private SendSmsService sendSmsService;

    @RequestMapping("/task")
    public String test() {

        SendSmsResponse response;
        try {
            log.error("send_sms start");

            SendSmsRequest req = new SendSmsRequest();
            req.setBizType("anime_sys");
            req.setAddresses("18362988370,15295530907");
            req.setMessage("HY发送测试短信：系统短信");
            req.setStatus("alarm"); // 事件
            req.setLevel("prompt"); // 提示
            req.setFirstSys("咪咕能力平台");
            req.setSecondarySys("用户中心");
            req.setSenderName("10658099617");

            Header header = new Header();
            header.setSourceDeviceCode("100001");
            String str = "9a693e9333c615470690d73016cb312afea8f4d1f423f106642c0f75beaa10b9 20190404171010";
            header.setAuthenticatorSource(SmsHandleUtil.encryptAES(str));
//            req.setHeader(header);

            log.error("sms_authenticatorSource_before: {}", str);

            log.error("sms_req: {}", JsonUtil.objectToString(req));

            response = sendSmsService.sendSms(req);

            log.error("sms_resp: {}", JsonUtil.objectToString(response));
        } catch (Exception e) {
            log.error("sms_error: {}", e.getMessage(), e);
            response = null;
        }

        return JsonUtil.objectToString(response);
    }
}
