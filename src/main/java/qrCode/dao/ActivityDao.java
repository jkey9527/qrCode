package qrCode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import qrCode.model.ActivityModel;

/**
 * 活动持久层
 * @author mayn
 *
 */
@Mapper
public interface ActivityDao {

	/**
	 * 添加活动
	 * @param ActivityModel
	 */
	void addActivity(ActivityModel activityModel);

	/**
	 * 修改活动
	 * @param ActivityModel
	 */
	void updateActivity(ActivityModel activityModel);

	/**
	 * 删除活动
	 * @param ActivityModel
	 */
	void deleteActivity(ActivityModel activityModel);

	/**
	 * 查询活动
	 * @param ActivityModel
	 * @return
	 */
	List<ActivityModel> findActivity(ActivityModel activityModel);

}
