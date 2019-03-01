package qrCode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qrCode.dao.UserDao;
import qrCode.model.UserModel;
import qrCode.service.UserService;

/**
 * 用户服务实现类
 * @author mayn
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(UserModel userModel) {
		userDao.addUser(userModel);
	}

	@Override
	public void updateUser(UserModel userModel) {
		userDao.updateUser(userModel);
		
	}

	@Override
	public void deleteUser(UserModel userModel) {
		userDao.deleteUser(userModel);
		
	}

	@Override
	public List<UserModel> findUser(UserModel userModel) {
		return userDao.findUser(userModel);
	}

}
