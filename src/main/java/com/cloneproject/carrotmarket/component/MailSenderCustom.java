package com.cloneproject.carrotmarket.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class MailSenderCustom {

    @Value("${email.corpName}")
    String email_corpName;

    @Value("${spring.mail.username}")
    String from_email;

    /* =========== MimeMessageHelper 관련 Method =============
     * setFrom(String from)  발신자 설정
     * setReplyTo(String replyTo)  응답 주소 설정
     * setTo(String to)  수신자 설정
     * setTo(String[] to) 수신자 목록 설정
     * setCc(String cc) 참조자 설정
     * setCc(String[] cc) 참조자 목록 설정
     * setBcc(String bcc) 숨은 참조자 설정
     * setBcc(String[] bcc) 숨은 참조자 목록 설정
     * setSentDate(Date sentDate) 메일 발송일 설정
     * setSubject(String subject) 메일 제목 설정
     * setText(String text) 메일 내용 설정
     * setText(String text,true) 메일 내용 설정( html tag 적용시)
     */

    @Resource
    private JavaMailSender mailSender;

    protected final Logger logger = LogManager.getLogger(this.getClass());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");



    public void sendEmailSimple(Map<String, Object> senderInfo) {
        try {

            logger.info("sendEmailSimple : " + dateFormat.format(new Date()));
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper msgHelper = new MimeMessageHelper(message, true, "UTF-8");

            msgHelper.setSubject(senderInfo.get("subject").toString());
            msgHelper.setText(senderInfo.get("msg").toString(),true);
            msgHelper.setFrom(from_email, email_corpName); // 발신자
            msgHelper.setTo(senderInfo.get("toAddress").toString()); // 수신자
            //msgHelper.setCc((String[])(senderInfo.get("CcAddress")));

            logger.info("----------------------> send Start : " + dateFormat.format(new Date()) );
            logger.info("fromAddress : "+from_email);
            logger.info("toAddress : "+senderInfo.get("toAddress"));
            mailSender.send(message);
            logger.info("----------------------> send End : "+ dateFormat.format(new Date()) );

        }
        catch (Exception e) {
            if (logger.isDebugEnabled()) {
                logger.debug(e.toString());
                e.printStackTrace();
            }
        }

    }

}
