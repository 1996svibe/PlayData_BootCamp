package com.example.demo.user.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendCongratulationsEmail(String recipientEmail) throws MessagingException, jakarta.mail.MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String subject = "로그인 축하 이메일";
        String htmlContent = "<h1>로그인을 성공적으로 완료하였습니다! 축하드립니다!</h1>";

        helper.setFrom("dndwlscjswo87@gmail.com");  // 보내는 사람 이메일
        helper.setTo(recipientEmail);  // 수신자 이메일
        helper.setSubject(subject);
        helper.setText(htmlContent, true);  // HTML 형식의 이메일 본문

        javaMailSender.send(message);
    }
}
