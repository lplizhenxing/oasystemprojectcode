package com.zszd.ai.dao.sysfunctions;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.FunctionRole;

public interface FunctionRoleDao {
    /**
     * 
     * @Title          queryAllFunctionRoleInfoByRoleId
     * @Description    根据角色id展示对应的功能菜单
     * @Tags           @param roleIdsessin
     * @Tags           @return   
     * @Return         List<FunctionRole>   
     * @throws
     * @author           lizx
     * @date           2018-2-12        下午7:58:53
     */
	List<FunctionRole> queryAllFunctionRoleInfoByRoleId(@Param("roleId")Integer roleIdsessin);

	
	List<FunctionRole> queryAllFunctionRoleInfo();

	int addFunctionRoleInfo(FunctionRole functionRole);


	int delFunctionRoleConfigInfoById(@Param("id")Integer functionRoleId);


	int getFunctionRoleCount(@Param("queryFunctionName")String queryFunctionName, @Param("_queryUserRole")Integer _queryUserRole);


	List<FunctionRole> getFunctionRoleListBy(@Param("queryFunctionName")String queryFunctionName,
			@Param("_queryUserRole")Integer _queryUserRole, @Param("currentPageNo")Integer currentPageNo, @Param("pageSize")Integer pageSize);

}
