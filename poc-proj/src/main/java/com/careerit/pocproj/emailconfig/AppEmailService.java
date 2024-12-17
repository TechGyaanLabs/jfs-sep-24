package com.careerit.pocproj.emailconfig;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class AppEmailService {



    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendEmail(SendEmailRequestDto request) {
        JavaMailSender javaMailSender = EmailConfigFactory.getEmailConfig(MailProvider.SMTP);
        try {
            if (request.isHtml()) {
                sendEmailWithHtmlContent(request,javaMailSender);
            } else {
                sendEmailWithPlainText(request,javaMailSender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendEmailWithPlainText(SendEmailRequestDto request,JavaMailSender mailSender) throws Exception {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(fromEmail);
        mailMessage.setTo(convertListToArray(request.getToEmails()));

        if (!CollectionUtils.isEmpty(request.getCcEmails())) {
            mailMessage.setCc(convertListToArray(request.getCcEmails()));
        }
        if (!CollectionUtils.isEmpty(request.getBccEmails())) {
            mailMessage.setBcc(convertListToArray(request.getBccEmails()));
        }

        mailMessage.setSubject(request.getSubject());
        mailMessage.setText(resolvePlaceholders(request.getBody(), request.getKeyValuePairs()));
        mailSender.send(mailMessage);
    }

    private void sendEmailWithHtmlContent(SendEmailRequestDto request,JavaMailSender mailSender) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom(fromEmail);
        mimeMessageHelper.setTo(convertListToArray(request.getToEmails()));

        if (!CollectionUtils.isEmpty(request.getCcEmails())) {
            mimeMessageHelper.setCc(convertListToArray(request.getCcEmails()));
        }
        if (!CollectionUtils.isEmpty(request.getBccEmails())) {
            mimeMessageHelper.setBcc(convertListToArray(request.getBccEmails()));
        }

        mimeMessageHelper.setSubject(request.getSubject());
        mimeMessageHelper.setText(resolvePlaceholders(request.getBody(), request.getKeyValuePairs()), true);

        if (!CollectionUtils.isEmpty(request.getAttachments())) {
            for (String attachment : request.getAttachments()) {
                File file = new File(attachment);
                mimeMessageHelper.addAttachment(file.getName(), file);
            }
        }

        mailSender.send(mimeMessage);
    }

    private String[] convertListToArray(List<String> list) {
        return list == null ? new String[0] : list.toArray(new String[0]);
    }

    private String resolvePlaceholders(String text, Map<String,Object> keyValuePairs) {
        return StringSubstitutor.replace(text, keyValuePairs);
    }
}
