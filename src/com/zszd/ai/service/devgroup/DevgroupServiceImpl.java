package com.zszd.ai.service.devgroup;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.zszd.ai.dao.devgroup.DevgroupDao;
import com.zszd.ai.pojo.Devgroup;
import com.zszd.ai.tools.MyBatisUtil;
@Service
public class DevgroupServiceImpl implements DevgroupService {

	@Resource
	private DevgroupDao devgroupDao;
	
	/**
	 * 查询所有的研发组
	 * <p>Title queryAllDevGroupInfo</p>
	 * <p>Description </p>
	 * @return
	 * @see com.zszd.ai.service.devgroup.DevgroupService#queryAllDevGroupInfo()
	 */
	@Override
	public List<Devgroup> queryAllDevGroupInfo() {
		return devgroupDao.queryAllDevGroupInfo();
	}

	@Override
	public String queryNameById(int id) {
		return devgroupDao.queryNameById(id);
	}

	@Override
	public Devgroup queryDevGroupInfoById(int id) {
		return devgroupDao.queryDevGroupInfoById(id);
	}

	@Override
	public int updateDevGroupInfo(Devgroup devgroup) {
		return devgroupDao.updateDevGroupInfo(devgroup);
	}

	@Override
	public int deleteDevGroupById(int id) {
		return devgroupDao.deleteDevGroupById(id);
	}

	@Override
	public int insertDevGroup(Devgroup devgroup) {
		return devgroupDao.insertDevGroup(devgroup);
	}

	@Override
	public int getDevGroupCountByDepartmentId(int id) {
		return devgroupDao.getDevGroupCountByDepartmentId(id);
	}

	@Override
	public List<Devgroup> queryAllDevGroupInfoByCompanyId(int companyId) {
		return devgroupDao.queryAllDevGroupInfoByCompanyId(companyId);
	}

	@Override
	public int getDevgroupCount(String queryDepartmentName,
			String queryCompanyName, String queryDevgroupName) {
		return devgroupDao.getDevgroupCount(queryDepartmentName,queryCompanyName,queryDevgroupName);
	}

	@Override
	public List<Devgroup> getDevgroupListBy(String queryDepartmentName,
			String queryCompanyName, String queryDevgroupName, int currentPage,
			int pageSize) {
		return devgroupDao.getDevgroupListBy(queryDepartmentName,queryCompanyName,queryDevgroupName,currentPage,pageSize);
	}

}
