package com.zszd.ai.service.leave;

import java.util.List;

import com.zszd.ai.pojo.Leave;
/**
 * 
 * @ClassName       LeaveService
 * @Description    员工请假模块
 * @author            lizx
 * @date           2018-1-21        上午11:41:15
 */
public interface LeaveService {
    /**
     * 
     * @Title          addLeaveInfo
     * @Description    新增请假记录
     * @Tags           @param leave
     * @Tags           @return   
     * @Return         int   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:41:22
     */
	int addLeaveInfo(Leave leave);
    /**
     * 
     * @Title          queryAllLeaveInfo
     * @Description    查询所有的请假信息
     * @Tags           @return   
     * @Return         List<Leave>   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:41:32
     */
	List<Leave> queryAllLeaveInfo();
    /**
     * 
     * @Title          queryAllLeaveInfoByName
     * @Description    查询员工的请假信息
     * @Tags           @param name
     * @Tags           @return   
     * @Return         List<Leave>   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:41:40
     */
	List<Leave> queryAllLeaveInfoByName(String name);
	List<Leave> queryAllLeaveInfoByCompanyId(int companyId);
	List<Leave> queryAllLeaveInfoByCompanyIdAndName(int companyId, String name);
	int oprLeaveInfo(Leave leave);

}
