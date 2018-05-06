package com.zszd.ai.dao.department;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Department;

public interface DepartmentDao {
	/**
	 * 
	 * @Title          insertDepartment
	 * @Description    添加部门信息
	 * @Tags           @param department
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:38:26
	 */
	int insertDepartment(Department department);
	/**
	 * 
	 * @Title          updateDepartment
	 * @Description    修改部门信息
	 * @Tags           @param department
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:38:39
	 */
	int updateDepartment(Department department);

	
	/**
	 * 
	 * @Title          queryDepartmentById
	 * @Description    通过查询部门信息
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         Department   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:38:47
	 */
	Department queryDepartmentById(@Param("id")Integer id);

	/**
	 * 
	 * 
	 * @Title          queryDepartmentInfo
	 * @Description    查询所有部门信息
	 * @Tags           @return   
	 * @Return         List<Department>   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:39:08
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
	 * @date           Jan 25, 2018        6:55:19 PM
	 */
	int countDevByDepartmentId(@Param("departmentId")Integer departmentId);
	/**
	 * 
	 * @Title          deleteDepartmentById
	 * @Description    通过id删除部门
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           Jan 25, 2018        7:06:34 PM
	 */
	int deleteDepartmentById(@Param("id")Integer id);
	/**
	 * 
	 * @Title          queryDepartmentInfoByCompanyId
	 * @Description    查看本公司的部门
	 * @Tags           @param companyId
	 * @Tags           @return   
	 * @Return         List<Department>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-29        上午2:52:24
	 */
	List<Department> queryDepartmentInfoByCompanyId(@Param("companyId")Integer companyId);
	List<Department> getDepartmentListBy(@Param("queryDepartmentName")String queryDepartmentName,
			@Param("queryCompanyName")String queryCompanyName, @Param("currentPage")int currentPage, @Param("pageSize")int pageSize);
	int getDepartmentCount(@Param("queryDepartmentName")String queryDepartmentName, @Param("queryCompanyName")String queryCompanyName);
}
