package com.gofynd.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gofynd.bean.ItemMaster;
import com.gofynd.bean.ShadeMaster;
import com.gofynd.idao.IShadeDao;



public class ShadeDaoimpl extends AbstractDaoImpl implements IShadeDao 
{	
	@Override
	public List<ShadeMaster> findAll()
	{
		return findAll(ShadeMaster.class);
	}
}
