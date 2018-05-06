package com.zszd.ai.service.complaint;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.complaint.ComplaintDao;
import com.zszd.ai.pojo.Complaint;
@Service
public class ComplaintServiceImpl implements ComplaintService {

	@Resource
	private ComplaintDao complaintDao ;
	
	/**
	 * 查看员工投诉信息  只对经理查看
	 * <p>Title queryComplaint</p>
	 * <p>Description </p>
	 * @return
	 * @see com.zszd.ai.service.complaint.ComplaintService#queryComplaint()
	 */
	@Override
	public List<Complaint> queryComplaint() {
		return complaintDao.queryComplaint();
	}
	
	/**
	 * 查看员工投诉信息  针对普通员工 只能查看自己的投诉记录
	 * <p>Title queryComplaintByName</p>
	 * <p>Description </p>
	 * @return
	 * @see com.zszd.ai.service.complaint.ComplaintService#queryComplaintByName()
	 */
	@Override
	public List<Complaint> queryComplaintByName(String name) {
		return complaintDao.queryComplaintByName(name);
	}
	
	/**
	 * 修改反馈信息
	 * @Title          updateComplaint
	 * @Description    TODO
	 * @Tags           @param comp
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午11:01:09
	 */
	public int updateComplaint(Complaint comp) {
		return complaintDao.updateComplaint(comp);
	}


	/**
	 * 查询投诉信息 用于反馈
	 * <p>Title queryComplaintById</p>
	 * <p>Description </p>
	 * @param id
	 * @return
	 * @see com.zszd.ai.service.complaint.ComplaintService#queryComplaintById(java.lang.Integer)
	 */
	@Override
	public Complaint queryComplaintById(Integer id) {
		return complaintDao.queryComplaintById(id);
	}
	
	/**
	 * 添加投诉信息
	 * <p>Title addComplaint</p>
	 * <p>Description </p>
	 * @param comp
	 * @return
	 * @see com.zszd.ai.service.complaint.ComplaintService#addComplaint(com.zszd.ai.pojo.Complaint)
	 */
	@Override
	public int addComplaint(Complaint comp) {
		return complaintDao.addComplaint(comp);
	}

}
