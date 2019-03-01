package qrCode.service;



import java.util.List;

import qrCode.model.UserModel;

/**
 * 用户服务
 * @author mayn
 *
 */
public interface UserService {
	/**
	 * 新增用户
	 * @param userModel
	 */
	void addUser(UserModel userModel);
	
	/**
	 * 修改用户
	 * @param userModel
	 */
	void updateUser(UserModel userModel);

	/**
	 * 删除用户
	 * @param userModel
	 */
	void deleteUser(UserModel userModel);

	/**
	 * 查询用户
	 * @param userModel
	 * @return
	 */
	List<UserModel> findUser(UserModel userModel);

}
