package com.gofynd.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gofynd.bean.ItemMaster;
import com.gofynd.idao.IItemDao;

public class ItemDaoImpl extends AbstractDaoImpl implements IItemDao
{
	@Override
	public List<ItemMaster> findAll()
	{
		return findAll(ItemMaster.class);
	}
}
