package qrCode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qrCode.dao.UserActivityDao;
import qrCode.model.UserActivityModel;
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
	public void cancelUser(UserActivityModel userActivityModel) {
		userActivityDao.cancelUser(userActivityModel);
	}

	@Override
	public void inviteUser(UserActivityModel userActivityModel) {
		userActivityDao.inviteUser(userActivityModel);
	}
	
	
	

}
