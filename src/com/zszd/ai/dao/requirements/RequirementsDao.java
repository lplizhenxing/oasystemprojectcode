package com.zszd.ai.dao.requirements;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Requirements;

public interface RequirementsDao {

	List<Requirements> queryAllRequirementInfo();

	int addRequirementsInfo(Requirements requirements);

	Requirements getRequirementsById(@Param("id")Integer id);

	int updateRequirementsInfo(Requirements requirements);

	List<Requirements> queryAllRequirementInfoByCompanyId(@Param("companyId")Integer companyId);

	List<Requirements> queryAllRequirementInfoByCompanyIdAndName(@Param("companyId")Integer companyId,
			@Param("name")String name);

}
