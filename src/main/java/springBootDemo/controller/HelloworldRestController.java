package springBootDemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springBootDemo.model.UserModel;

@RestController
public class HelloworldRestController {
	@RequestMapping("/hello.do")
    public Object helloworld(HttpServletRequest request){
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		if(!"1234".equals(pass)) {
			return "密码错误！";
		}
		UserModel userModel = new UserModel();
		userModel.setUser(user);
		userModel.setPass(pass);
        return userModel;
    }
}
