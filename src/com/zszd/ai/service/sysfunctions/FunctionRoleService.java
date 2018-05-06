package com.zszd.ai.service.sysfunctions;

import java.util.List;

import com.zszd.ai.pojo.FunctionRole;
/**
 * 
 * @ClassName       FunctionRoleService
 * @Description    功能角色模块
 * @author            lizx
 * @date           2018-1-21        上午11:39:57
 */
public interface FunctionRoleService {
	
    /**
     * 
     * @Title          queryAllFunctionRoleInfoByRoleId
     * @Description    根据角色ID查询所有的功能角色配置信息
     * @Tags           @param roleId
     * @Tags           @return   
     * @Return         List<FunctionRole>   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:40:23
     */
	List<FunctionRole> queryAllFunctionRoleInfoByRoleId(int roleId);

	/**
	 * 
	 * @Title          queryAllFunctionRoleInfo
	 * @Description    查询所有的功能角色配置信息
	 * @Tags           @return   
	 * @Return         List<FunctionRole>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:40:02
	 */
	List<FunctionRole> queryAllFunctionRoleInfo();
    /**
     * 
     * @Title          addFunctionRoleInfo
     * @Description    添加功能角色配置信息，给角色添加功能
     * @Tags           @param functionRole
     * @Tags           @return   
     * @Return         int   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:40:12
     */
	int addFunctionRoleInfo(FunctionRole functionRole);

	/**
	 * 
	 * @Title          delFunctionRoleConfigInfoById
	 * @Description    删除配置
	 * @Tags           @param functionRoleId
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        下午2:28:43
	 */
	int delFunctionRoleConfigInfoById(int functionRoleId);

	/**
	 * 得到角色配置数量
	 * @Title          getFunctionRoleCount
	 * @Description    TODO
	 * @Tags           @param queryFunctionName
	 * @Tags           @param _queryUserRole
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-21        下午9:25:11
	 */
	int getFunctionRoleCount(String queryFunctionName, int _queryUserRole);

	/**
	 * 返回查询得到的结果
	 * @Title          getFunctionRoleListBy
	 * @Description    TODO
	 * @Tags           @param queryFunctionName
	 * @Tags           @param _queryUserRole
	 * @Tags           @param currentPageNo
	 * @Tags           @param pageSize
	 * @Tags           @return   
	 * @Return         List<FunctionRole>   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-21        下午9:25:25
	 */
	List<FunctionRole> getFunctionRoleListBy(String queryFunctionName,
			int _queryUserRole, int currentPageNo, int pageSize);

}
