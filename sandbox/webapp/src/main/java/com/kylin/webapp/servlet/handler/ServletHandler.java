package com.kylin.webapp.servlet.handler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;


@SessionScoped
public class ServletHandler implements Serializable{

	private static final long serialVersionUID = -713087320671026445L;
	
	List<Content> contents = new ArrayList<Content>();
	
	public ServletHandler() {
		contents.add(new Content(1, "Hello World", "<a href=\"/webapp/RequestHeader\">Execute</a>", ""));
	}

	@Produces
	@Named
	public List<Content> getContents() {
		return contents;
	}
	
}
