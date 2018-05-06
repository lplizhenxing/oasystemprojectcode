package com.zszd.ai.dao.resource;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Resources;

public interface ResourceDao {

	public List<Resources> queryPassedResourceInfoByType(@Param("type")Integer type);

	public List<Resources> queryAllResourceInfoByType(@Param("type")Integer type);

	public int insertResourceRecord(Resources resource);

	public Resources getResourceById(@Param("id")String id);

	public int updateResourceInfo(Resources resource);
}
