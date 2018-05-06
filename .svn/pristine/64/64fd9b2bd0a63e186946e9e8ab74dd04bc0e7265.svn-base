package com.zszd.ai.service.oadev;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.oadev.OadevDao;
import com.zszd.ai.pojo.Oadev;
@Service
public class OadevServiceImpl implements OadevService {

	@Resource
	private OadevDao oadevDao;
	
	@Override
	public List<Oadev> queryAllOadevInfo() {
		return oadevDao.queryAllOadevInfo();
	}

}
