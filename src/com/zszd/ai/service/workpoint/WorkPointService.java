package com.zszd.ai.service.workpoint;

import java.util.List;

import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.Page;
import com.zszd.ai.pojo.Workpoint;
/**
 * 
 * @ClassName       WorkPointService
 * @Description    工分接口
 * @author            lizx
 * @date           2018-1-21        上午11:47:37
 */
public interface WorkPointService {
    /**
     * 
     * @Title          queryAllWorkPointInfo
     * @Description    查询所有的工分记录
     * @Tags           @return   
     * @Return         List<Workpoint>   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:47:44
     */
	List<Workpoint> queryAllWorkPointInfo();
	/**
	 * 
	 * @Title          queryWorkPointInfoByEmployeeId
	 * @Description    根据员工ID查询工分记录信息
	 * @Tags           @param employeeId
	 * @Tags           @return   
	 * @Return         List<Workpoint>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:47:50
	 */
	List<Workpoint> queryWorkPointInfoByEmployeeId(int employeeId);
    /**
     * 
     * @Title          addWorkPointRecord
     * @Description    添加工分记录信息
     * @Tags           @param employee
     * @Tags           @param wp
     * @Tags           @return   
     * @Return         boolean   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:47:57
     */
	boolean addWorkPointRecord(Employee employee, Workpoint wp);

	/**
	 * 
	 * @Title          queryWorkPointInfoLikeName
	 * @Description    根据名称模糊查询工分信息
	 * @Tags           @param name
	 * @Tags           @return   
	 * @Return         List<Workpoint>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:48:04
	 */
	List<Workpoint> queryWorkPointInfoLikeName(String name);
   /**
    * 
    * @Title          getWorkPointInfoCountLikeName
    * @Description    根据名称模糊查询工分记录数量
    * @Tags           @param name
    * @Tags           @return   
    * @Return         int   
    * @throws
    * @author           lizx
    * @date           2018-1-21        上午11:48:12
    */
	int getWorkPointInfoCountLikeName(String name);
	/**
	 * 
	 * @Title          queryWorkPointInfoLikeNamePage
	 * @Description    根据分页和名称模糊查看工分记录信息
	 * @Tags           @param page
	 * @Tags           @param name
	 * @Tags           @return   
	 * @Return         List<Workpoint>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:48:22
	 */
	List<Workpoint> queryWorkPointInfoLikeNamePage(Page page,String name);
}
