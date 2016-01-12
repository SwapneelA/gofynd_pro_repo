package com.gofynd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gofynd.bean.ItemToDisplay;
import com.gofynd.bean.SizeQuantityDisplay;
import com.gofynd.bean.Stock;
import com.gofynd.idao.IItemSizeQuanDao;
import com.gofynd.idao.IStockDao;


@org.springframework.web.bind.annotation.RestController
public class RestController 
{

	@Autowired
	private IStockDao stockDao;
	@Autowired
	private IItemSizeQuanDao sizeQuantityDao;
	
	
	public void setStockDao(IStockDao stockDao) {
		this.stockDao = stockDao;
	}


	public void setSizeQuantityDao(IItemSizeQuanDao sizeQuantityDao) {
		this.sizeQuantityDao = sizeQuantityDao;
	}


	@RequestMapping(value="/getStock", method = RequestMethod.GET, produces = "application/json")
	public List<ItemToDisplay> getStock()
	{
		List<ItemToDisplay> list = stockDao.getAllItemsInStock();
		for(ItemToDisplay obj : list)
		{
			List<SizeQuantityDisplay> sizeQuantityListToDisplay = sizeQuantityDao.getItemSizes(obj.getItemName());
			obj.setList(sizeQuantityListToDisplay);
		}
		return list;
	}
}
