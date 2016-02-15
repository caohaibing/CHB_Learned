package com.caohaibing.spring.service;

import com.caohaibing.spring.dao.Dao;

public interface Service {
	
	//增加注入接口的方法
	public void setDao(Dao dao);
	
	public void serviceMethod(); 	
}
