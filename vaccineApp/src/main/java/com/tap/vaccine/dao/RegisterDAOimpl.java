package com.tap.vaccine.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;
@Component
public  class RegisterDAOimpl implements RegisterDAO{
	private SessionFactory sessionFactory;
	private JavaMailSenderImpl javamailSender;
	Session session;
	
	@Autowired
	public RegisterDAOimpl(SessionFactory sessionFactory,JavaMailSenderImpl javamailSender) {
		
		this.sessionFactory = sessionFactory;
		this.javamailSender = javamailSender;
		System.out.println("session f is inserted by ioc container ");
		
	}
	
	@Override
	public boolean saveRegisterEntity(RegisterEntity entity) { {
		System.out.println("invoked saveregisterEntity");
		boolean isDataSaved=false;
		Transaction transaction=null;
		
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		System.out.println("hi i am mail");
		simpleMailMessage.setTo(entity.getEmail());
		simpleMailMessage.setSubject(entity.getName());
		
		simpleMailMessage.setText("Dear  "+entity.getName()+"  Your Registration with  "+entity.getEmail()+" .\n"
				+ " Your Password is  "+entity.getPassword()+" Please Remember it to Sign in \n"
						+ "and don't Share with any other else. \n #Thank You for your Intrest!!");
		
		System.out.println("s...........");
		
		try {
			session=this.sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(entity); 	
			
			javamailSender.send(simpleMailMessage);
				
		
			transaction.commit();
		
		
			System.out.println("airport entity had saved");
		
			isDataSaved=true;
		}catch(Exception he){
			transaction.rollback();
			System.out.println("transaction has been rollback"+he.getMessage());
			
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return isDataSaved;
	}
	
	}
	
	
	@Override
	public int updateAddMember(String email,int membercount) {
		System.out.println("invoked RegisterEntity to resetpassword");
		int i=0;
		Transaction t=null;
		String hql = "update RegisterEntity set membercount=:log where email=:mail";
		try {
			session=this.sessionFactory.openSession();
			t=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setParameter("log",membercount);
			query.setParameter("mail",email );
			i=query.executeUpdate();
			System.out.println("add members............in DAO....."+membercount);
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

	
