package com.caohaibing.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caohaibing.struts.manager.UserManager;

public class DelUserAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String username = req.getParameter("username");
		//其他删除条件。。。 
		
		//调用业务逻辑
		UserManager userManager = new UserManager(); 
		userManager.del(username);
		
		//返回删除成功的界面
		return "/del_success.jsp";//转向路径可以通过配置文件读取
	}

}
