package com.caohaibing.spring.service.impl;

import com.caohaibing.spring.dao.Dao;
import com.caohaibing.spring.service.Service;

public class ServiceImpl implements Service {
	
	private Dao dao;
	//依赖注入
	public void setDao(Dao dao) {
		this.dao = dao; 
	}

	public void serviceMethod() {
		dao.daoMethod();
	}

}
