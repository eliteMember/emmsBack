package com.emms.cmmn;

import java.io.Serializable;

import com.emms.mn.service.LoginVO;


public class SessionVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8251506059894875736L;
	
	private boolean isLogin = false;
	private LoginVO loginVO;
	
	public SessionVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SessionVO(LoginVO loginVO) {
		super();
		this.loginVO = loginVO;
	}
	
	public boolean isLogin() {
		if( this.loginVO == null ) {
			isLogin = false;
		}else {
			isLogin = true;
		}
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	
}
