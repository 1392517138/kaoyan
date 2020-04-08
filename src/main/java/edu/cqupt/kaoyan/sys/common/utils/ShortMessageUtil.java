package edu.cqupt.kaoyan.sys.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author piwenjing
 * @description
 * @date 2020/3/27 2:05 PM
 */
@Service
public class ShortMessageUtil {
    @Resource
    private JavaMailSenderImpl mailSender;
    //    @Autowired
//    RabbitTemplate rabbitTemplate;

    @Value("${spring.mail.username}")
    private String from;
    @Value("${spring.mail.title}")
    private String title;
    @Value("${spring.mail.content}")
    private String content;

    public void sendMail(String[] to) {
        System.out.println("---to" + to[0]);
        System.out.println("titile:" + title);
        System.out.println("---from" + from);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to[0]);
        message.setSubject(title);
        double ranom = Math.random() * 1000000;
        //随机生成6位验证码
        String param = String.valueOf((int) ranom);
        message.setText(content + ": " + param);
//        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_DIRECT_INFORM, RabbitmqConfig.routingKey,
//                message);

        mailSender.send(message);
    }
}
