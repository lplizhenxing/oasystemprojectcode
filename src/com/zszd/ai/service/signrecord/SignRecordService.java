package com.zszd.ai.service.signrecord;

import java.util.List;

import com.zszd.ai.pojo.SignRecord;
/**
 * 
 * @ClassName       SignRecordService
 * @Description    签到记录模块
 * @author            lizx
 * @date           2018-1-21        下午7:24:29
 */
public interface SignRecordService {
    /**
     * 
     * @Title          queryAllSignRecordInfoByName
     * @Description    根据用户名称查询用户所有的签到记录
     * @Tags           @param name
     * @Tags           @return   
     * @Return         List<SignRecord>   
     * @throws
     * @author           lizx
     * @date           2018-1-21        下午7:25:24
     */
	List<SignRecord> queryAllSignRecordInfoByName(String name);
    /**
     * 
     * @Title          queryAllSignRecordInfoByNameAndSignDate
     * @Description    查看用户是否已经签到
     * @Tags           @param name
     * @Tags           @param signDate
     * @Tags           @return   
     * @Return         List<SignRecord>   
     * @throws
     * @author           lizx
     * @date           2018-1-21        下午8:23:50
     */
	List<SignRecord> queryAllSignRecordInfoByNameAndSignDate(String name,
			String signDate);
   
	/**
	 * 
	 * @Title          queryAllSignRecordInfoByNameAndSignOutDate
	 * @Description    查看用户是否已经签退
	 * @Tags           @param name
	 * @Tags           @param signOutDate
	 * @Tags           @return   
	 * @Return         List<SignRecord>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        下午8:24:06
	 */
	List<SignRecord> queryAllSignRecordInfoByNameAndSignOutDate(String name,
			String signOutDate);
	/**
	 * 
	 * @Title          updateSignRecordInfoByNameAndSignDate
	 * @Description    更新签到时间
	 * @Tags           @param name
	 * @Tags           @param signDate
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        下午8:33:18
	 */
	int updateSignRecordInfoByNameAndSignDate(String name, String signDate);
	/**
	 * 
	 * @Title          updateSignRecordInfoByNameAndSignOutDate
	 * @Description    更新签退时间
	 * @Tags           @param name
	 * @Tags           @param signOutDate
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        下午8:33:29
	 */
	int updateSignRecordInfoByNameAndSignOutDate(String name, String signOutDate);
	/**
	 * 
	 * @Title          insertSignRecordInfoByNameAndSignOutDate
	 * @Description    如果没有签到签退记录，添加一条签退记录
	 * @Tags           @param name
	 * @Tags           @param signOutDate
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        下午8:58:30
	 */
	int insertSignRecordInfoByNameAndSignOutDate(String name, String signOutDate);
	/**
	 * 
	 * @Title          insertSignRecordInfoByNameAndSignDate
	 * @Description    如果没有签到签退记录，添加一条签到记录
	 * @Tags           @param name
	 * @Tags           @param signDate
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        下午8:58:56
	 */
	int insertSignRecordInfoByNameAndSignDate(String name, String signDate);
	/**
	 * 
	 * @Title          queryAllSignRecordInfo
	 * @Description    签到记录
	 * @Tags           @return   
	 * @Return         List<SignRecord>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-31        下午12:11:41
	 */
	List<SignRecord> queryAllSignRecordInfo();
	/**
	 * 
	 * @Title          queryAllSignRecordInfoByCompanyId
	 * @Description    本公司的签到记录
	 * @Tags           @param companyId
	 * @Tags           @return   
	 * @Return         List<SignRecord>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-31        下午12:11:52
	 */
	List<SignRecord> queryAllSignRecordInfoByCompanyId(int companyId);
	/**
	 * 
	 * @Title          queryAllSignRecordInfoByCompanyIdAndName
	 * @Description    本公司自己的签到记录
	 * @Tags           @param companyId
	 * @Tags           @param name
	 * @Tags           @return   
	 * @Return         List<SignRecord>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-31        下午12:12:02
	 */
	List<SignRecord> queryAllSignRecordInfoByCompanyIdAndName(int companyId,
			String name);

}
