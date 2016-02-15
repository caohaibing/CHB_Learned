package com.caohaibing.struts.action; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caohaibing.struts.manager.UserManager;

public class QueryUserAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String username = req.getParameter("username");
		//其他查询条件
		 
		//调用业务逻辑
		UserManager userManager = new UserManager();

		List userList = userManager.query(username);
		req.setAttribute("userList", userList); 
		
		//返回查询成功的界面
		return "/query_success.jsp";//转向路径可以通过配置文件读取
	}

}

