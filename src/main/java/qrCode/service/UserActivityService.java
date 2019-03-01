package qrCode.service;



import java.util.List;

import qrCode.model.ActivityModel;
import qrCode.model.UserActivityModel;

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
	void cancelUser(UserActivityModel userActivityModel);

	/**
	 * 取消邀请
	 * @param userActivityModel
	 */
	void inviteUser(UserActivityModel userActivityModel);

}
