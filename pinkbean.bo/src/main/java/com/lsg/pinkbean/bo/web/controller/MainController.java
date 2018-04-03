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
	
	@RequestMapping(value="/index")
	public String main2() {
		
		return "index";
	}
}
