package com.zszd.ai.service.complaint;

import java.util.List;

import com.zszd.ai.pojo.Complaint;

public interface ComplaintService {
	/**
	 * 添加投诉信息
	 * @Title          addComplaint
	 * @Description    TODO
	 * @Tags           @param comp
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午11:05:15
	 */
	public int addComplaint(Complaint comp);
		
	/**
	 * 查询所有投诉信息
	 * @Title          queryComplaint
	 * @Description    TODO
	 * @Tags           @return   
	 * @Return         List<Complaint>   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午11:05:03
	 */
	public List<Complaint> queryComplaint();
	
	/**
	 * 查询投诉信息 用于反馈
	 * @Title          queryComplaintById
	 * @Description    TODO
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         Complaint   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午11:04:49
	 */
	public Complaint queryComplaintById(Integer id);
	
	/**
	 * 添加反馈信息
	 * @Title          updateComplaint
	 * @Description    TODO
	 * @Tags           @param comp
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午11:04:36
	 */
	public int updateComplaint(Complaint comp) ;

	public List<Complaint> queryComplaintByName(String name);
}
