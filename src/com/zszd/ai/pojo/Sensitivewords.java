package com.zszd.ai.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 敏感词
 * @author lizx 20180103
 *
 */
public class Sensitivewords {

	private int id;
	private String content;
	private Date contentDate;
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
	public String getContentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(contentDate);
	}
	public void setContentDate(Date contentDate) {
		this.contentDate = contentDate;
	}

	
}
