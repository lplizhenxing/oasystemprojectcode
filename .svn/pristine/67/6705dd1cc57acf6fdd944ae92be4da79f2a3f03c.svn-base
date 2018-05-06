package com.zszd.ai.service.department;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.zszd.ai.dao.department.DepartmentDao;
import com.zszd.ai.pojo.Department;
import com.zszd.ai.tools.MyBatisUtil;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentDao departmentDao;

	/**
	 * 查看所有的部门 经理权限查看
	 * <p>
	 * Title queryDepartmentInfo
	 * </p>
	 * <p>
	 * Description
	 * </p>
	 * 
	 * @return
	 * @see com.zszd.ai.service.department.DepartmentService#queryDepartmentInfo()
	 */
	@Override
	public List<Department> queryDepartmentInfo() {
		return departmentDao.queryDepartmentInfo();
	}

	@Override
	public int insertDepartment(Department department) {
		return departmentDao.insertDepartment(department);
	}

	@Override
	public int updateDepartment(Department department) {
		return departmentDao.updateDepartment(department);
	}

	@Override
	public Department queryDepartmentById(int id) {
		return departmentDao.queryDepartmentById(id);
	}

	@Override
	public int countDevByDepartmentId(int departmentId) {
		return departmentDao.countDevByDepartmentId(departmentId);
	}

	@Override
	public int deleteDepartmentById(int id) {
		return departmentDao.deleteDepartmentById(id);
	}

	@Override
	public List<Department> queryDepartmentInfoByCompanyId(int companyId) {
		return departmentDao.queryDepartmentInfoByCompanyId(companyId);
	}

	@Override
	public List<Department> getDepartmentListBy(String queryDepartmentName,
			String queryCompanyName, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return departmentDao.getDepartmentListBy(queryDepartmentName,queryCompanyName,currentPage,pageSize);
	}

	@Override
	public int getDepartmentCount(String queryDepartmentName,
			String queryCompanyName) {
		// TODO Auto-generated method stub
		return departmentDao.getDepartmentCount(queryDepartmentName,queryCompanyName);
	}

}
