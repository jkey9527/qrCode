package springBootDemo.model;

public class UserModel {
	//用户
	private String user;
	//密码
	private String pass;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "UserModel [user=" + user + ", pass=" + pass + "]";
	}
	
}
