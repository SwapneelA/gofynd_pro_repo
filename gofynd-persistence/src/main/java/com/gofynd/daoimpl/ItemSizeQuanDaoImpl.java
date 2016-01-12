package com.gofynd.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;

import com.gofynd.bean.ItemSizeQuantity;
import com.gofynd.bean.ItemToDisplay;
import com.gofynd.bean.SizeQuantityDisplay;
import com.gofynd.idao.IItemSizeQuanDao;

public class ItemSizeQuanDaoImpl implements IItemSizeQuanDao 
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveItemSizes(List<ItemSizeQuantity> sizes)
	{
		
		int i=0;
		Session session = sessionFactory.openSession();
		for(ItemSizeQuantity stock : sizes)
		{
			Query query = session.createSQLQuery("select id,quantity from ItemSizeWiseQuantity where stockId = "+stock.getStockId()+" and sizeId="+stock.getSizeId());
			List list = query.list();
			if(null!=list && list.size() > 0)
			{
				Object[] obj = (Object[]) list.get(0);
				stock.setId((Integer)(obj[0]));
				stock.setQuantity(stock.getQuantity()+(Integer)(obj[1]));
				session.update(stock);
			}
			else
			{
				session.save(stock);
			}
			i++;
			if(i%5==0)
			{
				session.flush();
				session.clear();
				
			}
		}
		session.flush();
		session.clear();
		session.close();
	}
	
	@Override
	public List<SizeQuantityDisplay> getItemSizes(String itemName) 
	{
		String queryString = "Select sm.itemSize as sizeName ,swq.quantity from SizeMaster sm"
				+ " join ItemSizeWiseQuantity swq on sm.sizeId=swq.sizeId join Stock tm on swq.stockId"
				+ "=tm.stockId join ItemMaster im on tm.itemId = im.itemId where im.itemName='"+itemName+"'";
		Session session = sessionFactory.openSession();
		Query query =  session.createSQLQuery(queryString).addScalar("sizeName", new StringType()).addScalar("quantity", new IntegerType()).setResultTransformer(Transformers.aliasToBean(SizeQuantityDisplay.class));
		List<SizeQuantityDisplay> list = query.list();
		session.flush();
		session.clear();
		session.close();
		return list;
	}
	
	
}
