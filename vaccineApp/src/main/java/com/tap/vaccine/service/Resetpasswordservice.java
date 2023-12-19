package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.LoginDAOimpl;
import com.tap.vaccine.dao.ResetpasswordDAOimpl;


@Component
public class Resetpasswordservice{
	
	private LoginDAOimpl loginDAO;
	private JavaMailSenderImpl javamailSender;
	private ResetpasswordDAOimpl resetpasswordDAO;
	
	
	private Loginservice loginservice;

	
	@Autowired
	public Resetpasswordservice(LoginDAOimpl loginDAO,JavaMailSenderImpl javamailSender,Loginservice loginservice,ResetpasswordDAOimpl resetpasswordDAO) {
		this.javamailSender=javamailSender;
		this.loginDAO = loginDAO;
		this.loginservice = loginservice;
		this.resetpasswordDAO = resetpasswordDAO;
		System.out.println("i m in tbhe way of login service para constructor!!");
	}
	
	
	
	public boolean validateNewPassword(String email,String newpassword,String confirmnewpassword) {
		
		boolean flag=false;
		if(email!=null && !email.isEmpty()&& !email.isBlank()) {
			flag=true;
		}else {
			flag= false;
		}
			
		if(newpassword!=null&& !newpassword.isEmpty()&& !newpassword.isBlank()){
			flag=true;
		}else {
			flag= false;
			}	
		
		if(confirmnewpassword!=null&& !confirmnewpassword.isEmpty()&& !confirmnewpassword.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		
		return flag;
		
	}
	
	
	
	
	public  boolean PasswordByEmail(String email,String newpassword,String confirmnewpassword) {
		boolean flag=false;
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
 		System.out.println("hi i am mail");
 		simpleMailMessage.setTo(email);
 		simpleMailMessage.setSubject(email);
 		
 		simpleMailMessage.setText("Dear "+email+"."
				+ " \nYour New Password is "+newpassword+" \n Please Remember it to Sign in "
						+ "and don't Share with any other else. \n#Thank You for your Intrest!!");
 		System.out.println("s....snding..newpassword... mail.......");
 		
 		
 		try {
 			if(loginservice.emaill!=null) {
	 			if(loginservice.emaill.equals(email)) {
	 	 			System.out.println("yes equal mails");
	 			
		 			if(loginDAO.getRegisterEntityBy(email)!=null) {
		 				javamailSender.send(simpleMailMessage);
		 				int i=resetpasswordDAO.updateResetPassword(email,newpassword);
						flag=true;
					}
	 			}
 			}

 		}catch(MailException e) {
 			String message=e.getMessage();
//     		String localizedMessage=e.getLocalizedMessage();
 			System.out.println(message);
 			
 		}
 		return flag;
		
	}
		
		

}
