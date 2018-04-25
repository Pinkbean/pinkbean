package com.lsg.pinkbean.bo.web.menu.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 메뉴 인터셉터
 * @author zen9
 *
 */
public class MenuInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
		System.out.println("testIntercepter : 인터셉트 테스트중입니다~!");
		modelAndView.addObject("testIntercepter","인터셉터 테스트임니다~~!");
	}
}
