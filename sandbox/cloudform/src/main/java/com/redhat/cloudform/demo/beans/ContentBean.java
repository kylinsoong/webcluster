package com.redhat.cloudform.demo.beans;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.redhat.cloudform.demo.events.Content;

@Named
@SessionScoped
public class ContentBean implements Serializable {

	private static final long serialVersionUID = -2129634854762195272L;

	private static final Logger logger = Logger.getLogger(ContentBean.class);
	
	@Inject
	Event<Content> contentProducer;
	
	private String content = "Content Display Demo";
	
	public Event<Content> getContentProducer() {
		return contentProducer;
	}

	public void setContentProducer(Event<Content> contentProducer) {
		this.contentProducer = contentProducer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String add() {
		
		Content currentEvtPayload = new Content();
		currentEvtPayload.setDatetime(new Date());
		currentEvtPayload.setContent(content);
		currentEvtPayload.setServer(System.getProperty("jboss.bind.address"));
		
		contentProducer.fire(currentEvtPayload);
		
		logger.debug("add " + currentEvtPayload);
		
		return "index";
	}
	
	public void reset() {
		
		logger.debug("reset content");
		
		content = null;
	}
}
