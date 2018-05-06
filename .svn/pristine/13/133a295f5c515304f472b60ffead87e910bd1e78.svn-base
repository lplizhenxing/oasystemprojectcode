package com.zszd.ai.service.department;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Department;

public interface DepartmentService {
	/**
	 * 
	 * @Title          insertDepartment
	 * @Description    添加部门信息
	 * @Tags           @param department
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:32:36
	 */
	int insertDepartment(Department department);

	/**
	 * 
	 * @Title          updateDepartment
	 * @Description     修改部门信息
	 * @Tags           @param department
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:32:55
	 */
	int updateDepartment(Department department);

	//  删除状态为0的部门
	// int deleteDepartmentByState();
	/**
	 * 
	 * @Title          queryDepartmentById
	 * @Description    通过id查询部门信息
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         Department   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:33:10
	 */
	Department queryDepartmentById(int id);

	/**
	 * 
	 * @Title          queryDepartmentInfo
	 * @Description    查询所有部门信息
	 * @Tags           @return   
	 * @Return         List<Department>   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:33:19
	 */
	List<Department> queryDepartmentInfo();
	/**
	 * 
	 * @Title          countDevByDepartmentId
	 * @Description    查询部门下的研发组数量
	 * @Tags           @param departmentId
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           Jan 25, 2018        7:01:25 PM
	 */
	int countDevByDepartmentId(int departmentId);
	/**
	 * 
	 * @Title          deleteDepartmentById
	 * @Description    通过id删除部门
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           Jan 25, 2018        7:08:42 PM
	 */
	int deleteDepartmentById(int id);
    /**
     * 
     * @Title          queryDepartmentInfoByCompanyId
     * @Description    查看本公司的部门
     * @Tags           @param companyId
     * @Tags           @return   
     * @Return         List<Department>   
     * @throws
     * @author           lizx
     * @date           2018-1-29        上午2:51:12
     */
	List<Department> queryDepartmentInfoByCompanyId(int companyId);

	List<Department> getDepartmentListBy(String queryDepartmentName,
			String queryCompanyName, int currentPage, int pageSize);

	int getDepartmentCount(String queryDepartmentName, String queryCompanyName);
}
