package com.caohaibing.spring.client;

import com.caohaibing.spring.BeanFactory;
import com.caohaibing.spring.ClassPathXmlApplicationContext;
import com.caohaibing.spring.service.Service;

public class Client {
	public static void main(String[] args) throws Exception {
		
		//从类路径加载配置文件
		BeanFactory factory = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
		
		Service service = (Service) factory.getBean("service");
		service.serviceMethod();
	}
}
