package qrCode.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qrCode.model.ActivityModel;
import qrCode.service.ActivityService;
import qrCode.utils.CastUtil;

@RestController
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	
	/**
	 * 添加活动
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/addActivity.do")
    public Object addActivity(HttpServletRequest request) throws Exception{
		String actNo = request.getParameter("actNo");//获取活动编号
		String actName = request.getParameter("actName");//获取活动主题
		String actJoinNumStr = request.getParameter("actJoinNum");//参与活动人数
		Integer actJoinNum = null;
		if(actJoinNumStr!=null) {
			actJoinNum = Integer.parseInt(actJoinNumStr);
		}
		String actStateStr = request.getParameter("actState");//活动状态(0,启动;1,进行;2,结束;3,废弃)
		Integer actState = null;
		if(actStateStr!=null) {
			actState = Integer.parseInt(actStateStr);
		}
		String actStartTimeStr = request.getParameter("actStartTime");//活动开始时间
		Date actStartTime = null;
		if(actStartTimeStr!=null) {
			actStartTime = CastUtil.toDate(actStartTimeStr);
		}
		String actEndTimeStr = request.getParameter("actEndTime");//活动活动结束时间
		Date actEndTime = null;
		if(actEndTimeStr!=null) {
			actEndTime = CastUtil.toDate(actEndTimeStr);
		}
		
		ActivityModel activityModel = new ActivityModel();
		activityModel.setActNo(actNo);
		activityModel.setActName(actName);
		activityModel.setActJoinNum(actJoinNum);
		activityModel.setActState(actState);
		activityModel.setActStartTime(actStartTime);
		activityModel.setActEndTime(actEndTime);
		//添加活动
		activityService.addActivity(activityModel);
        return "添加成功！";
    }
	
	/**
	 * 修改活动
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/updateActivity.do")
    public Object updateActivity(HttpServletRequest request) throws Exception{
		String actIdStr = request.getParameter("actId");//活动主键
		Integer actId = null;
		if(actIdStr!=null) {
			actId = Integer.parseInt(actIdStr);
		}
		String actNo = request.getParameter("actNo");//获取活动编号
		String actName = request.getParameter("actName");//获取活动主题
		String actJoinNumStr = request.getParameter("actJoinNum");//参与活动人数
		Integer actJoinNum = null;
		if(actJoinNumStr!=null) {
			actJoinNum = Integer.parseInt(actJoinNumStr);
		}
		String actStateStr = request.getParameter("actState");//活动状态(0,启动;1,进行;2,结束;3,废弃)
		Integer actState = null;
		if(actStateStr!=null) {
			actState = Integer.parseInt(actStateStr);
		}
		String actStartTimeStr = request.getParameter("actStartTime");//活动开始时间
		Date actStartTime = null;
		if(actStartTimeStr!=null) {
			actStartTime = CastUtil.toDate(actStartTimeStr);
		}
		String actEndTimeStr = request.getParameter("actEndTime");//活动活动结束时间
		Date actEndTime = null;
		if(actEndTimeStr!=null) {
			actEndTime = CastUtil.toDate(actEndTimeStr);
		}
		
		ActivityModel activityModel = new ActivityModel();
		activityModel.setActId(actId);
		activityModel.setActNo(actNo);
		activityModel.setActName(actName);
		activityModel.setActJoinNum(actJoinNum);
		activityModel.setActState(actState);
		activityModel.setActStartTime(actStartTime);
		activityModel.setActEndTime(actEndTime);
		//修改活动
		activityService.updateActivity(activityModel);
        return "修改成功！";
    }
	
	/**
	 * 删除活动
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteActivity.do")
    public Object deleteActivity(HttpServletRequest request){
		String actIdStr = request.getParameter("actId");//活动主键
		Integer actId = null;
		if(actIdStr!=null) {
			actId = Integer.parseInt(actIdStr);
		}
		
		ActivityModel activityModel = new ActivityModel();
		activityModel.setActId(actId);
		//删除活动
		activityService.deleteActivity(activityModel);
        return "删除成功！";
    }
	
	
	/**
	 * 查询活动
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findActivity.do")
    public Object findActivity(HttpServletRequest request) throws Exception{
		String actIdStr = request.getParameter("actId");//活动主键
		Integer actId = null;
		if(actIdStr!=null) {
			actId = Integer.parseInt(actIdStr);
		}
		String actNo = request.getParameter("actNo");//获取活动编号
		String actName = request.getParameter("actName");//获取活动主题
		String actJoinNumStr = request.getParameter("actJoinNum");//参与活动人数
		Integer actJoinNum = null;
		if(actJoinNumStr!=null) {
			actJoinNum = Integer.parseInt(actJoinNumStr);
		}
		String actStateStr = request.getParameter("actState");//活动状态(0,启动;1,进行;2,结束;3,废弃)
		Integer actState = null;
		if(actStateStr!=null) {
			actState = Integer.parseInt(actStateStr);
		}
		String actStartTimeStr = request.getParameter("actStartTime");//活动开始时间
		Date actStartTime = null;
		if(actStartTimeStr!=null) {
			actStartTime = CastUtil.toDate(actStartTimeStr);
		}
		String actEndTimeStr = request.getParameter("actEndTime");//活动活动结束时间
		Date actEndTime = null;
		if(actEndTimeStr!=null) {
			actEndTime = CastUtil.toDate(actEndTimeStr);
		}
		
		
		ActivityModel activityModel = new ActivityModel();
		activityModel.setActId(actId);
		activityModel.setActNo(actNo);
		activityModel.setActName(actName);
		activityModel.setActJoinNum(actJoinNum);
		activityModel.setActState(actState);
		activityModel.setActStartTime(actStartTime);
		activityModel.setActEndTime(actEndTime);
		//查询活动
		List<ActivityModel> Activitys = activityService.findActivity(activityModel);
        return Activitys;
    }
	
}