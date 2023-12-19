package com.tap.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;

@Component
public class LoginDAOimpl implements LoginDAO{
	private SessionFactory sessionFactory;
	Session session;
	RegisterEntity entity;
	
	@Autowired
	public LoginDAOimpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		System.out.println("session f is inserted by ioc container ");
		
	}

	@Override
	public RegisterEntity getRegisterEntityBy(String email) {
		System.out.println("invoked RegisterEntity");
		String hql="from RegisterEntity where email='"+email+"'";
		try {
		session=this.sessionFactory.openSession();
		Query query=session.createQuery(hql);
		entity=(RegisterEntity) query.uniqueResult();
		System.out.println(entity);
		if(entity!=null) {
			return entity;
		}
		
		
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return entity;
	}
	
	@Override
	public int updateEntityBy(String email,int loginattempts) {
		System.out.println("invoked RegisterEntity");
		Transaction t=null;
		int i=0;
		
		String hql="update RegisterEntity set loginattempts=:log where email=:email";
		
		try {
			session=this.sessionFactory.openSession();
			t=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setParameter("log",loginattempts+1);
			query.setParameter("email",email );
			i=query.executeUpdate();
			System.out.println(i+" "+loginattempts);
			t.commit();
			return i;
		}catch(Exception e){
			System.out.println(e.getMessage());
			t.rollback();
			return i;
		}finally {
			if(session!=null) {
			session.close();
			System.out.println("session is closed");
			}
		}
		
	}
}

	

