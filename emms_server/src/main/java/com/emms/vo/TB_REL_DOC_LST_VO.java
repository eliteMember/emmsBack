package com.emms.vo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TB_REL_DOC_LST_VO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 610061053839217227L;
	private String prjNum;		//프로젝트번호
	private String relDocNum;   //관련서류번호
	private String docClsCd;    //서류분류코드
	private String filNm;       //파일명
	private String filPth;      //파일경로
	private String orgFilNm;    //원본파일명
	private long   filSiz;      //파일크기
	private String filExt;      //파일확장자
	private Date   crtDtm;      //등록일시
	private String crtUsrNum;   //등록사용자번호
	private Date   mdfDtm;      //수정일시
	private String mdfUsrNum;   //수정사용자번호
	
	private String fileBase64;	//파일
	private MultipartFile fileObj;		//파일
	
	
	public String getPrjNum() {
		return prjNum;
	}
	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}
	public String getRelDocNum() {
		return relDocNum;
	}
	public void setRelDocNum(String relDocNum) {
		this.relDocNum = relDocNum;
	}
	public String getDocClsCd() {
		return docClsCd;
	}
	public void setDocClsCd(String docClsCd) {
		this.docClsCd = docClsCd;
	}
	public String getFilNm() {
		return filNm;
	}
	public void setFilNm(String filNm) {
		this.filNm = filNm;
	}
	public String getFilPth() {
		return filPth;
	}
	public void setFilPth(String filPth) {
		this.filPth = filPth;
	}
	public String getOrgFilNm() {
		return orgFilNm;
	}
	public void setOrgFilNm(String orgFilNm) {
		this.orgFilNm = orgFilNm;
	}
	public long getFilSiz() {
		return filSiz;
	}
	public void setFilSiz(long filSiz) {
		this.filSiz = filSiz;
	}
	public String getFilExt() {
		return filExt;
	}
	public void setFilExt(String filExt) {
		this.filExt = filExt;
	}
	public Date getCrtDtm() {
		return crtDtm;
	}
	public void setCrtDtm(Date crtDtm) {
		this.crtDtm = crtDtm;
	}
	public String getCrtUsrNum() {
		return crtUsrNum;
	}
	public void setCrtUsrNum(String crtUsrNum) {
		this.crtUsrNum = crtUsrNum;
	}
	public Date getMdfDtm() {
		return mdfDtm;
	}
	public void setMdfDtm(Date mdfDtm) {
		this.mdfDtm = mdfDtm;
	}
	public String getMdfUsrNum() {
		return mdfUsrNum;
	}
	public void setMdfUsrNum(String mdfUsrNum) {
		this.mdfUsrNum = mdfUsrNum;
	}
	public String getFileBase64() {
		return fileBase64;
	}
	public void setFileBase64(String fileBase64) {
		this.fileBase64 = fileBase64;
	}
	public MultipartFile getFileObj() {
		return fileObj;
	}
	public void setFileObj(MultipartFile fileObj) {
		this.fileObj = fileObj;
	}

}
