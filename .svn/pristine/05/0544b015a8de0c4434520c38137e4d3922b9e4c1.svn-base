package com.zszd.ai.dao.sysfunctions;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Functions;

public interface FunctionsDao {

	List<Functions> queryAllFunctionsInfo();

	int addFunctionsInfo(Functions functions);

	Functions queryFunctionsInfoById(@Param("id")Integer functionId);

	int updateFunctionsInfo(Functions functions);

	int delFunctionInfoById(@Param("id")Integer functionId);

	int getFunctionCount(@Param("queryFunctionName")String queryFunctionName, @Param("queryFunctionPath")String queryFunctionPath);

	List<Functions> getFunctionListBy(@Param("queryFunctionName")String queryFunctionName,
			@Param("queryFunctionPath")String queryFunctionPath, @Param("currentPageNo")Integer currentPageNo, @Param("pageSize")Integer pageSize);
}
