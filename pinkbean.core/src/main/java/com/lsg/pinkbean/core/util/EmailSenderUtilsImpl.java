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
 * 이메일 유틸 구현체
 * 
 * @author LSG
 *
 */
@Component("emailSendComponent")
public class EmailSenderUtilsImpl implements EmailSenderUtils {

	/**
	 * 메일 단일 수신자 전송
	 * @autor LSG
	 * 
	 ****************************
	 * 날짜
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
	 * 메일 다중 수신자 전송
	 * @autor LSG
	 * 
	 ****************************
	 * 날짜
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
	 * 메일 발신 처리
	 * @autor LSG
	 * 
	 ****************************
	 * 날짜
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
			
			// InternetAddress: 이메일 주소를 나타낼 때 사용되는 클래스
			// 전달받은 수신자 배열을 이용해 internetAddress 객체 배열을 만든다.
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
            
            // 메일 api는 세션을 이용하기 때문에, 아래처럼 세션을 생성해준다
            Session session = Session.getDefaultInstance(props, auth);
            
            // 발신자의 internetAdress를 생성한다.
            InternetAddress insAddress = new InternetAddress();
            insAddress.setAddress(mailSender); 				// 보내는 사람 email
            insAddress.setPersonal(mailPersonal, "utf-8"); 	// 보내는 사람 이름
            
            MimeMessage message = new MimeMessage(session);
            message.setHeader("Content-Transfer-Encoding", "quoted-printable");	// 헤더 정보
            message.setFrom(insAddress);										// 발신자
            message.setRecipients(Message.RecipientType.TO, insArrayAddress);	// 수신자
            message.setSubject(subject, "UTF-8");								// 제목
            message.setContent(msg, "text/html;charset=utf-8");					// 내용
            // setContent의 두번째 parameter에 다른 타입을 넣어 다양한 타입의 메일을 보낼 수 있다. 나중에 api를 뒤져보는 것도 좋을듯.
            
            // MailCap - metamail capabilities file
            // 참고링크1: https://linux.die.net/man/4/mailcap
            // 참고링크2: https://docs.oracle.com/javaee/5/api/javax/activation/MailcapCommandMap.html
            // Add entries to the registry. Programmatically added entries are searched before other entries.
            // The string that is passed in should be in mailcap format.
            // 위에서 입력한 setContent의 두번째 파라매터에 따라 어떻게 처리할 것인지를 결정하는 부분인 것 같다.
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
			// 이 부분을 밖으로 던져서 무슨 오류가 발생했는지 알게 다른 곳에서 처리할 수 있을까?
		}
	}

}
