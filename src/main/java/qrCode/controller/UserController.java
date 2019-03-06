package qrCode.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qrCode.model.UserModel;
import qrCode.service.UserService;
import qrCode.utils.CastUtil;

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
		//查询用户编号是否存在
		List<UserModel> users = userService.findUser(userModel);
		if(users.isEmpty()) {
			userModel.setUserName(userName);
			userModel.setPassword(password);
			//添加用户
			userService.addUser(userModel);
			return "success";
		}else {
			return "保存失败：该用户编号被占用";
		}
    }
	
	/**
	 * 修改用户
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateUser.do")
    public Object updateUser(HttpServletRequest request){
		String userNo = request.getParameter("userNo");//获取用户编号
		String userName = request.getParameter("userName");//获取用户名
		String password = request.getParameter("password");//获取用户密码
		UserModel userModel = new UserModel();
		userModel.setUserNo(userNo);
		//查询用户编号是否存在
		List<UserModel> users = userService.findUser(userModel);
		if(!users.isEmpty()) {
			UserModel user = users.get(0);
			userModel.setUserId(user.getUserId());
			userModel.setUserName(userName);
			userModel.setPassword(password);
			//修改用户
			userService.updateUser(userModel);
			return "success";
		}else {
			return "修改失败：该用户不存在！";
		}
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
		//查询用户编号是否存在
		List<UserModel> users = userService.findUser(userModel);
		if(!users.isEmpty()) {
			//删除用户
			userService.deleteUser(userModel);
			return "success";
		}else {
			return "删除失败：该用户不存在";
		}
    }
	
	
	/**
	 * 查询用户
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findUser.do")
    public Object findUser(HttpServletRequest request) throws Exception{
		String userIdStr = request.getParameter("userId");//获取用户ID
		Integer userId = null;
		if(userIdStr!=null) {
			userId = Integer.parseInt(request.getParameter("userId"));
		}
		String userNo = request.getParameter("userNo");//获取用户编号
		if("".equals(userNo))userNo=null;
		String userName = request.getParameter("userName");//获取用户名
		if("".equals(userName))userName=null;
		String startTimeStr = request.getParameter("startTime");//获取开始时间
		Date startTime = null;
		if(!"".equals(startTimeStr))startTime=CastUtil.toDateT(startTimeStr);
		String endTimeStr = request.getParameter("endTime");//获取结束时间
		Date endTime = null;
		if(!"".equals(endTimeStr))endTime=CastUtil.toDateT(endTimeStr);
		
		UserModel userModel = new UserModel();
		userModel.setUserId(userId);
		userModel.setUserNo(userNo);
		userModel.setUserName(userName);
		userModel.setStartTime(startTime);
		userModel.setEndTime(endTime);
		//查询用户
		List<UserModel> users = userService.findUser(userModel);
        return users;
    }
	
}