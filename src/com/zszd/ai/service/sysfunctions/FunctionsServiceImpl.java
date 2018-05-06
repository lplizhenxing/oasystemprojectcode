package com.zszd.ai.service.sysfunctions;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.zszd.ai.dao.sysfunctions.FunctionsDao;
import com.zszd.ai.pojo.Functions;
import com.zszd.ai.tools.MyBatisUtil;

@Service
public class FunctionsServiceImpl implements FunctionsService {

	@Resource
	private FunctionsDao functionsDao;

	/**
	 * 查看所有的功能信息
	 * <p>Title queryAllFunctionsInfo</p>
	 * <p>Description </p>
	 * @return
	 * @see com.zszd.ai.service.sysfunctions.FunctionsService#queryAllFunctionsInfo()
	 */
	@Override
	public List<Functions> queryAllFunctionsInfo() {
		return functionsDao.queryAllFunctionsInfo();
	}

	/**
	 * 添加功能  经理角色
	 * <p>Title addFunctionsInfo</p>
	 * <p>Description </p>
	 * @param functions
	 * @return
	 * @see com.zszd.ai.service.sysfunctions.FunctionsService#addFunctionsInfo(com.zszd.ai.pojo.Functions)
	 */
	@Override
	public int addFunctionsInfo(Functions functions) {
		return functionsDao.addFunctionsInfo(functions);
	}
	
	/**
	 * 修改功能
	 * <p>Title updateFunctionsInfo</p>
	 * <p>Description </p>
	 * @param functions
	 * @return
	 * @see com.zszd.ai.service.sysfunctions.FunctionsService#updateFunctionsInfo(com.zszd.ai.pojo.Functions)
	 */
	
	@Override
	public int updateFunctionsInfo(Functions functions) {
		return functionsDao.updateFunctionsInfo(functions);
	}
	
	/**
	 * 删除功能  不物理删除，只把状态置为0
	 * <p>Title delFunctionInfoById</p>
	 * <p>Description </p>
	 * @param functionId
	 * @return
	 * @see com.zszd.ai.service.sysfunctions.FunctionsService#delFunctionInfoById(int)
	 */
	@Override
	public int delFunctionInfoById(int functionId) {
		return functionsDao.delFunctionInfoById(functionId);
	}

	/**
	 * 查看某个功能的信息  用于修改 
	 * <p>Title queryFunctionsInfoById</p>
	 * <p>Description </p>
	 * @param functionId
	 * @return
	 * @see com.zszd.ai.service.sysfunctions.FunctionsService#queryFunctionsInfoById(int)
	 */
	@Override
	public Functions queryFunctionsInfoById(int functionId) {
		return functionsDao.queryFunctionsInfoById(functionId);
	}

	@Override
	public int getFunctionCount(String queryFunctionName,
			String queryFunctionPath) {
		// TODO Auto-generated method stub
		return functionsDao.getFunctionCount(queryFunctionName,queryFunctionPath);
	}

	@Override
	public List<Functions> getFunctionListBy(String queryFunctionName,
			String queryFunctionPath, int currentPageNo, int pageSize) {
		// TODO Auto-generated method stub
		return functionsDao.getFunctionListBy(queryFunctionName,queryFunctionPath,currentPageNo,pageSize);
	}

	

	
}
