package com.zszd.ai.service.company;

import java.util.List;

import com.zszd.ai.pojo.Classes;
import com.zszd.ai.pojo.Company;



public interface CompanyService {
	/**
	 * 
	 * @Title          insertCompany
	 * @Description    增加公司信息
	 * @Tags           @param company
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:33:58
	 */
	int insertCompany( Company company);
	/**
	 * 
	 * @Title          updateCompany
	 * @Description    修改公司信息
	 * @Tags           @param company
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:34:29
	 */
	int updateCompany( Company company);
//	// 删除状态为0的公司
//	int deleteCompanyByState();
	/**
	 * 
	 * @Title          queryCompanyById
	 * @Description    通过id查询公司信息
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         Company   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:34:39
	 */
	Company queryCompanyById(int id);
	/**
	 * 
	 * @Title          queryCompanyInfo
	 * @Description    查询所有公司信息
	 * @Tags           @return   
	 * @Return         List<Company>   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:35:04
	 */
	List<Company> queryCompanyInfo();
	/**
	 * 
	 * @Title          countDepartmentByCompanyId
	 * @Description    通过公司id获得部门数量
	 * @Tags           @param companyId
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           Jan 25, 2018        7:35:14 PM
	 */
	int countDepartmentByCompanyId( int companyId);
	/**
	 * 
	 * @Title          deleteCompanyById
	 * @Description    通过id删除公司
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           Jan 25, 2018        7:31:27 PM
	 */
	int deleteCompanyById( int id);
	List<Company> queryCompanyInfoByClassLeader(String name);
	int getCompanyCount(String queryClassName, String queryCompanyName);
	List<Company> getCompanyListBy(String queryClassName,
			String queryCompanyName, int currentPage, int pageSize);
}
