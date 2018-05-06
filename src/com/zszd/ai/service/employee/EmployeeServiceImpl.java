package com.zszd.ai.service.employee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.employee.EmployeeDao;
import com.zszd.ai.pojo.Employee;

/**
 * 员工接口实现
 * 
 * @author lizx 20180103
 * 
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeDao employeeDao;

	@Override
	public Employee getEmployeeInfoByLoginName(String name) {
		return employeeDao.getEmployeeInfoByLoginName(name);
	}

	@Override
	public String getEmployeeNameByLoginName(String loginname) {
		return employeeDao.getEmployeeNameByLoginName(loginname);
	}

	/**
	 * 查询所有员工信息
	 * <p>
	 * Title queryAllEmployeeInfo
	 * </p>
	 * <p>
	 * Description
	 * </p>
	 * 
	 * @return
	 * @see com.zszd.ai.service.employee.EmployeeService#queryAllEmployeeInfo()
	 */
	@Override
	public List<Employee> queryAllEmployeeInfo() {
		return employeeDao.queryAllEmployeeInfo();
	}

	/**
	 * 修改个人信息
	 * <p>
	 * Title updateAllInfo
	 * </p>
	 * <p>
	 * Description
	 * </p>
	 * 
	 * @param employee
	 * @return
	 * @see com.zszd.ai.service.employee.EmployeeService#updateAllInfo(com.zszd.ai.pojo.Employee)
	 */
	@Override
	public int updateAllInfo(Employee employee) {
		return employeeDao.updateAllInfo(employee);
	}

	@Override
	public int queryWorkPointByName(String name) {
		return employeeDao.queryWorkPointByName(name);
	}

	@Override
	public String queryNameById(int id) {
		return employeeDao.queryNameById(id);
	}

	@Override
	public int getEmployeeCountByGroupId(int groupId) {
		
		return employeeDao.getEmployeeCountByGroupId(groupId);
	}

	@Override
	public Employee queryEmployeeInfoById(int id) {
		return employeeDao.queryEmployeeInfoById(id);
	}

	@Override
	public int updateEmployeeInfo(Employee employee) {
		return employeeDao.updateEmployeeInfo(employee);
	}

	@Override
	public int queryWorkPointByAbbr(String name) {
		return employeeDao.queryWorkPointByAbbr(name);
	}

	@Override
	public int insert(Employee employee) {
		return employeeDao.insert(employee);
	}

	@Override
	public int queryIdByName(String name) {
		return employeeDao.queryIdByName(name);
	}

	@Override
	public List<Integer> queryIdLikeName(String name) {
		return employeeDao.queryIdLikeName(name);
	}

	@Override
	public List<Employee> queryAllEmployeeInfoByCompanyId(int companyId) {
		return employeeDao.queryAllEmployeeInfoByCompanyId(companyId);
	}

	@Override
	public List<Employee> queryAllEmployeeInfoByClassLeader(String name) {
		// TODO Auto-generated method stub
		return employeeDao.queryAllEmployeeInfoByClassLeader(name);
	}

	@Override
	public List<Employee> queryAllClassLeader() {
		// TODO Auto-generated method stub
		return employeeDao.queryAllClassLeader();
	}

	@Override
	public List<Employee> queryAllClassTeacher() {
		// TODO Auto-generated method stub
		return employeeDao.queryAllClassTeacher();
	}

	@Override
	public int getEmployeeCount(String queryEmployeeName,
			String queryDevgroupName, String queryDepartmentName,
			String queryCompanyName, int _queryUserRole) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeCount(queryEmployeeName,
				queryDevgroupName, queryDepartmentName, queryCompanyName,
				_queryUserRole);
	}

	@Override
	public int getEmployeeCountByClassLeader(String queryEmployeeName,
			String queryDevgroupName, String queryDepartmentName,
			String queryCompanyName, int _queryUserRole, String name) {
		return employeeDao.getEmployeeCountByClassLeader(queryEmployeeName,
				queryDevgroupName, queryDepartmentName, queryCompanyName,
				_queryUserRole,name);
		
	}

	@Override
	public List<Employee> getEmployeeListBy(String queryEmployeeName,
			String queryDevgroupName, String queryDepartmentName,
			String queryCompanyName, int _queryUserRole, int currentPage,
			int pageSize,String sort) {
		return employeeDao.getEmployeeListBy(queryEmployeeName,
				queryDevgroupName, queryDepartmentName, queryCompanyName,
				_queryUserRole,currentPage, pageSize,sort);

	}

	@Override
	public List<Employee> getEmployeeListByClassLeader(
			String queryEmployeeName, String queryDevgroupName,
			String queryDepartmentName, String queryCompanyName,
			int _queryUserRole, String name, int currentPage, int pageSize,String sort) {
		return employeeDao.getEmployeeListByClassLeader(queryEmployeeName,
				queryDevgroupName, queryDepartmentName, queryCompanyName,
				_queryUserRole,name,currentPage, pageSize,sort);

	}

	@Override
	public Employee checkabbrExist(String abbr) {
		// TODO Auto-generated method stub
		return employeeDao.checkabbrExist(abbr);
	}

}
