package com.lsg.pinkbean.bo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	// properties test
	@Autowired
	private Environment env;

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
	
	@RequestMapping(value="/index")
	public String main2() {
		
		return "index";
	}
}
