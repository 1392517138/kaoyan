package edu.cqupt.kaoyan.service.mail;

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
public class MailService {
    @Resource
    private JavaMailSenderImpl mailSender;
    //    @Autowired
//    RabbitTemplate rabbitTemplate;

    @Value("${spring.mail.username}")
    private String from;
    @Value("${spring.mail.title}")
    private String title;

    public void sendMail(String[] to, String content) {
        System.out.println("---to" + to[0]);
        System.out.println("titile:" + title);
        System.out.println("---from" + from);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to[0]);
        message.setSubject(title);
        message.setText(content);
//        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_DIRECT_INFORM, RabbitmqConfig.routingKey,
//                message);

        mailSender.send(message);
    }
}
