package qrCode.model;

import java.util.Date;

public class SignModel {

	private String actNo;
	private String actName;
	private String userNo;
	private String userName;
	private Integer signState;
	private Date actStartTime;
	private Date actEndTime;
	private Date signTime;
	private Date signTimeS;
	private Date signTimeE;
	public String getActNo() {
		return actNo;
	}
	public void setActNo(String actNo) {
		this.actNo = actNo;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getSignState() {
		return signState;
	}
	public void setSignState(Integer signState) {
		this.signState = signState;
	}
	public Date getActStartTime() {
		return actStartTime;
	}
	public void setActStartTime(Date actStartTime) {
		this.actStartTime = actStartTime;
	}
	public Date getActEndTime() {
		return actEndTime;
	}
	public void setActEndTime(Date actEndTime) {
		this.actEndTime = actEndTime;
	}
	public Date getSignTime() {
		return signTime;
	}
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	public Date getSignTimeS() {
		return signTimeS;
	}
	public void setSignTimeS(Date signTimeS) {
		this.signTimeS = signTimeS;
	}
	public Date getSignTimeE() {
		return signTimeE;
	}
	public void setSignTimeE(Date signTimeE) {
		this.signTimeE = signTimeE;
	}
	
	
}
