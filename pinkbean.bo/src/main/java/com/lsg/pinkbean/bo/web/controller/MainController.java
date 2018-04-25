package com.lsg.pinkbean.bo.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lsg.pinkbean.core.utils.EmailSenderUtils;

//import com.lsg.pinkbean.core.module.common.service.EmailService;

@Controller
public class MainController {
	
	// properties test
	@Autowired
	private Environment env;
	
	// email test
	@Autowired
	private EmailSenderUtils emailsenderUtils;

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
	@RequestMapping(value="mail/sendMail", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView sendMailTest(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		 System.out.println("session : " + session.toString());
		
		try {
			//emailsenderUtils.sendMail("leewisdom@zen9.co.kr", "����", "����");
		}catch(Exception e) {
			// ���⼭ �޾� ó���� �� ���� ������?
		}

		mv.addObject("hello","hello");
		return mv;
	}
	
	/**
	 * �˾� �׽�Ʈ
	 * @return
	 */
	@RequestMapping(value="popup")
	public ModelAndView popupTest() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/testMenu/popupTest");
		return mv;
	}	
	
	/**
	 * �˾� �׽�Ʈ(�ڽ� ����)
	 * @return
	 */
	@RequestMapping(value="popup/pop")
	public ModelAndView popupTestChildren(@ModelAttribute("contents") String contents) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("contents",contents);
		mv.setViewName("/testMenu/popup/pop");
		return mv;
	}	
	
	/**
	 * ���� �ٿ�ε� �׽�Ʈ
	 * @return
	 */
	@RequestMapping(value="file/download")
	public ModelAndView fileDownTest(@ModelAttribute("contents") String contents) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}	
	
	@RequestMapping(value="/index")
	public String main2() {
		
		return "index";
	}
}
