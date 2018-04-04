package com.lsg.pinkbean.core.util;

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

import org.springframework.stereotype.Component;

/**
 * �̸��� ��ƿ ����ü
 * 
 * @author LSG
 *
 */
@Component("emailSendComponent")
public class EmailSenderUtilsImpl implements EmailSenderUtils {

	/**
	 * ���� ���� ������ ����
	 * @autor LSG
	 * 
	 ****************************
	 * ��¥
	 * 2018.04.04
	 * @param from
	 * @param to
	 * @param subject
	 * @param msg
	 */
	@Override
	public void sendMail(String from, String to, String subject, String msg) {
        String[] temp = new String[1];
        temp[0] = to;
		this.sendMail(from, temp, subject, msg);
	}

	/**
	 * ���� ���� ������ ����
	 * @autor LSG
	 * 
	 ****************************
	 * ��¥
	 * 2018.04.04
	 * @param from
	 * @param []to
	 * @param subject
	 * @param msg
	 */
	@Override
	public void sendMail(String from, String[] to, String subject, String msg) {
		this.sendMails(from, to, subject, msg);

	}
	
	/**
	 * ���� �߽� ó��
	 * @autor LSG
	 * 
	 ****************************
	 * ��¥
	 * 2018.04.04
	 * @param from
	 * @param []to
	 * @param subject
	 * @param msg
	 */
	private void sendMails(String from, String[] to, String subject, String msg) {
		String mailHost = "smtp.gmail.com";
		String mailPort = "587";
		
		final String mailUsername = "rltmfdl11@gmail.com";
		final String mailPassword = "ckskchtm1!";
		String mailSender = "";
		String mailPersonal = "PINKBEAN";
		
		try {
			
			// InternetAddress: �̸��� �ּҸ� ��Ÿ�� �� ���Ǵ� Ŭ����
			// ���޹��� ������ �迭�� �̿��� internetAddress ��ü �迭�� �����.
			InternetAddress[] insArrayAddress = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
        		insArrayAddress[i] = new InternetAddress(to[i]);
            }
            
            Properties props = new Properties();     
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", mailHost);
            props.put("mail.smtp.port", mailPort);
            props.put("mail.smtp.auth", "true");
            
            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(mailUsername, mailPassword);
                }
            };
            
            // ���� api�� ������ �̿��ϱ� ������, �Ʒ�ó�� ������ �������ش�
            Session session = Session.getDefaultInstance(props, auth);
            
            // �߽����� internetAdress�� �����Ѵ�.
            InternetAddress insAddress = new InternetAddress();
            insAddress.setAddress(mailSender); 				// ������ ��� email
            insAddress.setPersonal(mailPersonal, "utf-8"); 	// ������ ��� �̸�
            
            MimeMessage message = new MimeMessage(session);
            message.setHeader("Content-Transfer-Encoding", "quoted-printable");	// ��� ����
            message.setFrom(insAddress);										// �߽���
            message.setRecipients(Message.RecipientType.TO, insArrayAddress);	// ������
            message.setSubject(subject, "UTF-8");								// ����
            message.setContent(msg, "text/html;charset=utf-8");					// ����
            // setContent�� �ι�° parameter�� �ٸ� Ÿ���� �־� �پ��� Ÿ���� ������ ���� �� �ִ�. ���߿� api�� �������� �͵� ������.
            
            // MailCap - metamail capabilities file
            // ����ũ1: https://linux.die.net/man/4/mailcap
            // ����ũ2: https://docs.oracle.com/javaee/5/api/javax/activation/MailcapCommandMap.html
            // Add entries to the registry. Programmatically added entries are searched before other entries.
            // The string that is passed in should be in mailcap format.
            // ������ �Է��� setContent�� �ι�° �Ķ���Ϳ� ���� ��� ó���� �������� �����ϴ� �κ��� �� ����.
            MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
            mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
            mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
            mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
            mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
            mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
            CommandMap.setDefaultCommandMap(mc);

            Transport.send(message);            
		}catch(Exception e){
			e.printStackTrace();
			// �� �κ��� ������ ������ ���� ������ �߻��ߴ��� �˰� �ٸ� ������ ó���� �� ������?
		}
	}

}
