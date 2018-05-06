package com.zszd.ai.service.signrecord;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.signrecord.SignRecordDao;
import com.zszd.ai.pojo.SignRecord;
@Service
public class SignRecordServiceImpl implements SignRecordService {

	@Resource
	private SignRecordDao signRecordDao;

	@Override
	public List<SignRecord> queryAllSignRecordInfoByName(String name) {
		return signRecordDao.queryAllSignRecordInfoByName(name);
	}

	@Override
	public List<SignRecord> queryAllSignRecordInfoByNameAndSignDate(
			String name, String signDate) {
		return signRecordDao.queryAllSignRecordInfoByNameAndSignDate(name, signDate);
	}

	@Override
	public List<SignRecord> queryAllSignRecordInfoByNameAndSignOutDate(
			String name, String signOutDate) {
		return signRecordDao.queryAllSignRecordInfoByNameAndSignOutDate(name, signOutDate);
	}

	@Override
	public int updateSignRecordInfoByNameAndSignDate(String name,
			String signDate) {
		return signRecordDao.updateSignRecordInfoByNameAndSignDate(name, signDate);
	}

	@Override
	public int updateSignRecordInfoByNameAndSignOutDate(String name,
			String signOutDate) {
		return signRecordDao.updateSignRecordInfoByNameAndSignOutDate(name, signOutDate);
	}

	@Override
	public int insertSignRecordInfoByNameAndSignOutDate(String name,
			String signOutDate) {
		return signRecordDao.insertSignRecordInfoByNameAndSignOutDate(name, signOutDate);
	}

	@Override
	public int insertSignRecordInfoByNameAndSignDate(String name,
			String signDate) {
		return signRecordDao.insertSignRecordInfoByNameAndSignDate(name, signDate);
	}

	@Override
	public List<SignRecord> queryAllSignRecordInfo() {
		return signRecordDao.queryAllSignRecordInfo();
	}

	@Override
	public List<SignRecord> queryAllSignRecordInfoByCompanyId(int companyId) {
		return signRecordDao.queryAllSignRecordInfoByCompanyId(companyId);
	}

	@Override
	public List<SignRecord> queryAllSignRecordInfoByCompanyIdAndName(
			int companyId, String name) {
		return signRecordDao.queryAllSignRecordInfoByCompanyIdAndName(companyId, name);
	}

}
