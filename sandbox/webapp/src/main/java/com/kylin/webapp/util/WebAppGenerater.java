package com.kylin.webapp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class WebAppGenerater {
	
	String servletPath = "src/main/java/com/kylin/webapp/servlet/";

	String[] servletName = new String[]{"CookieServlet.java", "HelloWorldServlet.java", "RequestHeaderServlet.java", "RequestInfoServlet.java", "RequestParamServlet.java", "SessionServlet.java"};
	
	
	List<WebApp> applist = new ArrayList<WebApp>();
	
	protected void writeServlet() throws IOException {
		
		for(String name : servletName) {
			
			String content = readFileFromClasspath(servletPath + name);
			
			applist.add(new WebApp(Type.Servlet, name.substring(0, name.length() - 5), content));
		}
		
	}

	private String readFileFromClasspath(String path) throws IOException {

		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
		
		StringBuffer sb = new StringBuffer();
		String tmp = null;
		
		sb.append("\n");
		
		while((tmp = br.readLine()) != null) {
			sb.append(tmp + "\n");
		}
		
		return sb.toString();
	}

	private void generateWebAppXML() throws IOException, ParserConfigurationException, TransformerException {
		
		writeServlet();
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("webapps");
		doc.appendChild(rootElement);
		
		for (WebApp app : applist) {
			
			Element webapp = doc.createElement("webapp");
			rootElement.appendChild(webapp);
			
			webapp.setTextContent(app.getContent());
			
			Attr type = doc.createAttribute("type");
			type.setValue(app.getType() + "");
			webapp.setAttributeNode(type);
			
			Attr name = doc.createAttribute("name");
			name.setValue(app.getName());
			webapp.setAttributeNode(name);
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("src/main/resources/webapp.xml"));
		
		transformer.transform(source, result);
		 
		System.out.println("DONE");
	}
	
	public static void main(String[] args) throws Exception {

		new WebAppGenerater().generateWebAppXML();
	}

}
