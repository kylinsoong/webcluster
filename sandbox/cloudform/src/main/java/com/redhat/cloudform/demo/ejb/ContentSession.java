package com.redhat.cloudform.demo.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.redhat.cloudform.demo.events.Content;

@Stateless
public class ContentSession {

	@PersistenceContext
    private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addContent(Content content) {
		em.persist(content);
	}
	
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List<Content>  search() {
		
		return em.createQuery("select c from Content c").getResultList();
	}
}
