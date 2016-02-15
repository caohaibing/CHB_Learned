package com.caohaibing.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caohaibing.struts.servlet.UserManager;

public class ModifyUserAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		 
		String username = req.getParameter("username");
 
		UserManager userManager = new UserManager();

		userManager.modify(username);
		 
		return "/modify_success.jsp";
	}

}
