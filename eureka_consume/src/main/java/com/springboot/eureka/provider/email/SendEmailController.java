package com.springboot.eureka.provider.email;

import lombok.extern.slf4j.Slf4j;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.eureka.provider.email
 * 类名称:     SendEmailController
 * 类描述:     发送邮件
 * 创建人:     huangyang
 * 创建时间:   2019/4/4 16:23
 */
@RestController
@Slf4j
public class SendEmailController {

    public static void main(String[] args) {

        System.out.println("send start");

        Email email = EmailBuilder.startingBlank()
                .from("huangyang", "huangyang3@asiainfo.com")
                .to("yellowsunsna@163.com") // ,huangyang3@asiainfo.com
//                .to("chenjq", "chenjq@asiainfo.com")
                .withSubject("Mail send Test")
                .withPlainText("hello world")
                .buildEmail();

        MailerBuilder
                .withSMTPServer("mail.asiainfo.com", 25, "huangyang3@asiainfo.com", "@Asiainfo19950912")
                .buildMailer()
                .sendMail(email);

        System.out.println("send success");
    }

}
