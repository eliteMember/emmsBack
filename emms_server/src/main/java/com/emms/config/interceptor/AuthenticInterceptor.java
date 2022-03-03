package com.emms.config.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.emms.cmmn.SessionVO;
import com.emms.cmmn.exception.CustomException;

public class AuthenticInterceptor implements HandlerInterceptor {

	protected Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	
		HttpSession session = request.getSession();
		SessionVO sessionVO = null;
		if( session.getAttribute("sessionVO") == null ) {
			sessionVO = new SessionVO(); 
		}else {
			sessionVO = (SessionVO) session.getAttribute("sessionVO");
		}
		
		if( sessionVO.isLogin() ) {
			return true;
		}else {
			throw new CustomException("권한없음 테스트");
		}
		
		
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    	
    }

}
