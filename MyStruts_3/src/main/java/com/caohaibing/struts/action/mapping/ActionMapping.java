package com.caohaibing.struts.action.mapping; 

public class ActionMapping {

	//路径信息
	private String path;
	//action实现类信息
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}

