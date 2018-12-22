package springBootDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootDemo.dao.UserDao;
import springBootDemo.model.UserModel;
import springBootDemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public void saveUser(UserModel userModel) {
		userDao.saveUser(userModel);
	}

}
