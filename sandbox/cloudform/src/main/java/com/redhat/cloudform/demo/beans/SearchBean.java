package com.redhat.cloudform.demo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.redhat.cloudform.demo.events.Content;

@Named
@SessionScoped
public class SearchBean implements Serializable{

	private static final long serialVersionUID = 7208336868119556418L;

	@Inject
	private Logger logger;
	
	List<Content> lists = new ArrayList<Content>();

	@Produces
	@Named
	public List<Content> getLists() {
		return lists;
	}
	
	public void search() {
		
		logger.info("extract all event from db");
		
		for (int i = 0 ; i < 50 ; i ++) {
			Content c = new Content();
			c.setId( i + 1 );
			c.setDatetime(new Date());
			c.setContent("-------");
			c.setServer(System.getProperty("jboss.bind.address"));
			lists.add(c);
		}
	}
}
