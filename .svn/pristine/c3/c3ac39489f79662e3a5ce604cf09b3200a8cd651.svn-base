package com.zszd.ai.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ClassName: Leave
 * @Description: 请假条
 * @author: lizx
 * @date: 2018-1-21 上午12:22:38
 */
public class Leave {

	private int id;
	private String userName;
	private String leaveReason;
	private String approvalName;
	private Date approvalTime;
	private Date leaveTime;
	private String state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public String getApprovalTime() {
		if(approvalTime!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			return sdf.format(approvalTime);
		}
		return null;

	}

	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}

	public String getLeaveTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(leaveTime);
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
