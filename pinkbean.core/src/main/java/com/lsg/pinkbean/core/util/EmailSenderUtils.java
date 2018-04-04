package com.lsg.pinkbean.core.util;

/**
 * 이메일 유틸 인터페이스
 * 
 * @author LSG
 *
 */
public interface EmailSenderUtils {

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
	public void sendMail(String from, String to, String subject, String msg);
	
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
	public void sendMail(String from, String[] to, String subject, String msg);
}
