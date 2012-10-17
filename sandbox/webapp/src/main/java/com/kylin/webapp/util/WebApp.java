package com.kylin.webapp.util;

public class WebApp {

	private Type type;
	
	private String name;
	
	private String content;

	public WebApp(Type type, String name, String content) {
		super();
		this.type = type;
		this.name = name;
		this.content = content;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "WebApp [type=" + type + ", name=" + name + ", content="
				+ content + "]";
	}
}
