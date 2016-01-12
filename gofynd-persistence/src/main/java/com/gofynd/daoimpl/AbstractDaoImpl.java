package com.gofynd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractDaoImpl
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List findAll(Class clazz)
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(clazz);
		List list = criteria.list();
		session.clear();
		session.close();
		return list;
	}
}
