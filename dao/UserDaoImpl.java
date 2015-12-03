package org.itc.dao;



import java.sql.SQLException;
import java.util.List;

import org.itc.model.Role;
import org.itc.model.User;
import org.itc.model.UserStatus;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;





@Repository
public class UserDaoImpl implements UserDao {
	
	
	
	@Autowired  
    private SessionFactory sessionFactory;  
	
	@Override  
	@Transactional  
    public void addUser(User user) {  
        sessionFactory.getCurrentSession().saveOrUpdate(user);  
    } 
	
	
	
	
	
	
	@Override  
	@Transactional  
	public User forgetPassword( User user, String newPassword) {  
		
		// User user = null;
		
		Session session = sessionFactory.getCurrentSession();
		
		
		@SuppressWarnings("unchecked")
		List<User> list  = session.createQuery("from User b where b.userName= :userName and b.email= :email").setParameter("userName", user.getUserName()).setParameter("email", user.getEmail()).list();
		
		user = list.size() > 0 ?(User)list.get(0): null;
		if(user != null)
		{
			user.setPassword(newPassword);
			session.update(user);
			return user;
	
		}
		else
		{
			return null;
		}
		
		
		
	}
	
	
	
	
	 
	 
	 @Override
	 @Transactional
	 @SuppressWarnings("unchecked")
	 public void LogoutUser(int userId){
		 
		 User user = null;
		 
		 Session session = sessionFactory.getCurrentSession();
		   List<User> list = session.createQuery("from User b where b.userId= :userId")
					.setParameter("userId", userId).list();
		   
		   user = list.get(0);
		 
		 UserStatus userstatus=new  UserStatus();
			userstatus.setUserstatusId(2);
			user.setUserstatus(userstatus);
			
			session.saveOrUpdate(user); 
		 
		 
	 }
	 
	 

	 
	 @Override
	@Transactional
	 @SuppressWarnings("unchecked")
	 
	 public User findUser(String userName, String password, Role role) throws SQLException
     {
	   
	 User user = null;
		
	   Session session = sessionFactory.getCurrentSession();
	   List<User> list = session.createQuery("from User b where b.userName = :userName and b.password= :password and b.role= :role")
				.setParameter("userName", userName).setParameter("password", password).setParameter("role", role).list();
	   
	   user = list.size() > 0 ?(User)list.get(0): null;
	   
	   if(user == null)
	   {
		   return user;
	   }
	   
	   else{
	   
		   return user;
	   }
       
     }


}
