package qrCode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qrCode.dao.ActivityDao;
import qrCode.model.ActivityModel;
import qrCode.service.ActivityService;

/**
 * 活动服务实现类
 * @author mayn
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;
	
	@Override
	public void addActivity(ActivityModel activityModel) {
		activityDao.addActivity(activityModel);
	}

	@Override
	public void updateActivity(ActivityModel activityModel) {
		activityDao.updateActivity(activityModel);
		
	}

	@Override
	public void deleteActivity(ActivityModel activityModel) {
		activityDao.deleteActivity(activityModel);
		
	}

	@Override
	public List<ActivityModel> findActivity(ActivityModel activityModel) {
		return activityDao.findActivity(activityModel);
	}

}
