package com.lsg.pinkbean.core.module.common.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsg.pinkbean.core.util.EmailSenderUtils;

/**
 * �̸��� ���� ����ü
 * 
 * @author LSG
 *
 */
@Service
public class EmailServiceImpl implements EmailService {

//	@Autowired
//	EmailSenderUtils emailSenderUtils;
	
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
	@Override
	public void sendMail(String mailType, String targetEmail, Map<String, Object> paramMap) throws Exception {
		String from = "rltmfdl11@gmail.com"; 			// �߽��ڿ����ٵ� ���⼭ �������� �ǹ̰� ���� ������ �̰� �޾Ƽ� �ƹ��͵� ���Ѵ�
		String vmName = ""; 		// �̰� ����?
		String subject = "�ȳ� �� ����";	//����
		
		//emailSenderUtils.sendMail(from, targetEmail, subject, "<h1>VelocityUtil�� Html�� �ٲ��ִ°ǰ�~~ �����𸥴�~~~</h1>");
	}
}
