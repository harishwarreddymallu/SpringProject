package com.tap.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;

@Component
public class ResetpasswordDAOimpl implements ResetpasswordDAO{
	
	private SessionFactory sessionFactory;
	Session session;
	RegisterEntity entity;
	
	@Autowired
	public ResetpasswordDAOimpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		System.out.println("session f is inserted by ioc container in ResetpasswordController");
		
	}
	
	@Override
	public int updateResetPassword(String email,String newpassword) {
		System.out.println("invoked RegisterEntity to resetpassword");
		int i=0;
		Transaction t=null;
		String hql = "update RegisterEntity set loginattempts=:log, password=:pwd where email=:mail";
		try {
			session=this.sessionFactory.openSession();
			t=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setParameter("log",0);
			query.setParameter("pwd",newpassword );
			query.setParameter("mail",email );
			i=query.executeUpdate();
			System.out.println(newpassword);
			t.commit();
			return i;
		}catch(Exception e){
			System.out.println(e.getMessage());
			t.rollback();
			return i;
			
		}
		finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
			
			
		}
		
	}
	
}
