package com.zszd.ai.dao.schedule;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Schedule;


public interface ScheduleDao {

	List<Schedule> getScheduleByFinishName(@Param("name")String name);

	List<Schedule> getScheduleByCreateName(@Param("name")String name);

	int addScheduleInfo(Schedule schedule);

	int oprScheduleInfo(Schedule schedule);


}
