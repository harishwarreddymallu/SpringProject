package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.service.Vaccineservice;

@Controller
public class RegisterController {
	private Vaccineservice vaccineservice;
	
	@Autowired
	public RegisterController(Vaccineservice vaccineservice) {
		System.out.println("hey I am Registercontroller Constructor!!");
		this.vaccineservice=vaccineservice;
		
	}
	
	@RequestMapping(value="/getRegisterPage")
	public String getRegisterPage()
	{
		return "/WEB-INF/Register.jsp";
	}
	
	@RequestMapping(value="/userregister")
	public String acceptFirstRequest(@RequestParam String name,
									@RequestParam String email,
									@RequestParam String mobileno,
									@RequestParam String gender,
									@RequestParam String password,
									@RequestParam String dob,
									Model model) {
		System.out.println("Name : "+name);
		System.out.println("email : "+email);
		System.out.println("mobile no : "+mobileno);
		System.out.println("gender : "+gender);
		System.out.println("password : "+password);
		System.out.println("date of birth is : "+dob);
		System.out.println("hey nuv valid aa!!.............");

		boolean isvalid= vaccineservice.validateVaccine(name,email,mobileno,gender,password,dob);
		boolean result=vaccineservice.sendEmail(name,email,mobileno,gender,password,dob); 
		
		if(isvalid&&result) {
			System.out.println("hi i am from sending mail");
			model.addAttribute("responseMessage","Registration Successfull! mail sent to registered one's!!");
			return "/WEB-INF/Register.jsp";
			
		}else {
			
			model.addAttribute("responseMessage","Something went wrong!! Please Try Again!!.......");
			return "/WEB-INF/Register.jsp";
		}
			
	}
		
}
	
	

