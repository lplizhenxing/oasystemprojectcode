package com.zszd.ai.dao.complaint;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Complaint;

public interface ComplaintDao {
	
	/**
	 * 增加投诉信息
	 * @Title          addComplaint
	 * @Description    TODO
	 * @Tags           @param comp
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午11:18:40
	 */
	public int addComplaint(Complaint comp);
	
	/**
	 * 查询投诉信息 用于反馈
	 * @Title          queryComplaintById
	 * @Description    TODO
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         Complaint   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午11:02:44
	 */
	public Complaint queryComplaintById(@Param("id") Integer id);

	/**
	 * 查看投诉信息
	 * @Title          queryComplaint
	 * @Description    TODO
	 * @Tags           @return   
	 * @Return         List<Complaint>   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午10:30:49
	 */
	public List<Complaint> queryComplaint();

	/**
	 * 增加反馈信息
	 * @Title          updateComplaint
	 * @Description    TODO
	 * @Tags           @param comp
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午11:02:23
	 */
	public int updateComplaint(Complaint comp);

	/**
	 * 查看员工投诉信息  针对普通员工 只能查看自己的投诉记录
	 * @Title          queryComplaintByName
	 * @Description    TODO
	 * @Tags           @param name
	 * @Tags           @return   
	 * @Return         List<Complaint>   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-21        下午11:19:19
	 */
	public List<Complaint> queryComplaintByName(@Param("name") String name);
}
