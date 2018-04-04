package com.lsg.pinkbean.core.module.common.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsg.pinkbean.core.util.EmailSenderUtils;

/**
 * 이메일 서비스 구현체
 * 
 * @author LSG
 *
 */
@Service
public class EmailServiceImpl implements EmailService {

//	@Autowired
//	EmailSenderUtils emailSenderUtils;
	
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
	@Override
	public void sendMail(String mailType, String targetEmail, Map<String, Object> paramMap) throws Exception {
		String from = "rltmfdl11@gmail.com"; 			// 발신자였을텐데 여기서 보내봤자 의미가 없다 지금은 이거 받아서 아무것도 안한다
		String vmName = ""; 		// 이건 뭐지?
		String subject = "안녕 난 메일";	//제목
		
		//emailSenderUtils.sendMail(from, targetEmail, subject, "<h1>VelocityUtil이 Html로 바꿔주는건가~~ 아직모른다~~~</h1>");
	}
}
