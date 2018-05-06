package com.zszd.ai.dao.sysuser;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.SysUser;
/**
 * 系统用户DAO接口
 * @author lizx 20180103
 *
 */
public interface SysUserDao {
	
	/**
	 * 
	 * @Title          getLoginUser
	 * @Description    通过name获取sysUser对象
	 * @Tags           @param name
	 * @Tags           @return
	 * @Tags           @throws Exception   
	 * @Return         SysUser   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-12        下午3:34:48
	 */
	SysUser getLoginUser(@Param("name") String name) throws Exception;

	int insert(SysUser sysUser);
    /**
     * 
     * @Title          query
     * @Description    根据用户名和密码 查询是否有这个用户
     * @Tags           @param sysUser
     * @Tags           @return   
     * @Return         int   
     * @throws
     * @author           lizx
     * @date           2018-2-1        下午2:13:19
     */
	int query(SysUser sysUser);

	int updateLoginRecord(SysUser sysUser);

	int queryLoginCountsByName(@Param("name")String name);

	int getUserIdByUserName(@Param("name")String name);

	SysUser getUserInfoByUserName(@Param("name")String name);

	int updateUserPasswordInfo(SysUser sysUser);

	int updateSysUser(SysUser sysUser);

	List<SysUser> getAllUserInfo();

	List<SysUser> getAllOnLineUserInfo();
    /**
     * 查询所有系统用户
     * @Title          queryAllSysUserInfo
     * @Description    TODO
     * @Tags           @return   
     * @Return         List<SysUser>   
     * @throws
     * @author           lizx
     * @date           2018-2-14        下午9:56:41
     */
	List<SysUser> queryAllSysUserInfo();
	


}
