package com.zszd.ai.service.resource;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.resource.ResourceDao;
import com.zszd.ai.pojo.Resources;
@Service
public class ResourceServiceImpl implements ResourceService {

	@Resource
	private ResourceDao resourceDao;
	
	@Override
	public List<Resources> queryPassedResourceInfoByType(int type) {
		return resourceDao.queryPassedResourceInfoByType(type);
	}

	@Override
	public List<Resources> queryAllResourceInfoByType(int type) {
		return resourceDao.queryAllResourceInfoByType(type);
	}

	@Override
	public int insertResourceRecord(Resources resource) {
		return resourceDao.insertResourceRecord(resource);
	}

	@Override
	public Resources getResourceById(String id) {
		return resourceDao.getResourceById(id);
	}

	@Override
	public int updateResourceInfo(Resources resource) {
		return resourceDao.updateResourceInfo(resource);
	}

}
