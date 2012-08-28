package com.redhat.cloudform.demo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.redhat.cloudform.demo.ejb.ContentSession;
import com.redhat.cloudform.demo.events.Content;

@Named
@SessionScoped
public class SearchBean implements Serializable{

	private static final long serialVersionUID = 7208336868119556418L;

	private static final Logger logger = Logger.getLogger(SearchBean.class);
	
	@Inject
	private ContentSession contentSession;
	
	List<Content> lists = new ArrayList<Content>();

	@Produces
	@Named
	public List<Content> getLists() {
		return lists;
	}
	
	
	public void search() {
		
		logger.debug("extract all event from db");
		
		lists.clear();
		
		try {
			lists = contentSession.search();
		} catch (Exception e) {
			logger.error(e);
		}
	}
}
