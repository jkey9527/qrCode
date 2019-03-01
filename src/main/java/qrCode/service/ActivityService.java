package qrCode.service;



import java.util.List;

import qrCode.model.ActivityModel;

/**
 * 活动服务
 * @author mayn
 *
 */
public interface ActivityService {
	/**
	 * 新增活动
	 * @param activityModel
	 */
	void addActivity(ActivityModel activityModel);
	
	/**
	 * 修改活动
	 * @param activityModel
	 */
	void updateActivity(ActivityModel activityModel);

	/**
	 * 删除活动
	 * @param activityModel
	 */
	void deleteActivity(ActivityModel activityModel);

	/**
	 * 查询活动
	 * @param activityModel
	 * @return
	 */
	List<ActivityModel> findActivity(ActivityModel activityModel);

}
