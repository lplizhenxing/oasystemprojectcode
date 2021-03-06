package com.zszd.ai.service;

import java.util.List;

import com.zszd.ai.pojo.Draw;
/**
 * 
 * @ClassName       DrawService
 * @Description    员工福利模块工时抽奖接口
 * @author            lizx
 * @date           2018-1-21        上午11:38:00
 */
public interface DrawService {
	/**
	 * 
	 * @Title          addDrawRecord
	 * @Description    添加抽奖记录
	 * @Tags           @param draw
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:38:07
	 */
	int addDrawRecord(Draw draw);
	/**
	 * 
	 * @Title          findDrawByName
	 * @Description     根据用户名称找到抽奖记录
	 * @Tags           @param name
	 * @Tags           @return   
	 * @Return         List<Draw>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:38:15
	 */
	List<Draw> findDrawByName(String name);
	/**
	 * 
	 * @Title          findAllDraw
	 * @Description    查询所有的抽奖记录
	 * @Tags           @return   
	 * @Return         List<Draw>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:38:21
	 */
	List<Draw> findAllDraw();
}
