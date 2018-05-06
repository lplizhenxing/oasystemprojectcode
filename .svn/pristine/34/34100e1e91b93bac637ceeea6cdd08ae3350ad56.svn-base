package com.zszd.ai.dao.leave;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Leave;

public interface LeaveDao {

	List<Leave> queryAllLeaveInfo();

	List<Leave> queryAllLeaveInfoByName(@Param("name")String name);
	
	List<Leave> queryAllLeaveInfoByCompanyId(@Param("companyId")Integer companyId);

	List<Leave> queryAllLeaveInfoByCompanyIdAndName(@Param("companyId")Integer companyId, @Param("name")String name);
	
	int addLeaveInfo(Leave leave);

	int oprLeaveInfo(Leave leave);

}
