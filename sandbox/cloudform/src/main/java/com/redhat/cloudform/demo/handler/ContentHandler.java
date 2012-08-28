package com.redhat.cloudform.demo.handler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;



import com.redhat.cloudform.demo.ejb.ContentSession;
import com.redhat.cloudform.demo.events.Content;

@SessionScoped
public class ContentHandler implements Serializable {

	private static final long serialVersionUID = -3093559590034641607L;
	
	private static final Logger logger = Logger.getLogger(ContentHandler.class);
	
	@Inject
	private ContentSession contentSession;
	
	List<Content> contents = new ArrayList<Content>();
	
	@Produces
	@Named
	public List<Content> getContents() {
		return contents;
	}


	public void onEvent(@Observes Content event) {
		
		logger.debug("Processing event: " + event);
		
		contents.add(event);
		
		addToDB(event);
	}
	
	

	private void addToDB(Content event) {
		
		logger.debug("persit event to DB");
		
		try {
			contentSession.addContent(event);
		} catch (Exception e) {
			
			logger.error(e);
		}
	}
}
