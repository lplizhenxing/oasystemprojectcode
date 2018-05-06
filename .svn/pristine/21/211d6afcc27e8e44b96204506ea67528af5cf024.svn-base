package com.zszd.ai.dao.workpoint;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Workpoint;
/**
 * 工分DAO接口
 * @author lizx 20180103
 *
 */
public interface WorkPointDao {

	List<Workpoint> queryAllWorkPointInfo();

	List<Workpoint> queryWorkPointRecordByEmployeeId(@Param("employeeId")Integer employeeId);

	int addWorkPointRecord(Workpoint wp);

	int getWorkPointRecordCountByEmployeeId(@Param("employeeId")Integer employeeId);

	List<Workpoint> queryWorkPointRecordPageLikeEmployeeName(@Param("name")String name, @Param("currPageNum")Integer currPageNum,@Param("pageSize")Integer pageSize);

	List<Workpoint> queryWorkPointInfoByEmployeeId(@Param("employeeId")Integer employeeId);

}
