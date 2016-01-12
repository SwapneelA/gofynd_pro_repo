/**
 * 
 */
package com.gofynd.iservice;

import java.util.List;
import java.util.Map;

import com.gofynd.bean.ItemSizeQuantity;
import com.gofynd.bean.Stock;

/**
 * @author GRO
 *
 */
public interface IDatabaseService {
	 Map<String,Integer> getMapOfItemMaster();
	 Map<String,Integer> getMapOfShadeMaster();
	 Map<String,Integer> getMapOfSize();
	 int saveStock(Stock stock);
	 void saveItemSizes(List<ItemSizeQuantity> list);
	 int getStockId(int itemId);
}
