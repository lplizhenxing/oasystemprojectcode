package com.zszd.ai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Goods;

public interface GoodsDao {
	List<Goods> getAllGoodsInfo();
	Goods queryGoodsInfoById(@Param("goodsId")Integer goodsId);
	int updateGoodsStock(Goods goods);
	int addGoodsInfo(Goods goods);
	List<Goods> getAllGoodsInfoByDate(@Param("year")Integer year, @Param("month")Integer month);
}
