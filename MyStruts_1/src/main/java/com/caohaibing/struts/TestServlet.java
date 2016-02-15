package com.caohaibing.struts;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能说明：重构  MVC实现 struts 框架
 * 
 * http://blog.csdn.net/jiuqiyuliang/article/details/39030625
 * @author caohaibing
 *
 */
public class TestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//取得访问的URI
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		
		//截取URI，获得路径
		String path = requestURI.substring(requestURI.indexOf("/",1), requestURI.indexOf("."));
		System.out.println(path);
		
		//获得表单数据
		String username = request.getParameter("username");
		
		UserManager userManager = new UserManager();
		
		String forward ="";
		
		//根据url执行相关的功能 
		if("/servlet/addUser".equals(path)){ 
			userManager.add(username);
			forward ="/add_success.jsp"; 
		}else if("/servlet/delUser".equals(path)){ 
			userManager.del(username);
			forward ="/del_success.jsp"; 
		}else if("/servlet/modifyUser".equals(path)){ 
			userManager.modify(username);
			forward ="/modify_success.jsp"; 
		}else if("/servlet/queryUser".equals(path)){
			//调用查询的业务逻辑
			List userList = userManager.query(username);
			request.setAttribute("userList", userList);
			forward ="/query_success.jsp";
		}else{
			throw new RuntimeException("请求失败");
		}
		
		//统一完成转向
		request.getRequestDispatcher(forward).forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
