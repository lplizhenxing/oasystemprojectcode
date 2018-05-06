package com.zszd.ai.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ClassName Resource
 * @Description 资源表 包括视频 图片 文件等
 * @author lizx
 * @date 2018-1-27 上午9:57:04
 */
public class Resources {

	private int id;
	private int type; // 0-图片 1-视频 2-文件
	private String name;
	private String path;
	private Date createTime;
	private String createBy;
	private Date reviewTime;
	private String reviewBy;
	private int state; // 0-待审核，1-审核通过，2-驳回请求
	private String stateName; // 0-待审核，1-审核通过，2-驳回请求
	private String showType; 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCreateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(createTime);
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getReviewTime() {
		if(reviewTime!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			return sdf.format(reviewTime);
		}
		return null;

	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}

	public String getReviewBy() {
		return reviewBy;
	}

	public void setReviewBy(String reviewBy) {
		this.reviewBy = reviewBy;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateName() {
		switch (state) {
		case 0:
			return "待审核";
		case 1:
			return "审核通过";
		case 2:
			return "驳回请求";
		}
		return null;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}
}
