package com.kylin.webapp.servlet.handler;

import java.io.Serializable;

public class Content implements Serializable {

	private static final long serialVersionUID = -3086160304408106153L;

	private int id;
	
	private String content;
	
	private String execute;
	
	private String source;

	public Content(int id, String content, String execute, String source) {
		super();
		this.id = id;
		this.content = content;
		this.execute = execute;
		this.source = source;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getExecute() {
		return execute;
	}

	public void setExecute(String execute) {
		this.execute = execute;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
