package com.zszd.ai.service;

import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.Goods;
/**
 * 
 * @ClassName       WpChangeService
 * @Description    工时兑换接口
 * @author            lizx
 * @date           2018-1-21        上午11:48:29
 */
public interface WpChangeService {
	/**
	 * 
	 * @Title          updateWorkPoint
	 * @Description    更新工分记录信息
	 * @Tags           @param employee
	 * @Tags           @param goods
	 * @Tags           @return   
	 * @Return         boolean   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:48:36
	 */
	boolean updateWorkPoint(Employee employee,Goods goods);
}
