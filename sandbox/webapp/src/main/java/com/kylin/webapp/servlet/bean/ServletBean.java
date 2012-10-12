package com.kylin.webapp.servlet.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ServletBean implements Serializable{

	private static final long serialVersionUID = -713087320671026445L;
	
	private String content = "Click Button Show Source Code";
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void show() {
		
		setContent("This is Test");
		System.out.println(content);
	}
	
	public void reset() {
		setContent("");
	}
	
}
