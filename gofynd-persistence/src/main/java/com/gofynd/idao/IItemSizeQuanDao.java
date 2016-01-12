package com.gofynd.idao;

import java.util.List;

import com.gofynd.bean.ItemSizeQuantity;
import com.gofynd.bean.SizeQuantityDisplay;

public interface IItemSizeQuanDao {

	void saveItemSizes(List<ItemSizeQuantity> sizes);
	


	List<SizeQuantityDisplay> getItemSizes(String itemName);

}
