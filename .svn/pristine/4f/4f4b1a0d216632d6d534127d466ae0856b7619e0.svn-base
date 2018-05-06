package com.zszd.ai.pojo;
/**
 * 分页
 * @author lizx 20180103
 *
 */
public class Page {

	private int pageSize; // 每页显示的数量
	private int totalCount; // 总记录数
	private int totalPageNum; // 总页数
	private int currentPageNum; // 当前页数
	private int startIndex;// 开始下标

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		// 设置总记录数 确定总页数
		this.totalCount = totalCount;
		this.totalPageNum = (totalCount % this.pageSize) == 0 ? (totalCount / this.pageSize)
				: (totalCount / this.pageSize) + 1;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		if (currentPageNum < 0) {
			this.currentPageNum = 1;
		} else {
			this.currentPageNum = currentPageNum;
		}
		// 设置访问的开始下标 =（当前页-1）*size;
		this.startIndex = (this.currentPageNum - 1) * this.pageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

}
