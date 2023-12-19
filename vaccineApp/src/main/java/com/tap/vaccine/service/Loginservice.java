package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.LoginDAOimpl;
import com.tap.vaccine.entity.RegisterEntity;


@Component
public class Loginservice {
	
	
	private LoginDAOimpl loginDAO;
	private JavaMailSenderImpl javamailSender;
	public String emaill;
	

	
	@Autowired
	public Loginservice(LoginDAOimpl loginDAO,JavaMailSenderImpl javamailSender) {
		this.javamailSender=javamailSender;
		this.loginDAO = loginDAO;
		System.out.println("i m in tbhe way of login service para constructor!!");
	}
	
	
	public boolean validateLogin(String email, String password) {
		System.out.println("i m in tbhe way2");
		boolean flag=false;
		if(email!=null&& !email.isEmpty()&& !email.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		if(password!=null&& !password.isEmpty()&& !password.isBlank()){
			flag=true;
		}else { 
			flag=false;
		}
		if(flag) {
			System.out.println("valid........aa............");
			if(loginDAO.getRegisterEntityBy(email)!=null) {
				flag=true;
			}else {
				flag=false;
			}
			
		}
		
		return flag;
	}

	public boolean verifyLoginCredentials(String email, String password) {
		
        RegisterEntity entity =loginDAO.getRegisterEntityBy(email);
        boolean flag=false;
        emaill=email;
	    if(entity!=null) {
	    	if (entity.getLoginAttempts()>= 3) {
	        		
        		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        		System.out.println("hi i am mail");
        		simpleMailMessage.setTo(email);
        		simpleMailMessage.setSubject(email);
        		
        		simpleMailMessage.setText("Dear "+email+"" +"You Account had blocked due to too many attempts please reset the password!!");
        		
        		System.out.println("s....blocked mail.......");
        		try {
        			javamailSender.send(simpleMailMessage);
        			
        		}catch(MailException e) {
        			String message=e.getMessage();
//        			String localizedMessage=e.getLocalizedMessage();
        			System.out.println(message);
        		}
        		flag= false;
	    	}else if(email.equals(entity.getEmail()) && password.equals(entity.getPassword())) {
        		// Compare email and password
        		return true;
        		
        	} else{
	            // Increment login attempt count on failed login
	        	int i=loginDAO.updateEntityBy(email, entity.getLoginAttempts());
	            
	            System.out.println(i+1 +" loginservice");
	            
	          
	            flag= false; 
			        
        	}
        }
        
		return flag;
	}

}
