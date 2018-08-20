package com.palmble.sp.manger.service;


import com.palmble.sp.manger.model.ZsGoodsSkuAttr;
import com.palmble.sp.manger.utils.ResponsDatas;

/**
 * 商品规格
 * @author malingbing
 *
 */
public interface GoodsSkuService {

	/**
	 * 
	 * @param page
	 * @param rows
	 * @param sord
	 * @param goodsCateId
	 * @param skuId
	 * @return
	 */
	ResponsDatas<?> getGoodsSkuList(Integer page, Integer rows, String sord, Integer goodsCateId, Integer skuId);

	/**
	 * 添加 编辑
	 * @param goodsSku
	 * @return
	 */
	ResponsDatas<?> operGoodsSku(ZsGoodsSkuAttr goodsSku);

	ResponsDatas<?> getGoodsSkuId(Integer id);

	/**
	 * 获取sku 值
	 * @return
	 */
	ResponsDatas<?> getGoodsSkuList(Integer[] skuvalueIds,Integer[] skuIds);

}
