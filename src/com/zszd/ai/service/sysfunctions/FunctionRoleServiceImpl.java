package com.zszd.ai.service.sysfunctions;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.sysfunctions.FunctionRoleDao;
import com.zszd.ai.pojo.FunctionRole;
@Service
public class FunctionRoleServiceImpl implements FunctionRoleService {

	@Resource 
	private FunctionRoleDao functionRoleDao;
	
	/**
	 * 
	 * <p>Title queryAllFunctionRoleInfoByRoleId</p>
	 * <p>根据角色ID查找对应的功能 </p>
	 * @param roleId
	 * @return
	 * @see com.zszd.ai.service.sysfunctions.FunctionRoleService#queryAllFunctionRoleInfoByRoleId(int)
	 */
	@Override
	public List<FunctionRole> queryAllFunctionRoleInfoByRoleId(
			int roleId) {
		return functionRoleDao.queryAllFunctionRoleInfoByRoleId(roleId);
	}
	
	/**
	 * 
	 * <p>Title queryAllFunctionRoleInfo</p>
	 * <p>查询所有的功能角色信息 </p>
	 * @return
	 * @see com.zszd.ai.service.sysfunctions.FunctionRoleService#queryAllFunctionRoleInfo()
	 */
	@Override
	public List<FunctionRole> queryAllFunctionRoleInfo() {
		return functionRoleDao.queryAllFunctionRoleInfo();
	}

	/**
	 * 
	 * <p>Title queryAllFunctionRoleInfo</p>
	 * <p>删除配置的功能角色信息 </p>
	 * @return
	 * @see com.zszd.ai.service.sysfunctions.FunctionRoleService#queryAllFunctionRoleInfo()
	 */
	@Override
	public int delFunctionRoleConfigInfoById(int functionRoleId) {
		return functionRoleDao.delFunctionRoleConfigInfoById(functionRoleId);
	}
	
	/**
	 * 
	 * <p>Title addFunctionRoleInfo</p>
	 * <p>添加功能配置信息 </p>
	 * @param functionRole
	 * @return
	 * @see com.zszd.ai.service.sysfunctions.FunctionRoleService#addFunctionRoleInfo(com.zszd.ai.pojo.FunctionRole)
	 */
	@Override
	public int addFunctionRoleInfo(FunctionRole functionRole) {
		return functionRoleDao.addFunctionRoleInfo(functionRole);
	}

	@Override
	public int getFunctionRoleCount(String queryFunctionName, int _queryUserRole) {
		// TODO Auto-generated method stub
		return functionRoleDao.getFunctionRoleCount(queryFunctionName,_queryUserRole);
	}

	@Override
	public List<FunctionRole> getFunctionRoleListBy(String queryFunctionName,
			int _queryUserRole, int currentPageNo, int pageSize) {
		// TODO Auto-generated method stub
		return functionRoleDao.getFunctionRoleListBy(queryFunctionName,_queryUserRole,currentPageNo,pageSize);
	}
}
