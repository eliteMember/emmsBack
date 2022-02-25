package com.emms.api.member.service;

import java.io.Serializable;

public class TestVO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6875173717013081459L;

	private Integer no;
	private String text;
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	
}
