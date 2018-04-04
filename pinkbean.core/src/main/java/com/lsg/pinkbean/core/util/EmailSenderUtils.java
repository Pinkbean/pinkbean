package com.lsg.pinkbean.core.util;

/**
 * �̸��� ��ƿ �������̽�
 * 
 * @author LSG
 *
 */
public interface EmailSenderUtils {

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
	public void sendMail(String from, String to, String subject, String msg);
	
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
	public void sendMail(String from, String[] to, String subject, String msg);
}
