package com.lsg.pinkbean.core.module.common.service;

import java.util.Map;

/**
 * �̸��� ���� �������̽�
 * 
 * @author LSG
 *
 */
public interface EmailService {

	/**
	 * ���� ����
	 * @autor LSG
	 * 
	 ****************************
	 * ��¥
	 * 2018.04.04
	 * @param mailType
	 * @param targetEmail
	 * @param paramMap
	 * @throws Exception
	 */
	void sendMail(String mailType, String targetEmail, Map<String,Object> paramMap) throws Exception;
}
