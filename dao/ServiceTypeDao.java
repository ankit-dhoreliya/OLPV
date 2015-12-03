package org.itc.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.itc.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DocumentDaoImpl implements DocumentDao {
	
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
   
    @Transactional   
    public void addItem(Document doc){
    	
    	sessionFactory.getCurrentSession().saveOrUpdate(doc);
    }
    
      @Override
      @Transactional
      @SuppressWarnings("unchecked")
      public List<Document> getDoc(int id) {
    
		List<Document> list = sessionFactory.getCurrentSession().createQuery("from Document b where b.id = :id")
		          .setParameter("id", id)
		          .list();
		     return list; 
	
    } 
    
      
}



