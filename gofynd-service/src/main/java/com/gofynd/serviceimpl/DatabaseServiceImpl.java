package com.gofynd.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.gofynd.bean.ItemMaster;
import com.gofynd.bean.ItemSizeQuantity;
import com.gofynd.bean.ShadeMaster;
import com.gofynd.bean.SizeMaster;
import com.gofynd.bean.Stock;
import com.gofynd.idao.IItemDao;
import com.gofynd.idao.IItemSizeQuanDao;
import com.gofynd.idao.IShadeDao;
import com.gofynd.idao.ISizeDao;
import com.gofynd.idao.IStockDao;
import com.gofynd.iservice.IDatabaseService;


public class DatabaseServiceImpl implements IDatabaseService
{
	@Autowired
	private IItemDao itemDao;
	@Autowired
	private IShadeDao shadeDao;
	@Autowired
	private ISizeDao sizeDao;
	@Autowired
	private IStockDao stockDao;
	@Autowired
	private IItemSizeQuanDao sizeQuantityDao;
	
	public Map<String,Integer> getMapOfItemMaster()
	{
		List<ItemMaster> items = itemDao.findAll();
		Map<String,Integer> mapOfItems =  new HashMap<String,Integer>();
		for(ItemMaster item : items)
		{
			mapOfItems.put(item.getItemName(), item.getItemId());
		}
		return mapOfItems;
		
	}
	
	public Map<String,Integer> getMapOfShadeMaster()
	{
		List<ShadeMaster> shades = shadeDao.findAll();
		Map<String,Integer> mapOfShades =  new HashMap<String,Integer>();
		for(ShadeMaster shade : shades)
		{
			mapOfShades.put(shade.getShadeName(), shade.getShadeId());
		}
		return mapOfShades;
	}
	
	public Map<String,Integer> getMapOfSize()
	{
		List<SizeMaster> sizeList = sizeDao.findAll();
		Map<String,Integer> mapOfSize=  new HashMap<String,Integer>();
		for(SizeMaster sizeRecord : sizeList)
		{
			mapOfSize.put(sizeRecord.getItemSize(),	sizeRecord.getSizeId());
		}
		return mapOfSize;
	}

	@Override
	public int saveStock(Stock stock)
	{	
		return stockDao.save(stock);
	}

	@Override
	public void saveItemSizes(List<ItemSizeQuantity> sizes) {
		sizeQuantityDao.saveItemSizes(sizes);
		
	}

	@Override
	public int getStockId(int itemId) 
	{
		return stockDao.getStockId(itemId);
	}
	
	
	
	
}
