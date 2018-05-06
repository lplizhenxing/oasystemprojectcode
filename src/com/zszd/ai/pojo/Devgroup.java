package com.zszd.ai.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 研发组
 * @author lizx 20180103
 *
 */
public class Devgroup {

	private int id;
	private String name;
	private String watchword;
	private int departmentId;
	private String departmentName;
	private Date buildTime;
	private int state;
	private String companyName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWatchword() {
		return watchword;
	}
	public void setWatchword(String watchword) {
		this.watchword = watchword;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getBuildTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(buildTime);
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}	
}
