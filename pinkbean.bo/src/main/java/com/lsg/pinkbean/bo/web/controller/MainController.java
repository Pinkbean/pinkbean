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
	 * 메인
	 * @return
	 */
	@RequestMapping(value="main")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/main/main");
		return mv;
	}
	
	/**
	 * 프로퍼티
	 * @return
	 */
	@RequestMapping(value="properties")
	public ModelAndView propertiesTest() {
		ModelAndView mv = new ModelAndView();
		
		// 환경에 따른 profile 테스트.
		String str = env.getProperty("pinkbean.test.properties");
		
		mv.addObject("str",str);
		mv.setViewName("/testMenu/propertiesTest");
		return mv;
	}
	
	/**
	 * 다음 맵
	 * @return
	 */
	@RequestMapping(value="daummap")
	public ModelAndView daumMapTest() {
		ModelAndView mv = new ModelAndView();
		
		// kakao 개발자센터에서 발급받은 키
		// javaScript에서 app key로 사용할 key
		String appKey = env.getProperty("pinkbean.kakao.javaScriptKey");

		mv.addObject("appKey",appKey);
		mv.setViewName("/testMenu/daumMapTest");
		return mv;
	}
	
	/**
	 * 전자메일
	 * @return
	 */
	@RequestMapping(value="mail")
	public ModelAndView mailTest() {
		ModelAndView mv = new ModelAndView();

		
		
		mv.setViewName("/testMenu/mailTest");
		return mv;
	}
	
	/**
	 * 메일 전송
	 * @return
	 */
	@RequestMapping(value="mail/sendMail", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView sendMailTest(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		 System.out.println("session : " + session.toString());
		
		try {
			//emailsenderUtils.sendMail("leewisdom@zen9.co.kr", "제목", "내용");
		}catch(Exception e) {
			// 여기서 받아 처리할 수 있지 않을까?
		}

		mv.addObject("hello","hello");
		return mv;
	}
	
	/**
	 * 팝업 테스트
	 * @return
	 */
	@RequestMapping(value="popup")
	public ModelAndView popupTest() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/testMenu/popupTest");
		return mv;
	}	
	
	/**
	 * 팝업 테스트(자식 띄우기)
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
	 * 파일 다운로드 테스트
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
