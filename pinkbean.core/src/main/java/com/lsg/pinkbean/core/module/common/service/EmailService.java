package com.lsg.pinkbean.core.module.common.service;

import java.util.Map;

/**
 * 이메일 서비스 인터페이스
 * 
 * @author LSG
 *
 */
public interface EmailService {

	/**
	 * 메일 전송
	 * @autor LSG
	 * 
	 ****************************
	 * 날짜
	 * 2018.04.04
	 * @param mailType
	 * @param targetEmail
	 * @param paramMap
	 * @throws Exception
	 */
	void sendMail(String mailType, String targetEmail, Map<String,Object> paramMap) throws Exception;
}
