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

	@RequestMapping(value="main")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/main/main");
		return mv;
	}
	
	@RequestMapping(value="properties")
	public ModelAndView properties() {
		ModelAndView mv = new ModelAndView();
		
		// 환경에 따른 profile 테스트.
		String str = env.getProperty("pinkbean.test.properties");
		
		mv.addObject("str",str);
		mv.setViewName("/properties/propertiesTest");
		return mv;
	}
	
	@RequestMapping(value="/index")
	public String main2() {
		
		return "index";
	}
}
