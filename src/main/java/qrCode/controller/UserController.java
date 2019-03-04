package qrCode.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qrCode.model.UserModel;
import qrCode.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 添加用户
	 * @param request
	 * @return
	 */
	@RequestMapping("/addUser.do")
    public Object addUser(HttpServletRequest request){
		String userNo = request.getParameter("userNo");//获取用户编号
		String userName = request.getParameter("userName");//获取用户名
		String password = request.getParameter("password");//获取用户密码
		UserModel userModel = new UserModel();
		userModel.setUserNo(userNo);
		userModel.setUserName(userName);
		userModel.setPassword(password);
		//添加用户
		userService.addUser(userModel);
        return "success";
    }
	
	/**
	 * 修改用户
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateUser.do")
    public Object updateUser(HttpServletRequest request){
		String userIdStr = request.getParameter("userId");//获取用户ID
		Integer userId = null;
		if(userIdStr!=null) {
			userId = Integer.parseInt(request.getParameter("userId"));
		}
		String userNo = request.getParameter("userNo");//获取用户编号
		String userName = request.getParameter("userName");//获取用户名
		String password = request.getParameter("password");//获取用户密码
		UserModel userModel = new UserModel();
		userModel.setUserId(userId);
		userModel.setUserNo(userNo);
		userModel.setUserName(userName);
		userModel.setPassword(password);
		//修改用户
		userService.updateUser(userModel);
        return "修改成功！";
    }
	
	/**
	 * 删除用户
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteUser.do")
    public Object deleteUser(HttpServletRequest request){
		String userIdStr = request.getParameter("userId");//获取用户ID
		Integer userId = null;
		if(userIdStr!=null) {
			userId = Integer.parseInt(request.getParameter("userId"));
		}
		UserModel userModel = new UserModel();
		userModel.setUserId(userId);
		//删除用户
		userService.deleteUser(userModel);
        return "删除成功！";
    }
	
	
	/**
	 * 查询用户
	 * @param request
	 * @return
	 */
	@RequestMapping("/findUser.do")
    public Object findUser(HttpServletRequest request){
		String userIdStr = request.getParameter("userId");//获取用户ID
		Integer userId = null;
		if(userIdStr!=null) {
			userId = Integer.parseInt(request.getParameter("userId"));
		}
		String userNo = request.getParameter("userNo");//获取用户编号
		String userName = request.getParameter("userName");//获取用户名
		UserModel userModel = new UserModel();
		userModel.setUserId(userId);
		userModel.setUserNo(userNo);
		userModel.setUserName(userName);
		//查询用户
		List<UserModel> users = userService.findUser(userModel);
        return users;
    }
	
}