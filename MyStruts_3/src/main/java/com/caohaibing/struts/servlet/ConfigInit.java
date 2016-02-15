package com.caohaibing.struts.servlet; 

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.caohaibing.struts.action.mapping.ActionMapping;
import com.caohaibing.struts.action.mapping.Mappings;
 

public class ConfigInit {

	public static void init(String config) {
		// 创建saxReader对象
		SAXReader reader = new SAXReader();
		File f = new File(config);
		try {
			// 通过read方法读取xml文件， 转换成Document对象
			Document doc = reader.read(f);
			// 得到配置文件的根结点
			Element root = doc.getRootElement();
			Element actionmappings = (Element) root.element("action-mappings");
			// 解析action结点的所有参数
			for (Iterator j = actionmappings.elementIterator("action"); j
					.hasNext();) {
				Element am = (Element) j.next();
				ActionMapping actionMapping = new ActionMapping();

				// 设置actionMapping的path和type
				actionMapping.setPath(am.attributeValue("path"));
				actionMapping.setType(am.attributeValue("type"));
				/*
				 * 下面Mappings.actions的存储结构相当于将配置文件struts-config.xml与映射一一对应
				 * map.put("/servlet/delUser", actionMapping);
				 * map.put("/servlet/addUser", actionMapping);
				 * map.put("/servlet/modifyUser", actionMapping);
				 * map.put("/servlet/queryUser", actionMapping);
				 */
				Mappings.actionsMap.put((String) am.attributeValue("path"),
						actionMapping);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
