package qrCode.model;

import java.util.Date;

/**
 * 用户-活动实体
 * @author mayn
 *
 */
public class UserActivityModel {

	/**主键*/
	private Integer userActId;
	/**用户主键*/
	private Integer userId;
	/**活动主键*/
	private Integer actId;
	/**签到状态(0,邀请;1,签到;2,迟到)*/
	private Integer userActState;
	/**签到时间*/
	private Date userActTime;
	/**创建时间*/
	private Date createTime;
	public Integer getUserActId() {
		return userActId;
	}
	public void setUserActId(Integer userActId) {
		this.userActId = userActId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getActId() {
		return actId;
	}
	public void setActId(Integer actId) {
		this.actId = actId;
	}
	public Integer getUserActState() {
		return userActState;
	}
	public void setUserActState(Integer userActState) {
		this.userActState = userActState;
	}
	public Date getUserActTime() {
		return userActTime;
	}
	public void setUserActTime(Date userActTime) {
		this.userActTime = userActTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "UserActivityModel [userActId=" + userActId + ", userId=" + userId + ", actId=" + actId
				+ ", userActState=" + userActState + ", userActTime=" + userActTime + ", createTime=" + createTime
				+ "]";
	}
	
	
	
	
}
