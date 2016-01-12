/**
 * 
 */
package com.gofynd.serviceimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import com.gofynd.bean.ItemMaster;
import com.gofynd.bean.ItemSizeQuantity;
import com.gofynd.bean.ItemToDisplay;
import com.gofynd.bean.ShadeMaster;
import com.gofynd.bean.SizeMaster;
import com.gofynd.bean.SizeQuantityDisplay;
import com.gofynd.bean.Stock;
import com.gofynd.idao.IItemDao;
import com.gofynd.idao.IItemSizeQuanDao;
import com.gofynd.idao.IShadeDao;
import com.gofynd.idao.ISizeDao;
import com.gofynd.idao.IStockDao;
import com.gofynd.iservice.IDatabaseService;
import com.gofynd.iservice.IReadFile;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

/**
 * @author GRO
 *
 */
public class ReadFileImpl implements IReadFile
{
	Map<String,Integer> mapOfItems = null;
	Map<String,Integer> mapOfShades = null; 
	Map<String,Integer> mapOfSize = null;
	
	@Autowired
	private IDatabaseService databaseService;
	 
	@Override
	public void readCSVFile(File f) throws IOException
	{
		initialiseMasterData();
		FileReader fileReader =  new FileReader(f);
		BufferedReader br = new BufferedReader(fileReader);
		String line = "";
		List<Integer> listOfSize =  new ArrayList<Integer>();
		int i=0;
		while((line=br.readLine())!=null)
		{
			String [] arr = line.split(",");
			if(i==0)
			{
				for(int j=2;j<arr.length-1;j++)
				{
					listOfSize.add(Integer.parseInt(arr[j]));
				}
				i++;
				continue;
			}
			
			mapCSVRowToModel(arr,listOfSize);
		}
		br.close();
	}
	
	private void mapCSVRowToModel(String [] arr,List<Integer> listOfSize) throws IOException
	{
		String itemName =  arr[0];
		String shadeName = arr[1];
		int stockId = 0;
		String mrp=arr[arr.length-1];
		List<ItemSizeQuantity> listOfItemSizes = new ArrayList<ItemSizeQuantity>();
		int k=0;
		Stock stock = new Stock(mapOfItems.get(itemName),mapOfShades.get(shadeName),Double.parseDouble(mrp));
		stockId = databaseService.saveStock(stock);
		
		for(int i=2;i<arr.length-1;i++)
		{
			ItemSizeQuantity itemSizeWiseQuantity = null;
			try
			{
				itemSizeWiseQuantity = new ItemSizeQuantity(stockId,mapOfSize.get(listOfSize.get(k).toString()),Integer.parseInt(arr[i]));
				
			}
			catch(NumberFormatException ex)
			{
				itemSizeWiseQuantity = new ItemSizeQuantity(stockId,mapOfSize.get(listOfSize.get(k).toString()),0);
			}
			listOfItemSizes.add(itemSizeWiseQuantity);
			k++;
		}
		databaseService.saveItemSizes(listOfItemSizes);
	}
	
	private void initialiseMasterData()
	{
		mapOfItems = databaseService.getMapOfItemMaster();
		mapOfShades = databaseService.getMapOfShadeMaster();
		mapOfSize = databaseService.getMapOfSize();
	}
	
}
