package com.gofynd.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gofynd.bean.ItemMaster;
import com.gofynd.bean.SizeMaster;
import com.gofynd.idao.ISizeDao;

public class SizeDaoImpl extends AbstractDaoImpl implements ISizeDao
{
	@Override
	public List<SizeMaster> findAll()
	{
		return findAll(SizeMaster.class);
	}
}
