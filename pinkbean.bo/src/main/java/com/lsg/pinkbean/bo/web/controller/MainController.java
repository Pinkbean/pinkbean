package com.lsg.pinkbean.bo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value="/main")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/index");
		return mv;
	}
	
	@RequestMapping(value="/index")
	public String main2() {
		
		return "index";
	}
}
