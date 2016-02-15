package com.caohaibing.struts.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caohaibing.struts.action.Action;
import com.caohaibing.struts.action.AddUserAction;
import com.caohaibing.struts.action.DelUserAction;
import com.caohaibing.struts.action.ModifyUserAction;
import com.caohaibing.struts.action.QueryUserAction;

/**
 * http://blog.csdn.net/jiuqiyuliang/article/details/39054165
 * @author caohaibing
 *
 */
public class TestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//取得访问的URI
		String reqeuestURI = request.getRequestURI();
		System.out.println(reqeuestURI);
		//截取URI，获得路径
		String path = reqeuestURI.substring(reqeuestURI.indexOf("/",1), reqeuestURI.indexOf("."));
		System.out.println(path);
		
		Action action = null;
		//等于添加，调用AddUserAction
		if ("/servlet/addUser".equals(path)) {
			action = new AddUserAction();
		//等于删除，调用DelUserAction
		}else if ("/servlet/delUser".equals(path)) {
			action = new DelUserAction();
		//等于修改，调用ModifyUserAction
		}else if ("/servlet/modifyUser".equals(path)) {
			action = new ModifyUserAction();
		//等于查询，调用QueryUserAction
		}else if ("/servlet/queryUser".equals(path)) {
			action = new QueryUserAction();
		}else {
			throw new RuntimeException("请求失败");
		}
		
		String forward = null;
		//返回不同的转向页面
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//根据路径,统一完成转向
		request.getRequestDispatcher(forward).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
