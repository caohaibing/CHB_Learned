package com.caohaibing.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caohaibing.struts.servlet.UserManager;

public class DelUserAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String username = req.getParameter("username");
		
		UserManager userManager = new UserManager();
		 
		userManager.del(username);
		 
		return "/del_success.jsp";
	}

}
