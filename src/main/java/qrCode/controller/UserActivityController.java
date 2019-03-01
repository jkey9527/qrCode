package qrCode.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qrCode.model.ActivityModel;
import qrCode.model.UserActivityModel;
import qrCode.service.ActivityService;
import qrCode.service.UserActivityService;
import qrCode.utils.CastUtil;

@RestController
public class UserActivityController {
	
	@Autowired
	private UserActivityService userActivityService;
	
	/**
	 * 活动邀请
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/inviteUser.do")
    public Object inviteUser(HttpServletRequest request){
		String userIdStr = request.getParameter("userId");//获得用户ID
		Integer userId = null;
		if(userIdStr!=null) {
			userId = Integer.parseInt(userIdStr);
		}
		String actIdStr = request.getParameter("actId");//获得活动ID
		Integer actId = null;
		if(actIdStr!=null) {
			actId = Integer.parseInt(actIdStr);
		}
		UserActivityModel userActivityModel = new UserActivityModel();
		userActivityModel.setActId(actId);
		userActivityModel.setUserId(userId);
		userActivityModel.setUserActState(new Integer(0));
		//邀请
		userActivityService.inviteUser(userActivityModel);
		return "邀请成功";
    }
	
	/**
	 * 取消邀请
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/cancelUser.do")
    public Object cancelUser(HttpServletRequest request){
		String userIdStr = request.getParameter("userId");//获得用户ID
		Integer userId = null;
		if(userIdStr!=null) {
			userId = Integer.parseInt(userIdStr);
		}
		String actIdStr = request.getParameter("actId");//获得活动ID
		Integer actId = null;
		if(actIdStr!=null) {
			actId = Integer.parseInt(actIdStr);
		}
		UserActivityModel userActivityModel = new UserActivityModel();
		userActivityModel.setActId(actId);
		userActivityModel.setUserId(userId);
		//邀请
		userActivityService.cancelUser(userActivityModel);
		return "取消邀请成功";
    }
	
	
}