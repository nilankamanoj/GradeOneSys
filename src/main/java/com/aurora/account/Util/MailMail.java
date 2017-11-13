package com.aurora.account.Util;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class MailMail
{

    public boolean sendMail( String reciever,String subject, String message ) {

        Properties props = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("mail.properties");
        try {
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getProperty("mail.username"), props.getProperty("mail.password"));
            }
        });

        ;
        try {
            MimeMessage msg = new MimeMessage(session);

            msg.setFrom();
            msg.setRecipients(Message.RecipientType.TO,
                    reciever);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
           // msg.setText(message);
            msg.setContent(message, "text/html; charset=utf-8");
            Transport.send(msg);
            return true;
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
            return false;
        }
    }


}