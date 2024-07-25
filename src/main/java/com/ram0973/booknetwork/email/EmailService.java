package com.ram0973.booknetwork.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.mail.javamail.MimeMessageHelper.MULTIPART_MODE_MIXED;

@Service
@Log4j2
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender = new JavaMailSenderImpl();
    private final SpringTemplateEngine templateEngine;

    @Value("${application.mailing.admin-email}")
    private String adminEmail;

    @Async
    public void sendEmail(String to, String username, EmailTemplateName emailTemplate, String confirmationUrl,
                          String activationCode, String subject
    ) throws MessagingException {
        String templateName = (emailTemplate == null) ? "confirm-email" : emailTemplate.name();
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MULTIPART_MODE_MIXED, UTF_8.name());
        Map<String, Object> properties = new HashMap<>();
        properties.put("username", username);
        properties.put("confirmationUrl", confirmationUrl);
        properties.put("activation_code", activationCode);
        var context = new Context();
        context.setVariables(properties);
        helper.setFrom(adminEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        String template = templateEngine.process(templateName, context);
        helper.setText(template, true);
        mailSender.send(mimeMessage);
    }
}
