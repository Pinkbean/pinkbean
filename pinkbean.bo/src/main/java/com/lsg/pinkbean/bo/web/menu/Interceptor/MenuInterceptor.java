package com.lsg.pinkbean.bo.web.menu.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * �޴� ���ͼ���
 * @author zen9
 *
 */
public class MenuInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
		System.out.println("testIntercepter : ���ͼ�Ʈ �׽�Ʈ���Դϴ�~!");
		modelAndView.addObject("testIntercepter","���ͼ��� �׽�Ʈ�Ӵϴ�~~!");
	}
}
