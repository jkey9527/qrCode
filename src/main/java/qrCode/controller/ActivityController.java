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
		if(actJoinNumStr!=null&&!"".equals(actJoinNumStr)) {
			actJoinNum = Integer.parseInt(actJoinNumStr);
		}
		String actStateStr = request.getParameter("actState");//活动状态(0,启动;1,进行;2,结束;3,废弃)
		Integer actState = null;
		if(actStateStr!=null&&!"".equals(actStateStr)) {
			actState = Integer.parseInt(actStateStr);
		}
		String actStartTimeStr = request.getParameter("actStartTime");//活动开始时间
		Date actStartTime = null;
		if(actStartTimeStr!=null&&!"".equals(actStartTimeStr)) {
			actStartTime = CastUtil.toDateT(actStartTimeStr);
		}
		String actEndTimeStr = request.getParameter("actEndTime");//活动活动结束时间
		Date actEndTime = null;
		if(actEndTimeStr!=null&&!"".equals(actEndTimeStr)) {
			actEndTime = CastUtil.toDateT(actEndTimeStr);
		}
		
		ActivityModel activityModel = new ActivityModel();
		activityModel.setActNo(actNo);
		//查询活动
		List<ActivityModel> activitys = activityService.findActivity(activityModel);
		if(activitys.isEmpty()) {
			activityModel.setActName(actName);
			activityModel.setActJoinNum(actJoinNum);
			activityModel.setActState(actState);
			activityModel.setActStartTime(actStartTime);
			activityModel.setActEndTime(actEndTime);
			//添加活动
			activityService.addActivity(activityModel);
			return "success";
		}else {
			return "保存失败：该活动编号被占用";
		}
		
    }
	
	/**
	 * 修改活动
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/updateActivity.do")
    public Object updateActivity(HttpServletRequest request) throws Exception{
		String actNo = request.getParameter("actNo");//获取活动编号
		String actName = request.getParameter("actName");//获取活动主题
		String actJoinNumStr = request.getParameter("actJoinNum");//参与活动人数
		Integer actJoinNum = null;
		if(actJoinNumStr!=null&&!"".equals(actJoinNumStr)) {
			actJoinNum = Integer.parseInt(actJoinNumStr);
		}
		String actStateStr = request.getParameter("actState");//活动状态(0,启动;1,进行;2,结束;3,废弃)
		Integer actState = null;
		if(actStateStr!=null&&!"".equals(actStateStr)) {
			actState = Integer.parseInt(actStateStr);
		}
		String actStartTimeStr = request.getParameter("actStartTime");//活动开始时间
		Date actStartTime = null;
		if(actStartTimeStr!=null&&!"".equals(actStartTimeStr)) {
			actStartTime = CastUtil.toDateT(actStartTimeStr);
		}
		String actEndTimeStr = request.getParameter("actEndTime");//活动活动结束时间
		Date actEndTime = null;
		if(actEndTimeStr!=null&&!"".equals(actEndTimeStr)) {
			actEndTime = CastUtil.toDateT(actEndTimeStr);
		}
		
		ActivityModel activityModel = new ActivityModel();
		activityModel.setActNo(actNo);
		//查询活动
		List<ActivityModel> activitys = activityService.findActivity(activityModel);
		if(!activitys.isEmpty()) {
			ActivityModel activity = activitys.get(0);
			activityModel.setActId(activity.getActId());
			activityModel.setActName(actName);
			activityModel.setActJoinNum(actJoinNum);
			activityModel.setActState(actState);
			activityModel.setActStartTime(actStartTime);
			activityModel.setActEndTime(actEndTime);
			//修改活动
			activityService.updateActivity(activityModel);
			return "success";
		}else {
			return "修改失败：该活动不存在！";
		}
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
		if(actIdStr!=null&&!"".equals(actIdStr)) {
			actId = Integer.parseInt(actIdStr);
		}
		
		ActivityModel activityModel = new ActivityModel();
		activityModel.setActId(actId);
		List<ActivityModel> activitys = activityService.findActivity(activityModel);
		if(!activitys.isEmpty()) {
			//删除活动
			activityService.deleteActivity(activityModel);
			return "success";
		}else {
			return "删除失败：该活动不存在！";
		}
		
    }
	
	/**
	 * 废弃活动
	 * @param request
	 * @return
	 */
	@RequestMapping("/disCardActivity.do")
    public Object disCardActivity(HttpServletRequest request){
		String actIdStr = request.getParameter("actId");//活动主键
		Integer actId = null;
		if(actIdStr!=null&&!"".equals(actIdStr)) {
			actId = Integer.parseInt(actIdStr);
		}
		
		ActivityModel activityModel = new ActivityModel();
		activityModel.setActId(actId);
		List<ActivityModel> activitys = activityService.findActivity(activityModel);
		if(!activitys.isEmpty()) {
			//废弃活动
			activityModel.setActState(new Integer(3));
			activityService.updateActivityState(activityModel);
			return "success";
		}else {
			return "废弃失败：该活动不存在！";
		}
		
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
		if(actIdStr!=null&&!"".equals(actIdStr)) {
			actId = Integer.parseInt(actIdStr);
		}
		String actNo = request.getParameter("actNo");//获取活动编号
		if("".equals(actNo)) {
			actNo = null;
		}
		String actName = request.getParameter("actName");//获取活动主题
		if("".equals(actName)) {
			actName = null;
		}
		String actJoinNumStr = request.getParameter("actJoinNum");//参与活动人数
		Integer actJoinNum = null;
		if(actJoinNumStr!=null&&!"".equals(actJoinNumStr)) {
			actJoinNum = Integer.parseInt(actJoinNumStr);
		}
		String actStateStr = request.getParameter("actState");//活动状态(0,启动;1,进行;2,结束;3,废弃)
		Integer actState = null;
		if(actStateStr!=null&&!"".equals(actStateStr)) {
			actState = Integer.parseInt(actStateStr);
		}
		String actStartTimeS_ = request.getParameter("actStartTimeS");
		Date actStartTimeS = null;
		if(actStartTimeS_!=null&&!"".equals(actStartTimeS_)) {
			actStartTimeS = CastUtil.toDateT(actStartTimeS_);
		}
		String actStartTimeE_ = request.getParameter("actStartTimeE");
		Date actStartTimeE = null;
		if(actStartTimeE_!=null&&!"".equals(actStartTimeE_)) {
			actStartTimeE = CastUtil.toDateT(actStartTimeE_);
		}
		String actEndTimeS_ = request.getParameter("actEndTimeS");
		Date actEndTimeS = null;
		if(actEndTimeS_!=null&&!"".equals(actEndTimeS_)) {
			actEndTimeS = CastUtil.toDateT(actEndTimeS_);
		}
		String actEndTimeE_ = request.getParameter("actEndTimeE");
		Date actEndTimeE = null;
		if(actEndTimeE_!=null&&!"".equals(actEndTimeE_)) {
			actEndTimeE = CastUtil.toDateT(actEndTimeE_);
		}
		String createTimeS_ = request.getParameter("createTimeS");
		Date createTimeS = null;
		if(createTimeS_!=null&&!"".equals(createTimeS_)) {
			createTimeS = CastUtil.toDateT(createTimeS_);
		}
		String createTimeE_ = request.getParameter("createTimeE");
		Date createTimeE = null;
		if(createTimeE_!=null&&!"".equals(createTimeE_)) {
			createTimeE = CastUtil.toDateT(createTimeE_);
		}
		String updateTimeS_ = request.getParameter("updateTimeS");
		Date updateTimeS = null;
		if(updateTimeS_!=null&&!"".equals(updateTimeS_)) {
			updateTimeS = CastUtil.toDateT(updateTimeS_);
		}
		String updateTimeE_ = request.getParameter("updateTimeE");
		Date updateTimeE = null;
		if(updateTimeE_!=null&&!"".equals(updateTimeE_)) {
			updateTimeE = CastUtil.toDateT(updateTimeE_);
		}
		ActivityModel activityModel = new ActivityModel();
		activityModel.setActId(actId);
		activityModel.setActNo(actNo);
		activityModel.setActName(actName);
		activityModel.setActJoinNum(actJoinNum);
		activityModel.setActState(actState);
		activityModel.setActStartTimeS(actStartTimeS);
		activityModel.setActStartTimeE(actStartTimeE);
		activityModel.setActEndTimeS(actEndTimeS);
		activityModel.setActEndTimeE(actEndTimeE);
		activityModel.setCreateTimeS(createTimeS);
		activityModel.setCreateTimeE(createTimeE);
		activityModel.setUpdateTimeS(updateTimeS);
		activityModel.setUpdateTimeE(updateTimeE);
		//查询活动
		List<ActivityModel> activitys = activityService.findActivity(activityModel);
        return activitys;
    }
	
}