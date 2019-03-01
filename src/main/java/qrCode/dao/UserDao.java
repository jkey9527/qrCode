package qrCode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import qrCode.model.UserModel;

/**
 * 用户持久层
 * @author mayn
 *
 */
@Mapper
public interface UserDao {

	/**
	 * 添加用户
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
