package com.zszd.ai.service;

import java.util.List;

import com.zszd.ai.pojo.Goods;
/**
 * 
 * @ClassName       GoodsService
 * @Description    员工福利工时商城模块
 * @author            lizx
 * @date           2018-1-21        上午11:40:48
 */
public interface GoodsService {
	/**
	 * 
	 * @Title          getAllGoodsInfo
	 * @Description    获取所有的商品信息
	 * @Tags           @return   
	 * @Return         List<Goods>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:40:55
	 */
	List<Goods>  getAllGoodsInfo();
	
	/**
	 * 
	 * @Title          queryGoodsInfoById
	 * @Description    根据商品ID获取商品信息
	 * @Tags           @param goodsId
	 * @Tags           @return   
	 * @Return         Goods   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:41:02
	 */
	Goods queryGoodsInfoById(int goodsId);
	
	/**
	 * 
	 * @Title          updateGoodsStock
	 * @Description    更新商品库存
	 * @Tags           @param goods
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:41:08
	 */
	int updateGoodsStock(Goods goods);
    /**
     * 
     * @Title          addGoodsInfo
     * @Description    添加商品信息
     * @Tags           @param goods
     * @Tags           @return   
     * @Return         int   
     * @throws
     * @author           lizx
     * @date           2018-1-31        下午3:34:27
     */
	int addGoodsInfo(Goods goods);

	List<Goods> getAllGoodsInfoByDate(int year, int month);
}
