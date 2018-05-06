package com.zszd.ai.dao.signrecord;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.SignRecord;

public interface SignRecordDao {

	List<SignRecord> queryAllSignRecordInfoByName(@Param("userName")String name);

	List<SignRecord> queryAllSignRecordInfoByNameAndSignDate(@Param("userName")String name,
			@Param("signDate")String signDate);

	List<SignRecord> queryAllSignRecordInfoByNameAndSignOutDate(@Param("userName")String name,
			@Param("signOutDate")String signOutDate);

	int updateSignRecordInfoByNameAndSignDate(@Param("userName")String name,
			@Param("signTime")String signDate);

	int updateSignRecordInfoByNameAndSignOutDate(@Param("userName")String name,
			@Param("signOutTime")String signOutDate);

	int insertSignRecordInfoByNameAndSignOutDate(@Param("userName")String name,
			@Param("signOutTime")String signOutDate);

	int insertSignRecordInfoByNameAndSignDate(@Param("userName")String name,
			@Param("signTime")String signDate);

	List<SignRecord> queryAllSignRecordInfo();

	List<SignRecord> queryAllSignRecordInfoByCompanyId(@Param("companyId")Integer companyId);

	List<SignRecord> queryAllSignRecordInfoByCompanyIdAndName(@Param("companyId")Integer companyId,
			@Param("userName")String name);

}
