package com.zszd.ai.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Complaint {
	private Integer id;
	private String content;
	private String userName;
	private Date creationDate;
	private String feedback;
	private String feedbackMan;
	private Date feedbackTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getFeedbackMan() {
		return feedbackMan;
	}
	public void setFeedbackMan(String feedbackMan) {
		this.feedbackMan = feedbackMan;
	}
	public String getFeedbackTime() {
		if (feedbackTime!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			return sdf.format(feedbackTime);
		}
		return null;

	}
	public void setFeedbackTime(Date feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	public String getCreationDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(creationDate);
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
