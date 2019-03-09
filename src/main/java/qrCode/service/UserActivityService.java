package qrCode.service;



import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import qrCode.model.ActivityModel;
import qrCode.model.SignModel;
import qrCode.model.UserActivityModel;
import qrCode.model.UserModel;

/**
 * 用户-活动服务
 * @author mayn
 *
 */
public interface UserActivityService {

	/**
	 * 邀请用户
	 * @param userActivityModel
	 */
	@Transactional
	void cancelUser(String[] userIds,Integer actId);

	/**
	 * 取消邀请
	 * @param userActivityModel
	 */
	@Transactional
	void inviteUser(String[] userIds,Integer actId);
	
	/**
	 * 初始化邀请的用户
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
