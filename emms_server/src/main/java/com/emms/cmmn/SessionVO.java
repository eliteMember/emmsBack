package com.emms.cmmn;

import java.io.Serializable;

import com.emms.vo.TB_USR_MST_VO;


public class SessionVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8251506059894875736L;
	
	private boolean isLogin = false;
	private TB_USR_MST_VO tbUsrMstVo;
	
	public SessionVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SessionVO(TB_USR_MST_VO tbUsrMstVo) {
		super();
		this.tbUsrMstVo = tbUsrMstVo;
	}
	
	public boolean isLogin() {
		if( this.tbUsrMstVo == null ) {
			isLogin = false;
		}else {
			isLogin = true;
		}
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public TB_USR_MST_VO getTbUsrMstVo() {
		return tbUsrMstVo;
	}
	public void setTbUsrMstVo(TB_USR_MST_VO tbUsrMstVo) {
		this.tbUsrMstVo = tbUsrMstVo;
	}
	
}
