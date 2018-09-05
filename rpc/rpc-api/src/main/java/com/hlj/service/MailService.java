package com.hlj.service;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.File;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-13.
 */
//@Service
public class MailService {
//
//    @Autowired
//    private JavaMailSenderImpl mailSender;
//
//    public void sendSimpleMail(String to, String subject, String content) {
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setTo(to);
//        simpleMailMessage.setFrom("lianglevel@163.com");
//        simpleMailMessage.setSubject("Spring Boot Mail 邮件测试【文本】");
//        simpleMailMessage.setText("这里是一段简单文本。");
//        mailSender.send(simpleMailMessage);
//    }
//
//    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
//        MimeMessage message = mailSender.createMimeMessage();
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom("18345979265@163.com");
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText(content, true);
//
//            FileSystemResource file = new FileSystemResource(new File(filePath));
//            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
//            helper.addAttachment(fileName, file);
//
//            mailSender.send(message);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
}