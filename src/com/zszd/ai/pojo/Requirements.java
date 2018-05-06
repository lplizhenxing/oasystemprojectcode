package com.zszd.ai.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Requirements {

	private int id;
	private String userName;
	private String title;
	private String content;
	private int projectId;
	private Date submitTime;
	private Date resolveTime;
	private String resolveDevName;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getSubmitTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(submitTime);
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public String getResolveTime() {
		if(resolveTime!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			return sdf.format(resolveTime);
		}
		return null;
	}

	public void setResolveTime(Date resolveTime) {
		this.resolveTime = resolveTime;
	}

	public String getResolveDevName() {
		return resolveDevName;
	}

	public void setResolveDevName(String resolveDevName) {
		this.resolveDevName = resolveDevName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
