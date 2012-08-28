package com.redhat.cloudform.demo.handler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.redhat.cloudform.demo.events.Content;

@SessionScoped
public class ContentHandler implements Serializable {

	private static final long serialVersionUID = -3093559590034641607L;
	
	@Inject
	private Logger logger;
	
	List<Content> contents = new ArrayList<Content>();
	
	@Produces
	@Named
	public List<Content> getContents() {
		return contents;
	}


	public void onEvent(@Observes Content event) {
		
		logger.info("Processing event: " + event);
		
		contents.add(event);
		
		addToDB(event);
	}

	private void addToDB(Content event) {
		
		logger.info("persit event to DB");
		
	}
}
