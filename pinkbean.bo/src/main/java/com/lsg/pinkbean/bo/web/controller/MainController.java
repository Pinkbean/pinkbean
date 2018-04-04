package com.lsg.pinkbean.bo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lsg.pinkbean.core.module.common.service.EmailService;

@Controller
public class MainController {
	
	// properties test
	@Autowired
	private Environment env;
	
	// email test
	@Autowired
	private EmailService emailService;

	/**
	 * ����
	 * @return
	 */
	@RequestMapping(value="main")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/main/main");
		return mv;
	}
	
	/**
	 * ������Ƽ
	 * @return
	 */
	@RequestMapping(value="properties")
	public ModelAndView propertiesTest() {
		ModelAndView mv = new ModelAndView();
		
		// ȯ�濡 ���� profile �׽�Ʈ.
		String str = env.getProperty("pinkbean.test.properties");
		
		mv.addObject("str",str);
		mv.setViewName("/testMenu/propertiesTest");
		return mv;
	}
	
	/**
	 * ���� ��
	 * @return
	 */
	@RequestMapping(value="daummap")
	public ModelAndView daumMapTest() {
		ModelAndView mv = new ModelAndView();
		
		// kakao �����ڼ��Ϳ��� �߱޹��� Ű
		// javaScript���� app key�� ����� key
		String appKey = env.getProperty("pinkbean.kakao.javaScriptKey");

		mv.addObject("appKey",appKey);
		mv.setViewName("/testMenu/daumMapTest");
		return mv;
	}
	
	/**
	 * ���ڸ���
	 * @return
	 */
	@RequestMapping(value="mail")
	public ModelAndView mailTest() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/testMenu/mailTest");
		return mv;
	}
	
	/**
	 * ���� ����
	 * @return
	 */
	@RequestMapping(value="mail/sendMail")
	public ModelAndView sendMailTest() {
		ModelAndView mv = new ModelAndView();
		
		try {
			//emailService.sendMail("����Ÿ��~", "leewisdom@zen9.co.kr", null);
		}catch(Exception e) {
			// ���⼭ �޾� ó���� �� ���� ������?
		}

		return mv;
	}
	
	@RequestMapping(value="/index")
	public String main2() {
		
		return "index";
	}
}
