package com.zszd.ai.service.sysfunctions;

import java.util.List;

import com.zszd.ai.pojo.Role;
/**
 * 
 * @ClassName       RoleService
 * @Description    角色模块
 * @author            lizx
 * @date           2018-1-21        上午11:44:00
 */
public interface RoleService {
    /**
     * 
     * @Title          queryAllRoleInfo
     * @Description    查询系统所有角色信息
     * @Tags           @return   
     * @Return         List<Role>   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:44:07
     */
	List<Role> queryAllRoleInfo();

	/**
	 * 
	 * @Title          queryRoleNameByRoleId
	 * @Description    根据角色ID获取角色名称
	 * @Tags           @param roleId
	 * @Tags           @return   
	 * @Return         String   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-29        上午2:04:02
	 */
	public String queryRoleNameByRoleId(int roleId) ;

	List<Role> queryAllRoleInfoByCompany();
}
