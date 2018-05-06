package com.zszd.ai.service.schedule;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.schedule.ScheduleDao;
import com.zszd.ai.pojo.Schedule;
@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Resource
	private ScheduleDao scheduleDao;
	
	@Override
	public List<Schedule> getScheduleByFinishName(String name) {
       return scheduleDao.getScheduleByFinishName(name);
	}

	@Override
	public List<Schedule> getScheduleByCreateName(String name) {
		return scheduleDao.getScheduleByCreateName(name);
	}

	@Override
	public int addScheduleInfo(Schedule schedule) {
		return scheduleDao.addScheduleInfo(schedule);
	}

	@Override
	public int oprScheduleInfo(Schedule schedule) {
		// TODO Auto-generated method stub
		return scheduleDao.oprScheduleInfo(schedule);
	}

	
}
