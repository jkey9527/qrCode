package qrCode.model;

import java.util.Date;

/**
 * 用户实体
 * @author mayn
 *
 */
public class UserModel {
	
	/**用户主键*/
	private Integer userId;
	/**用户编号*/
	private String userNo;
	/**用户名*/
	private String userName;
	/**密码*/
	private String password;
	/**创建时间*/
	private Date createTime;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userNo=" + userNo + ", userName=" + userName + ", password="
				+ password + ", createTime=" + createTime + "]";
	}
	
	
	
}
