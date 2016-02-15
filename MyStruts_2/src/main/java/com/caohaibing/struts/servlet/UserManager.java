package com.caohaibing.struts.servlet; 

import java.util.ArrayList;
import java.util.List;

public class UserManager {

	public void add(String username){ 
		System.out.println("UserManager.add()-->>>username:" + username);
	}
	
	public void del(String username){ 
		System.out.println("UserManager.del()-->>>username:" + username);
	}

	public void modify(String username){ 
		System.out.println("UserManager.modify()-->>>username:" + username);
	}
	
	public List query(String username){ 
		System.out.println("UserManager.query()-->>>username:" + username);
		List userList = new ArrayList();
		userList.add("a");
		userList.add("b");
		userList.add("c");
		userList.add("d");
		
		return userList; 
	}
}

