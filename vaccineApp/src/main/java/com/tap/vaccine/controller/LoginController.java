package com.tap.vaccine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.dao.LoginDAO;
import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.service.Loginservice;

@Controller
public class LoginController 
{
	public static final String email=null;
	
	private Loginservice loginservice;
	private LoginDAO loginDAO;
	
	@Autowired
	public LoginController(Loginservice loginservice,LoginDAO loginDAO) {
	    this.loginservice = loginservice;
	    this.loginDAO = loginDAO;
	    System.out.println("hey I am Logincontroller Constructor!!");
	}
	
	@RequestMapping(value="/getLoginPage")
	public String getRegisterPage()
	{
		return "/WEB-INF/signin.jsp";
	}
	
	@RequestMapping(value="/updatePassword")
	public String getUpdatePassword()
	{
		return "/WEB-INF/ResetPassword.jsp";
	}
    
	@RequestMapping(value="/getHome")
	public String addMember() {
		return "/WEB-INF/Homepage.jsp";
	}


	@RequestMapping(value="/userLoginpage")
	public String onLogin(@RequestParam String email,
						  @RequestParam String password,
						  Model model,HttpServletRequest request) {
		System.out.println("email : "+email);
		System.out.println("password : "+password);
		System.out.println("hey nuv valid aa!!.............");
		
		RegisterEntity entity =loginDAO.getRegisterEntityBy(email);
	
		boolean isvalid= loginservice.validateLogin(email,password);
		boolean isvalidd= loginservice.verifyLoginCredentials(email,password);
		
		
		if(isvalidd&&isvalid) {
			System.out.println("hi i am from sending mail");
			HttpSession session = request.getSession(true);
			session.setAttribute("EMAIL",email);
			session.setAttribute("ADDMEMBER",entity.getMembercount());
			return "/WEB-INF/Homepage.jsp";
			
		}else {
			
			model.addAttribute("responseMessage","Credentials don't Match!! Please Try Again with Correct Match!!.......");
			return "/WEB-INF/signin.jsp";
		}
	}
}
