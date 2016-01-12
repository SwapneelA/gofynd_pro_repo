package com.gofynd.idao;

import java.util.List;

import com.gofynd.bean.ItemMaster;

public interface IItemDao {
	List<ItemMaster> findAll();
}
