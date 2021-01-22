package com.example.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@SpringBootTest
class MailApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    // *发送普通文本的邮件
    @Test
    public void sendSimpleMail(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("这是一封测试邮件");
        simpleMailMessage.setFrom("596318128@qq.com");
        simpleMailMessage.setTo("yuhaofeng1997@gmail.com");
//        simpleMailMessage.setCc();
//        simpleMailMessage.setSentDate(new Date(2020,11,28));
        simpleMailMessage.setText("这是测试邮件正文");
        javaMailSender.send(simpleMailMessage);
    }

    // *发送带附件的邮件
    @Test
    public void sendAttachFileMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是测试邮件的主题");
        helper.setFrom("596318128@qq.com");
        helper.setTo("yuhaofeng1997@gmail.com");
        helper.setText("这是测试邮件的正文");
        helper.setSentDate(new Date());
        helper.addAttachment("开题报告", new File("/Users/yuhao/Downloads/开题报告.docx"));
        javaMailSender.send(mimeMessage);
    }

    // *发送带图片的资源
    @Test
    public void sendImgResMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是一封测试发送图片的邮件");
        helper.setFrom("596318128@qq.com");
        helper.setTo("yuhaofeng1997@gmail.com");
        helper.setSentDate(new Date());
        helper.setText(
                "<p> hello 大家好，这是一封测试邮件，这封邮件包含两幅图片，分别如下</p>" +
                        "<p>第一张图片:</p><img src='p01'/>" +
                        "<p>第二张图片:</p><img src='p02'>"
        ,true);
        helper.addInline("p01", new File("/Users/yuhao/Downloads/QQ20201118-154530@2x.png"));
        helper.addInline("p02", new File("/Users/yuhao/Downloads/QQ20201119-174410@2x.png"));
        javaMailSender.send(mimeMessage);
    }

    // *通过Thymeleaf模板发送邮件
    @Autowired
    TemplateEngine templateEngine;

    @Test
    public void sendThymeleafMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是一封测试邮件，实现方式是Thymeleaf");
        helper.setFrom("596318128@qq.com");
        helper.setTo("yuhaofeng1997@gmail.com");
        helper.setSentDate(new Date());

        Context context = new Context();
        context.setVariable("username", "冯宇豪");
        context.setVariable("num", "10086");
        context.setVariable("salary", 8000);
        String process = templateEngine.process("mail.html", context);
        helper.setText(process, true);
        javaMailSender.send(mimeMessage);
    }
}
