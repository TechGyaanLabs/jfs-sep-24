package com.careerit.pocproj.emailconfig;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailConfigFactory {

    public static JavaMailSender getEmailConfig(MailProvider provider){
        switch (provider){
            case SMTP:
                EmailConfig emailConfig =  getSmtpConfig();
                return getJavaMailSender(emailConfig);
            case SENDGRID:
                break;
            case SES:
                break;
            default:
                throw new IllegalArgumentException("Invalid mail provider");
        }
        return null;
    }

    private static JavaMailSender getJavaMailSender(EmailConfig emailConfig) {

        SmtpEmailConfig smtpEmailConfig = (SmtpEmailConfig) emailConfig;
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(smtpEmailConfig.getHost());
        mailSender.setPort(smtpEmailConfig.getPort());
        mailSender.setUsername(smtpEmailConfig.getUsername());
        mailSender.setPassword(smtpEmailConfig.getPassword());
        mailSender.getJavaMailProperties().put("mail.smtp.starttls.enable", smtpEmailConfig.isStarttlsEnable());
        mailSender.getJavaMailProperties().put("mail.smtp.auth", smtpEmailConfig.isAuth());
        return mailSender;



    }

    private static EmailConfig getSmtpConfig() {

        SmtpEmailConfig smtpEmailConfig = new SmtpEmailConfig();
        smtpEmailConfig.setAuth(true);
        smtpEmailConfig.setStarttlsEnable(true);
        smtpEmailConfig.setHost("smtp.gmail.com");
        smtpEmailConfig.setPort(587);
        smtpEmailConfig.setUsername("techgyaanlabs@gmail.com");
        smtpEmailConfig.setPassword("xizbhvdcdabalcqp");
        smtpEmailConfig.setProvider(MailProvider.SMTP);
        return smtpEmailConfig;
    }
}
