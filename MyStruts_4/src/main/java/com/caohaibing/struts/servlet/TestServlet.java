package com.caohaibing.struts.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caohaibing.struts.action.Action;
import com.caohaibing.struts.action.mapping.ActionMapping;
import com.caohaibing.struts.action.mapping.Mappings;

/**
 * 使用servlet做相关的控制，转向多个（V）视图
 * http://blog.csdn.net/jiuqiyuliang/article/details/39061305
 * @author caohaibing 
 */
public class TestServlet  extends HttpServlet {
	
	//需要读取的文件名
	protected static String config = "/WEB-INF/struts-config.xml";
	
	public void init() throws ServletException {
		//获得文件的路径
		//initialize();
		//根据web.xml中映射的目录获得文件在对应服务器中的真实路径
		config = getServletContext().getRealPath("/")+ getInitParameter("config");
		//解析struts-config.xml配置文件
		ConfigInit.init(config);
	}
	
	//根据web.xml中映射的目录获得文件在对应服务器中的真实路径
//	private void initialize() {
//		try {
//			config = getServletContext().getRealPath("/")
//					+ getInitParameter("config");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//取得访问的URI
		String reqeuestURI = request.getRequestURI();
		//截取URI，获得路径
		String path = reqeuestURI.substring(reqeuestURI.indexOf("/",1), reqeuestURI.indexOf("."));
		 
		// 根据截取的URL请求，到Map中取得本次请求对应的Action类
		ActionMapping actionMapping = (ActionMapping)Mappings.actionsMap.get(path);  
		//取得本请求对应的Action类的完整路径
		String type = actionMapping.getType(); //com.caohaibing.struts.action.DelUserAction
		//采用反射，动态实例化Action
		try {
			Action action = (Action)Class.forName(type).newInstance();
			// 采用多态的机制，动态调用Action中的execute方法，返回转向路径
			String result = action.execute(request, response);
			
			//获得真实转向页面
			String forward =(String)actionMapping.getForward().get(result);
			
			//根据转向路径完成转向
			request.getRequestDispatcher(forward).forward(request, response);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		   
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	} 	
}
