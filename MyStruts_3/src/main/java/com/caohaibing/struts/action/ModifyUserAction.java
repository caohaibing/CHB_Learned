package com.caohaibing.struts.action; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caohaibing.struts.manager.UserManager;

public class ModifyUserAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
		String username = req.getParameter("username");
		//int age = Integer.parseInt(req.getParameter("age"));
		//String sex = req.getParameter("sex");
		
		
		//调用业务逻辑
		UserManager userManager = new UserManager();
		userManager.modify(username);
		
		//返回修改成功的界面
		return "/modify_success.jsp";//转向路径可以通过配置文件读取
	}

}
