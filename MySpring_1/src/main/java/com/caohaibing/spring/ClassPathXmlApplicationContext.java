package com.caohaibing.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

import com.caohaibing.spring.dao.Dao;
import com.caohaibing.spring.service.Service;

/**
 * 从类路径加载配置文件
 * 
 * @author caohaibing 
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
	
	//用来存放Bean
	private List<BeanDefinition> beanDefinesList = new ArrayList<BeanDefinition>();
	
	// 用于存放Bean的实例
	private Map<String, Object> sigletons = new HashMap<String, Object>();
	 
	
	//构造函数
	public ClassPathXmlApplicationContext(String filename) {
		
		this.readXML(filename);
		
		this.instanceBeans();
		
		this.injectObject(); 
	} 
	
	/**
	 * 依赖注入，为bean对象的属性注入值
	 * 这里还不灵活，但是原理是一样的，下篇博文重构封装，依赖注入
	 */
	private void injectObject() {
		Service service = (Service) this.sigletons.get("service");
		Dao dao = (Dao) this.sigletons.get("dao");
		//依赖注入，Service实现依赖dao的实现
		service.setDao(dao);
	}
	
	/**
	 * 完成bean的实例化
	 */
	private void instanceBeans() {
		for(BeanDefinition beanDefinition : beanDefinesList){
			try {
				if(beanDefinition.getClassName() != null && !"".equals(beanDefinition.getClassName().trim())){
					sigletons.put(beanDefinition.getId(),Class.forName(beanDefinition.getClassName()).newInstance() );
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获取bean实例
	 */
	public Object getBean(String beanName) { 
		return this.sigletons.get(beanName);
	}
	
	// 解析xml文件，通过反射将配置的beasn放到container中，并实现依赖注入
	private void readXML(String filename) {
		// 创建SAXBuilder对象
		SAXBuilder saxBuilder = new SAXBuilder();
		
		Document doc;
		// 读取资源，获得document对象
		try {
			doc = saxBuilder.build(this.getClass().getClassLoader()
					.getResourceAsStream(filename));
			// 获取根元素
			Element rootEle = doc.getRootElement();
			// 从根元素获得所有的子元素，建立元素集合
			List beanList = XPath.selectNodes(rootEle, "/beans/bean");
			
			// 遍历根元素的子元素集合，扫描配置文件中的bean
			for (int i = 0; i < beanList.size(); i++) {
				Element bean = (Element) beanList.get(i); 
				
				// 获取id属性值
				String id = bean.getAttributeValue("id"); 
				// 获取class属性值
				String clazz = bean.getAttributeValue("class"); 

				BeanDefinition beanDefine = new BeanDefinition(id,clazz);
				// 将javabean添加到集合中
				beanDefinesList.add(beanDefine);
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	  
}
