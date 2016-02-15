package com.caohaibing.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caohaibing.struts.servlet.UserManager;

public class QueryUserAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
	 
		String username = req.getParameter("username");
		 
		UserManager userManager = new UserManager();

		List userList = userManager.query(username);
		req.setAttribute("userList", userList);
	
		userManager.query(username);
		
		return "/query_success.jsp";
	}

}
