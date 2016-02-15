package com.caohaibing.struts.action; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	/**
	 * 公共的抽象接口
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}

