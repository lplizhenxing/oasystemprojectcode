package com.zszd.ai.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Schedule {

	private int id;
	private String content;
	private String createName;
	private Date createDate;
	private String finishName;
	private Date finishDate;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getCreateDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(createDate);
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getFinishName() {
		return finishName;
	}
	public void setFinishName(String finishName) {
		this.finishName = finishName;
	}
	public String getFinishDate() {
		if(finishDate!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			return sdf.format(finishDate);
		}
		return null;
		
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
