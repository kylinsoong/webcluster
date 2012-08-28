package com.redhat.cloudform.demo.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.redhat.cloudform.demo.events.Content;

@Stateless
public class ContentSession {
	
	private static final Logger logger = Logger.getLogger(ContentSession.class);

	@PersistenceContext
    private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addContent(Content content) {
		
		logger.debug("add content to DB: "  + content);
		
		em.persist(content);
	}
	
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List<Content>  search() {
		
		logger.debug("select all contents from DB");
		
		return em.createQuery("select c from Content c").getResultList();
	}
}
