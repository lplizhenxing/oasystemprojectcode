package com.zszd.ai.service.sysuser;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.zszd.ai.dao.employee.EmployeeDao;
import com.zszd.ai.dao.sysuser.SysUserDao;
import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.SysUser;
import com.zszd.ai.tools.MyBatisUtil;

/**
 * 系统用户接口实现
 * 
 * @author lizx 20180103
 * 
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Resource
	private SysUserDao sysDao;

	@Resource
	private EmployeeDao employeeDao;

	@Override
	public int queryLoginCountsByName(String name) {
		return sysDao.queryLoginCountsByName(name);
	}

	@Override
	public SysUser getUserInfoByUserName(String name) {
		return sysDao.getUserInfoByUserName(name);
	}

	@Override
	public SysUser login(String userName, String password) throws Exception {
		SysUser sysUser = null;
		sysUser = sysDao.getLoginUser(userName);
		// 匹配密码
		if (sysUser != null) {
			if (!sysUser.getPassword().equals(password)) {
				sysUser = null;
			}
		}
		return sysUser;
	}

	@Override
	public int updateLoginRecord(SysUser sysUser) {
		return sysDao.updateLoginRecord(sysUser);
	}

	/**
	 * 
	 * <p>
	 * Title updateUserPasswordInfo
	 * </p>
	 * <p>
	 * 更改密码
	 * </p>
	 * 
	 * @param sysUser
	 * @return
	 * @see com.zszd.ai.service.sysuser.SysUserService#updateUserPasswordInfo(com.zszd.ai.pojo.SysUser)
	 */
	@Override
	public int updateUserPasswordInfo(SysUser sysUser) {
		return sysDao.updateUserPasswordInfo(sysUser);
	}

	/**
	 * 查询所有系统用户
	 * <p>
	 * Title queryAllSysUserInfo
	 * </p>
	 * <p>
	 * Description
	 * </p>
	 * 
	 * @return
	 * @see com.zszd.ai.service.sysuser.SysUserService#queryAllSysUserInfo()
	 */
	@Override
	public List<SysUser> queryAllSysUserInfo() {
		// TODO Auto-generated method stub
		return sysDao.queryAllSysUserInfo();
	}

	public boolean insertNewEmployee(SysUser sysUser, Employee employee) {

		boolean flag = false;
		try {
			int rows1 = sysDao.insert(sysUser);
			int rows2 = employeeDao.insert(employee);
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insert(SysUser sysUser) {
		SqlSession sqlSession = null;
		int rows = 0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			rows = sqlSession.getMapper(SysUserDao.class).insert(sysUser);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return rows;
	}

	@Override
	public int query(SysUser sysUser) {
		SqlSession sqlSession = null;
		int rows = 0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			rows = sqlSession.getMapper(SysUserDao.class).query(sysUser);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return rows;
	}

	@Override
	public int getUserIdByUserName(String name) {
		SqlSession sqlSession = null;
		int rows = 0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			rows = sqlSession.getMapper(SysUserDao.class).getUserIdByUserName(
					name);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return rows;
	}

	@Override
	public int updateSysUser(SysUser sysUser) {
		SqlSession sqlSession = null;
		int rows = 0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			rows = sqlSession.getMapper(SysUserDao.class)
					.updateSysUser(sysUser);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return rows;
	}

	@Override
	public List<SysUser> getAllUserInfo() {
		SqlSession sqlSession = null;
		List<SysUser> sysUsers = new ArrayList<SysUser>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			sysUsers = sqlSession.getMapper(SysUserDao.class).getAllUserInfo();
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return sysUsers;
	}

	@Override
	public List<SysUser> getAllOnLineUserInfo() {
		SqlSession sqlSession = null;
		List<SysUser> sysUsers = new ArrayList<SysUser>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			sysUsers = sqlSession.getMapper(SysUserDao.class)
					.getAllOnLineUserInfo();
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return sysUsers;
	}

}
