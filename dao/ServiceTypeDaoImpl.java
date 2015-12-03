package org.itc.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.itc.model.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class ServiceTypeDaoImpl implements  ServiceTypeDao{
	
	@Autowired
	private SessionFactory sessionFactory;  
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional 
	public List <ServiceType> serviceTableInformation()
	{
		List<ServiceType> list = sessionFactory.getCurrentSession()
				.createQuery("from ServiceType").list();
		
		return sessionFactory.getCurrentSession()
				.createQuery("from ServiceType").list();
	}

}
