package com.zszd.ai.dao.report;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.zszd.ai.pojo.Report;
import com.zszd.ai.pojo.ReportType;

public interface ReportDao {
	/**
	 * 增加日志
	 * @param report
	 * @return
	 */
	int addReport(Report report);
	/**
	 * 修改日志
	 * @param report
	 * @return
	 */
	int modifyReport(Report report);
	/**
	 * 删除日志通过用户名
	 * @param username
	 * @return
	 */
	 int deleteUserbyUsername(@Param("username")String username);
	 /**
	  * 删除日志通过Id
	  * @param id
	  * @return
	  */
	 int deleteUserbyId(@Param("id")Integer id);
	 /**
	  * 通过用户名查询日志
	  * @param userName
	  * @return
	  */
	 
	 
	 List<Report> getUserbyuserName(String userName);
	 /**
	  * 查询日志
	  * @param typeId
	  * @return
	  */
	List<Report> getReportListByReportType(@Param("typeId")Integer typeId);
	/**
	 * 查询所有日志
	 * @return
	 */
	
	List<Report> getAllReportList();
	/**
	 * 查询ID对应的Report
	 * @param id
	 * @return
	 */
	Report getReportbyId(Integer id);
	/**
	 * 
	 * @Title          getAllReportType
	 * @Description    获取所有的报告类型
	 * @Tags           @return   
	 * @Return         List<ReportType>   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-9        下午10:53:19
	 */
	List<ReportType> getAllReportType();
	
	ReportType gettypeIdByReportTypename(@Param("typename")String typename);
	/**
	 * 
	 * @Title          getAllReportListByCompanyId
	 * @Description    根据公司名称查看本公司的报告  总裁和技术总监查看
	 * @Tags           @param companyId
	 * @Tags           @return   
	 * @Return         List<Report>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-29        上午2:36:09
	 */
	List<Report> getAllReportListByCompanyId(@Param("companyId")Integer companyId);
	
	//分页
	int getAllReportCountByUserNameBy(@Param("queryEmployeeName")String queryEmployeeName,
			@Param("queryReporttype")String queryReporttype, @Param("createDate")String createDate, @Param("name")String name);
	int getAllReportCountByCompanyIdBy(@Param("queryEmployeeName")String queryEmployeeName,
			@Param("queryReporttype")String queryReporttype, @Param("createDate")String createDate, @Param("companyId")int companyId);
	int getAllReportCountBy(@Param("queryEmployeeName")String queryEmployeeName,
			@Param("queryReporttype")String queryReporttype, @Param("createDate")String createDate);
	List<Report> getAllReportListByUserNameBy(@Param("queryEmployeeName")String queryEmployeeName,
			@Param("queryReporttype")String queryReporttype, @Param("createDate")String createDate, @Param("name")String name,
			 @Param("currentPage")int currentPage,  @Param("pageSize")int pageSize);
	List<Report> getAllReportListByCompanyIdBy(@Param("queryEmployeeName")String queryEmployeeName,
			@Param("queryReporttype")String queryReporttype, @Param("createDate")String createDate, @Param("companyId")int companyId,
			 @Param("currentPage")int currentPage,  @Param("pageSize")int pageSize);
	List<Report> getAllReportList(@Param("queryEmployeeName")String queryEmployeeName,
			@Param("queryReporttype")String queryReporttype, @Param("createDate")String createDate, @Param("currentPage")int currentPage,
			 @Param("pageSize")int pageSize);
}
