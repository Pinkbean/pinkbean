package com.lsg.pinkbean.core.utils;


import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("emailSendComponent")
public class EmailSenderUtilsImpl implements EmailSenderUtils {
	
	@Autowired
	private Environment env;

	@Override
	public void sendMail(String to, String subject, String msg) {

		final String mailUsername = env.getProperty("pinkbean.mail.mailUsername");
		final String mailPassword = env.getProperty("pinkbean.mail.mailPassword");
		String mailHost 	= env.getProperty("pinkbean.mail.mailHost");
		String mailPort 	= env.getProperty("pinkbean.mail.mailPort");
		String mailSender 	= env.getProperty("pinkbean.mail.mailSender");
		String mailPersonal = env.getProperty("pinkbean.mail.mailPersonal");

        System.out.println("mailHost : " + mailHost);
        System.out.println("mailPort : " + mailPort);
        System.out.println("mailUsername : " + mailUsername);
        System.out.println("mailPassword : " + mailPassword);
        System.out.println("mailSender : " + mailSender);
        System.out.println("mailPersonal : " + mailPersonal);	    
        
        try {
        	
        	Properties props = new Properties();
        	props.put("mail.smtp.host", mailHost);
        	props.put("mail.smtp.port", mailPort);        	
        	props.put("mail.smtp.auth", "true");
        	props.put("mail.smtp.socketFactory.port", mailPort);
        	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        	props.put("mail.smtp.socketFactory.fallback", "false");
        	props.setProperty("mail.smtp.quitwait", "true");
        	
        	// java.net이 아닌 java.mail이어야 함
            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(mailUsername, mailPassword);
                }
            };      	
        	
            Session session = Session.getDefaultInstance(props, auth);
            // 보내는 사람의 address
            InternetAddress inAddress = new InternetAddress();
            inAddress.setAddress(mailSender);				// 보내는 사람 주소
            inAddress.setPersonal(mailPersonal, "utf-8"); 	// 보내는 사람 이름
            InternetAddress toAddress = new InternetAddress();
            toAddress.setAddress(to);						// 받는 사람 주소
            
            MimeMessage message = new MimeMessage(session);
            message.setHeader("Content-Transfer-Encoding", "quoted-printable");
            message.setFrom(inAddress);
            message.setRecipient(Message.RecipientType.TO, toAddress);
            //message.setRecipients(Message.RecipientType.TO, Array());
            message.setSubject(subject, "UTF-8");
            message.setContent(msg, "text/html;charset=utf-8");
            
            MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
            mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
            mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
            mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
            mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
            mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
            CommandMap.setDefaultCommandMap(mc);       
            
            Transport.send(message);            
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

}
