package com.zszd.ai.service.sysfunctions;

import java.util.List;

import com.zszd.ai.pojo.Functions;
/**
 * 
 * @ClassName       FunctionsService
 * @Description    功能模块
 * @author            lizx
 * @date           2018-1-21        上午11:40:34
 */
public interface FunctionsService {
    /**
     * 
     * @Title          queryAllFunctionsInfo
     * @Description    查询所有的功能信息
     * @Tags           @return   
     * @Return         List<Functions>   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:40:41
     */
	List<Functions> queryAllFunctionsInfo();
    /**
     * 
     * @Title          addFunctionsInfo
     * @Description    新增功能
     * @Tags           @param functions
     * @Tags           @return   
     * @Return         int   
     * @throws
     * @author           lizx
     * @date           2018-1-21        下午5:08:36
     */
	int addFunctionsInfo(Functions functions);
	/**
	 * 
	 * @Title          queryFunctionsInfoById
	 * @Description    根据ID查询功能信息
	 * @Tags           @param functionId
	 * @Tags           @return   
	 * @Return         Functions   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        下午5:17:58
	 */
	Functions queryFunctionsInfoById(int functionId);
	/**
	 * 
	 * @Title          updateFunctionsInfo
	 * @Description    更新功能信息
	 * @Tags           @param functions
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        下午5:28:38
	 */
	int updateFunctionsInfo(Functions functions);
	/**
	 * 
	 * @Title          delFunctionInfoById
	 * @Description    删除功能信息
	 * @Tags           @param functionId
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-13        下午11:41:27
	 */
	int delFunctionInfoById(int functionId);
	int getFunctionCount(String queryFunctionName, String queryFunctionPath);
	List<Functions> getFunctionListBy(String queryFunctionName,
			String queryFunctionPath, int currentPageNo, int pageSize);
}
