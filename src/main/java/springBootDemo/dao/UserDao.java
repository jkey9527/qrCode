package springBootDemo.dao;

import org.apache.ibatis.annotations.Mapper;

import springBootDemo.model.UserModel;

@Mapper
public interface UserDao {

	void saveUser(UserModel userModel);

}
