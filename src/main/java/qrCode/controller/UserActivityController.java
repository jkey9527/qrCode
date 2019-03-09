package qrCode.controller;


import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qrCode.model.ActivityModel;
import qrCode.model.SignModel;
import qrCode.model.UserActivityModel;
import qrCode.model.UserModel;
import qrCode.service.ActivityService;
import qrCode.service.UserActivityService;
import qrCode.service.UserService;
import qrCode.utils.CastUtil;

@RestController
public class UserActivityController {
	
	@Autowired
	private UserActivityService userActivityService;
	@Autowired
	private UserService userService;
	@Autowired
	private ActivityService activityService;
	
	/**
	 * 活动邀请
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/inviteUser.do")
    public Object inviteUser(HttpServletRequest request){
		Map map = request.getParameterMap();
		String actIdStr = request.getParameter("actId");//获得活动ID
		Integer actId = null;
		if(actIdStr!=null) {
			actId = Integer.parseInt(actIdStr);
		}
		String[] userIds = null;
		 Set<Entry<String, String[]>> set = map.entrySet();  
	        Iterator<Entry<String, String[]>> it = set.iterator();  
	        while (it.hasNext()) {  
	            Entry<String, String[]> entry = it.next(); 
	            if(entry.getKey().equals("userIds[]")) {
	            	userIds = entry.getValue();
	            }
	        }  
		userActivityService.inviteUser(userIds,actId);
		return "success";
    }
	
	@RequestMapping("/initInviteUser.do")
    public Object initInviteUser(HttpServletRequest request){
		String actIdStr = request.getParameter("actId");//获得用户ID
		String type = request.getParameter("type");//初始化类型
		Integer actId = null;
		if(actIdStr!=null) {
			actId = Integer.parseInt(actIdStr);
		}
		UserActivityModel userActivityModel = new UserActivityModel();
		userActivityModel.setActId(actId);
		userActivityModel.setType(type);
		List<UserModel> users = userActivityService.initInviteUser(userActivityModel);
		return users;
    }
	
	/**
	 * 取消邀请
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/cancelUser.do")
    public Object cancelUser(HttpServletRequest request){
		Map map = request.getParameterMap();
		String actIdStr = request.getParameter("actId");//获得活动ID
		Integer actId = null;
		if(actIdStr!=null) {
			actId = Integer.parseInt(actIdStr);
		}
		String[] userIds = null;
		 Set<Entry<String, String[]>> set = map.entrySet();  
	        Iterator<Entry<String, String[]>> it = set.iterator();  
	        while (it.hasNext()) {  
	            Entry<String, String[]> entry = it.next();  
	            if(entry.getKey().equals("userIds[]")) {
	            	userIds = entry.getValue();
	            }
	        }  
		userActivityService.cancelUser(userIds,actId);
		return "success";
    }
	
	/**
	 * 签到
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/sign.do")
    public Object sign(HttpServletRequest request){
		String actIdStr = request.getParameter("actId");//获得活动ID
		Integer actId = null;
		if(actIdStr!=null) {
			actId = Integer.parseInt(actIdStr);
		}
		String userNo = request.getParameter("userNo");
		String password = request.getParameter("password");
		
		UserModel userModel = new UserModel();
		userModel.setUserNo(userNo);
		userModel.setPassword(password);
		List<UserModel> list = userService.findUser(userModel);
		if(list.isEmpty()) {
			return "签到失败：用户编号或密码错误";
		}
		
		ActivityModel activityModel = new ActivityModel();
		activityModel.setActId(actId);
		activityModel.setActState(new Integer(1));
		List<ActivityModel> activitys = activityService.findActivity(activityModel);
		if(activitys.isEmpty()) {
			return "签到失败：活动不存在或活动还未开始";
		}
		
		UserActivityModel userActivityModel = new UserActivityModel();
		userActivityModel.setActId(actId);
		userActivityModel.setUserId(list.get(0).getUserId());
		List<UserActivityModel> li = userActivityService.findIsSign(userActivityModel);
		if(!li.isEmpty()) {
			return "签到失败：不能重复签到";
		}
		Date actStartTime = activitys.get(0).getActStartTime();
		Date actEndTime = activitys.get(0).getActEndTime();
		Date userActTime = new Date();
		userActivityModel.setUserActTime(userActTime);
		if(userActTime.getTime()-actStartTime.getTime()>0) {//迟到
			userActivityModel.setUserActState(new Integer(2));
		}else if(userActTime.getTime()-actEndTime.getTime()>0) {
			return "success";
		}
		else {
			userActivityModel.setUserActState(new Integer(1));
		}
		userActivityService.sign(userActivityModel);
		return "success";
    }
	
	/**
	 * 签到情况统计
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findUserActivity.do")
    public Object findUserActivity(HttpServletRequest request) throws Exception{
		String actNo = request.getParameter("actNo");//获取活动编号
		if("".equals(actNo)) {
			actNo = null;
		}
		String userNo = request.getParameter("userNo");//获取用户编号
		if("".equals(userNo)) {
			userNo = null;
		}
		String signStateStr = request.getParameter("signState");//签到状态
		Integer signState = null;
		if(signStateStr!=null&&!"".equals(signStateStr)) {
			signState = Integer.parseInt(signStateStr);
		}
		String signTimeS_ = request.getParameter("signTimeS");
		Date signTimeS = null;
		if(signTimeS_!=null&&!"".equals(signTimeS_)) {
			signTimeS = CastUtil.toDateT(signTimeS_);
		}
		String signTimeE_ = request.getParameter("signTimeE_");
		Date signTimeE = null;
		if(signTimeE_!=null&&!"".equals(signTimeE_)) {
			signTimeS = CastUtil.toDateT(signTimeE_);
		}
		SignModel signModel = new SignModel();
		signModel.setActNo(actNo);
		signModel.setUserNo(userNo);
		signModel.setSignState(signState);
		signModel.setSignTimeS(signTimeS);
		signModel.setSignTimeE(signTimeE);
		//查询活动
		List<ActivityModel> activitys = userActivityService.findUserActivity(signModel);
        return activitys;
		
	}
	
	
	
}