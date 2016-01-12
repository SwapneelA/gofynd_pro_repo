package com.gofynd.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;

import com.gofynd.bean.ItemToDisplay;
import com.gofynd.bean.Stock;
import com.gofynd.idao.IStockDao;

public class StockDaoImpl implements IStockDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int save(Stock stock) 
	{
		int identifier = 0;
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select stockId from Stock where itemId="+stock.getItemId());
		List list = query.list();
		if(null!=list && list.size() > 0)
		{
			identifier = (Integer) list.get(0);
			stock.setStockId(identifier);
			session.update(stock);
		}
		else
		{
			identifier =  (Integer) session.save(stock);
		}
		session.flush();
		session.clear();
		session.close();
		return identifier;
		
	}
	
	@Override
	public List<ItemToDisplay> getAllItemsInStock() 
	{
		String queryString = "Select i.itemName,s.shadeName,st.mrp from "
				+ " ItemMaster i join Stock st on i.itemId=st.itemId join"
				+ " ShadeMaster s on st.shadeId=s.shadeId";
		Session session = sessionFactory.openSession();
		Query query =  session.createSQLQuery(queryString).addScalar("itemName", new StringType()).addScalar("shadeName", new StringType()).addScalar("mrp", new DoubleType()).setResultTransformer(Transformers.aliasToBean(ItemToDisplay.class));
		List<ItemToDisplay> itemsToDisplay = query.list();
		session.clear();
		session.close();
		return itemsToDisplay;
	}

	@Override
	public List<Integer> getAllStockIds() {
		String queryString="select stockId from Stock";
		Session session =sessionFactory.openSession();
		Query query = session.createSQLQuery(queryString);
		List<Integer> list = query.list();
		return list;
	}

	@Override
	public int getStockId(int itemId) 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select stockId from Stock where itemId="+itemId);
		int stockId = (Integer) query.list().get(0);
		session.flush();
		session.clear();
		session.close();
		return stockId;
	}
	
	

}
