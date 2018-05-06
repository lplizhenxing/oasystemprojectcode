package com.zszd.ai.service.sysfunctions;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.zszd.ai.dao.sysfunctions.RoleDao;
import com.zszd.ai.pojo.Role;
import com.zszd.ai.tools.MyBatisUtil;
@Service
public class RoleServiceImpl implements RoleService {

	
	@Resource
	private RoleDao roleDao;
	
	/**
	 * 查询所有的角色信息
	 * <p>Title queryAllRoleInfo</p>
	 * <p>Description </p>
	 * @return
	 * @see com.zszd.ai.service.sysfunctions.RoleService#queryAllRoleInfo()
	 */
	@Override
	public List<Role> queryAllRoleInfo() {
		return roleDao.queryAllRoleInfo();
	}

	public String queryRoleNameByRoleId(int roleId) {	
		return roleDao.queryRoleNameByRoleId(roleId);
	}

	@Override
	public List<Role> queryAllRoleInfoByCompany() {
		// TODO Auto-generated method stub
		return roleDao.queryAllRoleInfoByCompany();
	}

}
