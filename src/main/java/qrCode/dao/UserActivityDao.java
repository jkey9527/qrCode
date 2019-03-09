package qrCode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import qrCode.model.ActivityModel;
import qrCode.model.SignModel;
import qrCode.model.UserActivityModel;
import qrCode.model.UserModel;

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
	
	/**
	 * 初始化邀请用户
	 * @param userActivityModel
	 * @return
	 */
	List<UserModel> initInviteUser(UserActivityModel userActivityModel);

	/**
	 * 查询用户是否签到
	 * @param userActivityModel
	 * @return
	 */
	List<UserActivityModel> findIsSign(UserActivityModel userActivityModel);
	
	/**
	 * 签到
	 * @param userActivityModel
	 */
	void sign(UserActivityModel userActivityModel);

	/**
	 * 查询签到情况
	 * @param signModel
	 * @return
	 */
	List<ActivityModel> findUserActivity(SignModel signModel);
}
