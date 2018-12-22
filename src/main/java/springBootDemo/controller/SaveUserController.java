package springBootDemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springBootDemo.model.UserModel;
import springBootDemo.service.UserService;

@RestController
public class SaveUserController {
	
	@Autowired
	private UserService userService;
	@RequestMapping("/saveUser.do")
    public Object helloworld(HttpServletRequest request){
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		UserModel userModel = new UserModel();
		userModel.setUser(user);
		userModel.setPass(pass);
		//保存用户
		userService.saveUser(userModel);
        return userModel;
    }
}