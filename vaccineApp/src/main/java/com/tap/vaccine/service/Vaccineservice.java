package com.tap.vaccine.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.RegisterDAOimpl;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class Vaccineservice {
	
	
	private RegisterDAOimpl registerDAO;
	private JavaMailSenderImpl javamailSender;
	
	public Vaccineservice() {
		System.out.println("defaulttttttttttttttttttt");
	}
	
	
	@Autowired
	public Vaccineservice(RegisterDAOimpl registerDAO,JavaMailSenderImpl javamailSender) {
		this.registerDAO = registerDAO;
		this.javamailSender= javamailSender;
		System.out.println("i m in tbhe way");
	}
	
	
	public boolean validateVaccine(String name, String email, String mobileno, String gender, String password,String dob) {
		System.out.println("i m in tbhe way2");
		
		boolean flag=false;
	
		if(name!=null && !name.isEmpty()&& !name.isBlank()) {
			flag=true;
		}else {
			flag= false;
		}
			
		if(email!=null&& !email.isEmpty()&& !email.isBlank()){
			flag=true;
		}else {
			flag= false;
			}	
		if(mobileno!=null&& !mobileno.isEmpty()&& !mobileno.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		if(gender!=null&& !gender.isEmpty()&& !gender.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		if(password!=null&& !password.isEmpty()&& !password.isBlank()){
			flag=true;
		}else { }
		if(dob!=null&& !dob.isEmpty()&& !dob.isBlank()){
			flag=true;
		}else {
			flag= false;
		}
		return flag;
	}
	
	public boolean sendEmail(String name, String email, String mobileno, String gender, String password,String dob) {
		boolean flag=false;
		RegisterEntity entity=new RegisterEntity( name,email,mobileno,gender,password,dob);
		System.out.println("valid........aa............");
		flag=registerDAO.saveRegisterEntity(entity);
				
		return flag;
		
	}


	
	
	
	
}



