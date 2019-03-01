package qrCode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import qrCode.model.ActivityModel;
import qrCode.model.UserActivityModel;

/**
 * 活动持久层
 * @author mayn
 *
 */
@Mapper
public interface UserActivityDao {

	/**
	 * 取消邀请
	 * @param userActivityModel
	 */
	void cancelUser(UserActivityModel userActivityModel);

	/**
	 * 邀请用户
	 * @param userActivityModel
	 */
	void inviteUser(UserActivityModel userActivityModel);

}
