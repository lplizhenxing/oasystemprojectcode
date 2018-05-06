package com.zszd.ai.service.workpoint;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.employee.EmployeeDao;
import com.zszd.ai.dao.workpoint.WorkPointDao;
import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.Page;
import com.zszd.ai.pojo.Workpoint;

/**
 * 工分接口实现
 * 
 * @author lizx 20180103
 * 
 */
@Service
public class WorkPointServiceImpl implements WorkPointService {
	@Resource
	private EmployeeDao employeeDao;
	@Resource
	private WorkPointDao workPointDao;

	@Override
	public List<Workpoint> queryAllWorkPointInfo() {
		return workPointDao.queryAllWorkPointInfo();
	}

	@Override
	public boolean addWorkPointRecord(Employee employee, Workpoint wp) {
		boolean flag = false;
		int employeeId = employeeDao.queryIdByName(employee.getName());
		int workpoints = employeeDao.queryWorkPointByName(employee.getName());
		employee.setWorkpoints(workpoints + wp.getWorkpoint());
		employee.setId(employeeId);
		wp.setEmployeeId(employeeId);
		int row1 = workPointDao.addWorkPointRecord(wp);
		int row2 = employeeDao.updateEmployeeInfo(employee);
		if (row1 > 0 && row2 > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Workpoint> queryWorkPointInfoLikeName(String name) {
		List<Workpoint> workpoints = new ArrayList<Workpoint>();
		List<Integer> list = employeeDao.queryIdLikeName(name);
		if (list != null) {
			for (int employeeId : list) {
				List<Workpoint> woList = workPointDao
						.queryWorkPointRecordByEmployeeId(employeeId);
				workpoints.addAll(woList);
			}
		}
		return workpoints;
	}

	@Override
	public int getWorkPointInfoCountLikeName(String name) {
		int rows = 0;
		List<Integer> list = employeeDao.queryIdLikeName(name);
		if (list != null) {
			for (int employeeId : list) {
				rows += workPointDao
						.getWorkPointRecordCountByEmployeeId(employeeId);
			}
		}
		return rows;
	}

	@Override
	public List<Workpoint> queryWorkPointInfoLikeNamePage(Page page, String name) {
		List<Workpoint> workpoints = new ArrayList<Workpoint>();
		int currPageNum = page.getCurrentPageNum();
		int pageSize = page.getPageSize();
		workpoints = workPointDao.queryWorkPointRecordPageLikeEmployeeName(
				name, currPageNum, pageSize);
		return workpoints;
	}

	@Override
	public List<Workpoint> queryWorkPointInfoByEmployeeId(int employeeId) {
		List<Workpoint> workpoints = new ArrayList<Workpoint>();
		workpoints = workPointDao.queryWorkPointInfoByEmployeeId(employeeId);
		return workpoints;
	}

}
