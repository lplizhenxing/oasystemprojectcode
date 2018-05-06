package com.zszd.ai.service.leave;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.leave.LeaveDao;
import com.zszd.ai.pojo.Leave;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Resource 
	private LeaveDao leaveDao;
	
	@Override
	public int addLeaveInfo(Leave leave) {
		return leaveDao.addLeaveInfo(leave);
		
	}

	@Override
	public List<Leave> queryAllLeaveInfo() {
		
		return leaveDao.queryAllLeaveInfo();
	}

	@Override
	public List<Leave> queryAllLeaveInfoByName(String name) {
		
		return leaveDao.queryAllLeaveInfoByName(name);
	}
	
	/**
	 * 处理请假审核情况
	 * <p>Title oprLeaveInfo</p>
	 * <p>Description </p>
	 * @param leave
	 * @return
	 * @see com.zszd.ai.service.leave.LeaveService#oprLeaveInfo(com.zszd.ai.pojo.Leave)
	 */
	@Override
	public int oprLeaveInfo(Leave leave) {
		return leaveDao.oprLeaveInfo(leave);
	}
	
	@Override
	public List<Leave> queryAllLeaveInfoByCompanyId(int companyId) {
		
		return leaveDao.queryAllLeaveInfoByCompanyId(companyId);
	}

	@Override
	public List<Leave> queryAllLeaveInfoByCompanyIdAndName(int companyId,
			String name) {
		return leaveDao.queryAllLeaveInfoByCompanyIdAndName(companyId, name);
	}


}
