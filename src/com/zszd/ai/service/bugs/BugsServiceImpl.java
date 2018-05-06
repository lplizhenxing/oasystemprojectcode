package com.zszd.ai.service.bugs;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.bugs.BugsDao;
import com.zszd.ai.pojo.Bugs;

@Service
public class BugsServiceImpl implements BugsService {
	@Resource
	private BugsDao bugsDao;

	@Override
	public List<Bugs> queryAllDebugsInfo() {
		return bugsDao.queryAllDebugsInfo();
	}

	@Override
	public int addBugsInfo(Bugs bugs) {
		return bugsDao.addBugsInfo(bugs);
	}

	@Override
	public Bugs getBugsById(int id) {
		return bugsDao.getBugsById(id);
	}

	@Override
	public int updateBugsInfo(Bugs bugs) {
		return bugsDao.updateBugsInfo(bugs);
	}

	@Override
	public List<Bugs> queryAllDebugsInfoByCompanyId(int companyId) {
		return bugsDao.queryAllDebugsInfoByCompanyId(companyId);
	}

	@Override
	public List<Bugs> queryAllDebugsInfoByCompanyIdAndName(int companyId,
			String name) {
		return bugsDao.queryAllDebugsInfoByCompanyIdAndName(companyId, name);
	}

}
