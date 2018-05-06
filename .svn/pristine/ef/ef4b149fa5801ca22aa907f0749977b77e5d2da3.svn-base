package com.zszd.ai.service.requirements;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.requirements.RequirementsDao;
import com.zszd.ai.pojo.Requirements;

@Service
public class RequirementsServiceImpl implements RequirementsService {

	@Resource
	private RequirementsDao requirementsDao;
	
	@Override
	public List<Requirements> queryAllRequirementInfo() {
		return requirementsDao.queryAllRequirementInfo();
	}

	@Override
	public int addRequirementsInfo(Requirements requirements) {
		return requirementsDao.addRequirementsInfo(requirements);

	}

	@Override
	public Requirements getRequirementsById(int id) {
		return requirementsDao.getRequirementsById(id);
	}

	@Override
	public int updateRequirementsInfo(Requirements requirements) {
		return requirementsDao.updateRequirementsInfo(requirements);
	}

	@Override
	public List<Requirements> queryAllRequirementInfoByCompanyId(int companyId) {
		return requirementsDao.queryAllRequirementInfoByCompanyId(companyId);
	}

	@Override
	public List<Requirements> queryAllRequirementInfoByCompanyIdAndName(
			int companyId, String name) {
		return requirementsDao.queryAllRequirementInfoByCompanyIdAndName(companyId, name);
	}

}
