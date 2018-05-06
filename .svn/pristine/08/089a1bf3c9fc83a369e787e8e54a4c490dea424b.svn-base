package com.zszd.ai.dao.devgroup;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Devgroup;
/**
 * 
 * @ClassName       DevgroupDao
 * @Description    研发组dao接口
 * @author            lvjc
 * @date           2018-1-21        下午8:36:25
 */
public interface DevgroupDao {
	/**
	 * 
	 * @Title          queryNameById
	 * @Description    通过id查询研发组信息
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         String   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:36:40
	 */
	String queryNameById(@Param("id")Integer id);
	/**
	 * 
	 * @Title          queryAllDevGroupInfo
	 * @Description    查询所有研发组信息
	 * @Tags           @return   
	 * @Return         List<Devgroup>   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:37:03
	 */
	List<Devgroup> queryAllDevGroupInfo();
	/**
	 * 
	 * @Title          queryDevGroupInfoById
	 * @Description    通过id查询研发组信息
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         Devgroup   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:37:21
	 */
	Devgroup queryDevGroupInfoById(@Param("id")Integer id);
	/**
	 * 
	 * @Title          updateDevGroupInfo
	 * @Description    更新研发组信息
	 * @Tags           @param devgroup
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:37:39
	 */
	int updateDevGroupInfo(Devgroup devgroup);
	/**
	 * 
	 * @Title          deleteDevGroupById
	 * @Description    通过id删除研发组
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:37:52
	 */
	int deleteDevGroupById(@Param("id")Integer id);
	/**
	 * 
	 * @Title          insertDevGroup
	 * @Description    插入研发组信息
	 * @Tags           @param devgroup
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:38:05
	 */
	int insertDevGroup(Devgroup devgroup);
	/**+
	 * 
	 * @Title          getDevGroupCountByDepartmentId
	 * @Description    获取研发组数量
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-22        下午5:39:08
	 */
	int getDevGroupCountByDepartmentId(@Param("id")Integer id);
	/**
	 * 
	 * @Title          queryAllDevGroupInfoByCompanyId
	 * @Description    只能查看本公司的研发组
	 * @Tags           @param companyId
	 * @Tags           @return   
	 * @Return         List<Devgroup>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-30        下午12:10:11
	 */
	List<Devgroup> queryAllDevGroupInfoByCompanyId(@Param("companyId")Integer companyId);
	int getDevgroupCount(@Param("queryDepartmentName")String queryDepartmentName, 
			@Param("queryCompanyName")String queryCompanyName,
			@Param("queryDevgroupName")String queryDevgroupName);
	List<Devgroup> getDevgroupListBy(@Param("queryDepartmentName")String queryDepartmentName,
			@Param("queryCompanyName")String queryCompanyName, 
			@Param("queryDevgroupName")String queryDevgroupName, @Param("currentPage")int currentPage,
			@Param("pageSize")int pageSize);
}
