package com.lsg.pinkbean.core.utils;

/**
 * 이메일 유틸 인터페이스
 * @author LSG
 *
 */
public interface EmailSenderUtils {
	
	public void sendMail(String to, String subject, String msg);
}
