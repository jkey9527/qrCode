package qrCode.model;

import java.util.Date;

/**
 * 活动实体
 * @author mayn
 *
 */
public class ActivityModel {
	
	/**活动主键*/
	private Integer actId;
	/**活动编号*/
	private String actNo;
	/**活动主题*/
	private String actName;
	/**参与活动人数*/
	private Integer actJoinNum;
	/**活动状态(0,启动;1,进行;2,结束;3,废弃)*/
	private Integer actState;
	/**活动开始时间*/
	private Date actStartTime;
	/**活动结束时间*/
	private Date actEndTime;
	/**创建时间*/
	private Date createTime;
	/**修改时间*/
	private Date updateTime;
	
	/*查询参数*/
	private Date actStartTimeS;
	private Date actStartTimeE;
	private Date actEndTimeS;
	private Date actEndTimeE;
	private Date createTimeS;
	private Date createTimeE;
	private Date updateTimeS;
	private Date updateTimeE;
	
	
	public Date getActStartTimeS() {
		return actStartTimeS;
	}
	public void setActStartTimeS(Date actStartTimeS) {
		this.actStartTimeS = actStartTimeS;
	}
	public Date getActStartTimeE() {
		return actStartTimeE;
	}
	public void setActStartTimeE(Date actStartTimeE) {
		this.actStartTimeE = actStartTimeE;
	}
	public Date getActEndTimeS() {
		return actEndTimeS;
	}
	public void setActEndTimeS(Date actEndTimeS) {
		this.actEndTimeS = actEndTimeS;
	}
	public Date getActEndTimeE() {
		return actEndTimeE;
	}
	public void setActEndTimeE(Date actEndTimeE) {
		this.actEndTimeE = actEndTimeE;
	}
	public Date getCreateTimeS() {
		return createTimeS;
	}
	public void setCreateTimeS(Date createTimeS) {
		this.createTimeS = createTimeS;
	}
	public Date getCreateTimeE() {
		return createTimeE;
	}
	public void setCreateTimeE(Date createTimeE) {
		this.createTimeE = createTimeE;
	}
	public Date getUpdateTimeS() {
		return updateTimeS;
	}
	public void setUpdateTimeS(Date updateTimeS) {
		this.updateTimeS = updateTimeS;
	}
	public Date getUpdateTimeE() {
		return updateTimeE;
	}
	public void setUpdateTimeE(Date updateTimeE) {
		this.updateTimeE = updateTimeE;
	}
	public Integer getActId() {
		return actId;
	}
	public void setActId(Integer actId) {
		this.actId = actId;
	}
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
	public Integer getActJoinNum() {
		return actJoinNum;
	}
	public void setActJoinNum(Integer actJoinNum) {
		this.actJoinNum = actJoinNum;
	}
	public Integer getActState() {
		return actState;
	}
	public void setActState(Integer actState) {
		this.actState = actState;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "ActivityModel [actId=" + actId + ", actNo=" + actNo + ", actName=" + actName + ", actJoinNum="
				+ actJoinNum + ", actState=" + actState + ", actStartTime=" + actStartTime + ", actEndTime=" + actEndTime
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
	
}
