package com.zszd.ai.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Draw {
	private String loginName;
	private Date drawTime;
	private int workpoint;
	private String prizeName;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getDrawTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(drawTime);
	}
	public void setDrawTime(Date drawTime) {
		this.drawTime = drawTime;
	}
	public int getWorkpoint() {
		return workpoint;
	}
	public void setWorkpoint(int workpoint) {
		this.workpoint = workpoint;
	}
	public String getPrizeName() {
		return prizeName;
	}
	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}
	public Draw(String loginName, Date drawTime, int workpoint, String prizeName) {
		super();
		this.loginName = loginName;
		this.drawTime = drawTime;
		this.workpoint = workpoint;
		this.prizeName = prizeName;
	}
	public Draw() {
		super();
	}
	
}
