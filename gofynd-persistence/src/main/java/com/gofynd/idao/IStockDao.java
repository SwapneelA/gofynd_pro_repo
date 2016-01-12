package com.gofynd.idao;

import java.util.List;
import java.util.Map;

import com.gofynd.bean.ItemSizeQuantity;
import com.gofynd.bean.ItemToDisplay;
import com.gofynd.bean.Stock;

public interface IStockDao {
	
	int save(Stock stock);
	
	List<ItemToDisplay> getAllItemsInStock();
	
	List<Integer> getAllStockIds();
	int getStockId(int itemId);
}
