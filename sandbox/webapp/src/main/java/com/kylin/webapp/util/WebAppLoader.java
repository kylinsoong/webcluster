package com.kylin.webapp.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WebAppLoader {
	
	private static WebAppLoader instance = null;

	public static WebAppLoader getInstance() {
		
		if(null == instance) {
			instance = new WebAppLoader();
		}
		
		return instance ;
	}
	
	private static final String WEBAPP_NAME = "webapp.xml";
	
	Map<String, WebApp> appMap = new HashMap<String, WebApp>();
	
	private WebAppLoader() {
		
		loadwebapp();
	}

	private void loadwebapp() {
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(WEBAPP_NAME);
			Document doc = dBuilder.parse(in);
			
			NodeList nodes = doc.getDocumentElement().getElementsByTagName("webapp");
			for(int i = 0 ; i < nodes.getLength() ; i ++) {
				Node node = nodes.item(i);
				
				String content = node.getTextContent();
				String type = node.getAttributes().getNamedItem("type").getTextContent();
				String name = node.getAttributes().getNamedItem("name").getTextContent();
				
				appMap.put(name, new WebApp(getType(type), name, content));
			}
			
		} catch (Exception e) {
			throw new WebAppLoaderException("Load webapp.xml from class path meet a exception.", e);
		}
	}

	private Type getType(String type) {
		
		if(type.equals(Type.Servlet + "")) {
			return Type.Servlet ;
		} else if(type.equals(Type.JSF + "")) {
			return Type.JSF;
		} else if(type.equals(Type.JSP + "")) {
			return Type.JSP;
		}
		
		return null;
	}
	
	public Set<String> ketSet() {
		return appMap.keySet();
	}
	
	public WebApp get(String key) {
		return appMap.get(key);
	}
	
	public int size() {
		return appMap.size();
	}
}
