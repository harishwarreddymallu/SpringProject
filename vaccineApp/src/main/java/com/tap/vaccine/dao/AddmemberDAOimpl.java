package com.tap.vaccine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.MemberEntity;


@Component
public class AddmemberDAOimpl implements AddmemberDAO{

	private SessionFactory sessionFactory;
	Session session;
	
	@Autowired
	public AddmemberDAOimpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		System.out.println("session f is inserted by ioc container in MemberRegisterDAO!!");
		
	}
	
	@Override
	public boolean saveMemberEntity(MemberEntity entity) { {
		System.out.println("invoked saveMemberEntity");
		boolean isDataSaved=false;
		Transaction transaction=null;
		try {
		session=this.sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(entity); 
		
		transaction.commit();
		
		System.out.println("MemberEntity entity had saved");
		
		isDataSaved=true;
		}catch(Exception he){
			System.out.println(he.getMessage());
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
	public List<com.tap.vaccine.entity.MemberEntity> getAllMemeberEntity(String refemail) {
		// TODO Auto-generated method stub
		System.out.println("invoked saveMemberEntity getAllMemeberEntity() in dao");
		int i=0;
		
		String hql="from MemberEntity where  refEmail='"+refemail+"'";
		
		try {
		session=this.sessionFactory.openSession();
		Query query=session.createQuery(hql);
		List <MemberEntity> resultlist=query.getResultList();
		resultlist.forEach(obj->System.out.println(obj));
		return resultlist;
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
	}

	@Override
	public MemberEntity getMemberById(int memberid) {
		System.out.println("invoked saveairportEntity");
		MemberEntity entity=null;
		
		try {
		session=this.sessionFactory.openSession();
		entity=session.get(MemberEntity.class, memberid);
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
	public boolean updateMemberEntity(MemberEntity entity) {

		try {
		session=this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		
		return true;
		
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
	}

	@Override
	public boolean deleteMemberEntity(int memberid) {
		Session session=null;
		MemberEntity entity=null;
		try {	
			session=this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			entity= session.get(MemberEntity.class, memberid);
	        session.delete(entity);
	        transaction.commit();
			return true;
		}finally {
				
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
	}
}
