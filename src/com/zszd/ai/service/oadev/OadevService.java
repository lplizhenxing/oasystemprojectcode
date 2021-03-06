package com.zszd.ai.service.oadev;

import java.util.List;

import com.zszd.ai.pojo.Oadev;
/**
 * 
 * @ClassName       OadevService
 * @Description    系统开发人员信息
 * @author            lizx
 * @date           2018-1-24        下午4:41:29
 */
public interface OadevService {
	/**
	 * 
	 * @Title          queryAllOadevInfo
	 * @Description    显示所有的开发人员信息
	 * @Tags           @return   
	 * @Return         List<Oadev>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-24        下午4:41:47
	 */
	public List<Oadev> queryAllOadevInfo();

}
