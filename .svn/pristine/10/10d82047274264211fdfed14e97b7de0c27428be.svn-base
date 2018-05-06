package com.zszd.ai.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.zszd.ai.dao.GoodsDao;
import com.zszd.ai.dao.WpChangeDao;
import com.zszd.ai.dao.workpoint.WorkPointDao;
import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.Goods;
import com.zszd.ai.pojo.Workpoint;
import com.zszd.ai.service.WpChangeService;
import com.zszd.ai.tools.MyBatisUtil;

public class WpChangeServiceImpl implements WpChangeService {
	@Override
	public boolean updateWorkPoint(Employee employee, Goods goods) {
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			int row1 = sqlSession.getMapper(WpChangeDao.class).updateWorkPoint(
					employee);
			int row2 = sqlSession.getMapper(GoodsDao.class).updateGoodsStock(
					goods);
			Workpoint wp = new Workpoint();
			wp.setEmployeeId(employee.getId());
			wp.setRemarks("兑换" + goods.getGoodsName() + ",消耗工分："
					+ goods.getGoodsPrice());
			wp.setWorkpoint(-goods.getGoodsPrice());
			int row3 = sqlSession.getMapper(WorkPointDao.class).addWorkPointRecord(wp);
			//如何进行事务控制
			flag = true;
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;	 
	}
}
