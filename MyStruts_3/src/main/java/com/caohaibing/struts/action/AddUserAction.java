package com.caohaibing.struts.action; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caohaibing.struts.manager.UserManager;

public class AddUserAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		//获取参数
		String username = req.getParameter("username");
		
		//调用业务逻辑
		UserManager userManager = new UserManager(); 
		//添加的业务逻辑
		userManager.add(username);
		
		//返回成功的界面
		return "/add_success.jsp";//转向路径可以通过配置文件读取
	}

}
