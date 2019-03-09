package qrCode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qrCode.dao.UserActivityDao;
import qrCode.model.ActivityModel;
import qrCode.model.SignModel;
import qrCode.model.UserActivityModel;
import qrCode.model.UserModel;
import qrCode.service.UserActivityService;

/**
 * 活动服务实现类
 * @author mayn
 *
 */
@Service
public class UserActivityServiceImpl implements UserActivityService {

	@Autowired
	private UserActivityDao userActivityDao;

	@Override
	public void cancelUser(String[] userIds, Integer actId) {
		
		for (String userIdStr : userIds) {
			Integer userId = null;
			if (userIdStr != null) {
				userId = Integer.parseInt(userIdStr);
			}
			UserActivityModel userActivityModel = new UserActivityModel();
			userActivityModel.setActId(actId);
			userActivityModel.setUserId(userId);
			// 取消
			userActivityDao.cancelUser(userActivityModel);
		}
	}

	@Override
	public void inviteUser(String[] userIds, Integer actId) {
		for (String userIdStr : userIds) {
			Integer userId = null;
			if (userIdStr != null) {
				userId = Integer.parseInt(userIdStr);
			}
			UserActivityModel userActivityModel = new UserActivityModel();
			userActivityModel.setActId(actId);
			userActivityModel.setUserId(userId);
			userActivityModel.setUserActState(new Integer(0));
			// 邀请
			userActivityDao.inviteUser(userActivityModel);
		}
	}

	@Override
	public List<UserModel> initInviteUser(UserActivityModel userActivityModel) {
		return userActivityDao.initInviteUser(userActivityModel);
	}

	@Override
	public List<UserActivityModel> findIsSign(UserActivityModel userActivityModel) {
		return userActivityDao.findIsSign(userActivityModel);
	}

	@Override
	public void sign(UserActivityModel userActivityModel) {
		userActivityDao.sign(userActivityModel);
	}
	@Override
	public List<ActivityModel> findUserActivity(SignModel signModel) {
		return userActivityDao.findUserActivity(signModel);
	}
	
	

}
