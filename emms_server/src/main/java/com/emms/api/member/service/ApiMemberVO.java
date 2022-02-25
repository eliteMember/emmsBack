package com.emms.api.member.service;

import java.io.Serializable;

public class ApiMemberVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6875173717013081459L;

	private Integer memberSrl;
	private Integer siteSrl;
	private Integer groupSrl;
	private Integer moduleConfigSrl;
	
	public Integer getMemberSrl() {
		return memberSrl;
	}
	public void setMemberSrl(Integer memberSrl) {
		this.memberSrl = memberSrl;
	}
	public Integer getSiteSrl() {
		return siteSrl;
	}
	public void setSiteSrl(Integer siteSrl) {
		this.siteSrl = siteSrl;
	}
	public Integer getGroupSrl() {
		return groupSrl;
	}
	public void setGroupSrl(Integer groupSrl) {
		this.groupSrl = groupSrl;
	}
	public Integer getModuleConfigSrl() {
		return moduleConfigSrl;
	}
	public void setModuleConfigSrl(Integer moduleConfigSrl) {
		this.moduleConfigSrl = moduleConfigSrl;
	}

}
