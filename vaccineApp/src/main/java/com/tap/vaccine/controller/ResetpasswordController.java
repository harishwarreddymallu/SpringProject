package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.service.Loginservice;
import com.tap.vaccine.service.Resetpasswordservice;

@Controller
public class ResetpasswordController {
	
	private Resetpasswordservice resetpasswordservice;
	
	@Autowired
	public ResetpasswordController(Loginservice loginservice,Resetpasswordservice resetpasswordservice) {
	    this.resetpasswordservice = resetpasswordservice;
	}
	@RequestMapping(value="/resetpassword")
	public String resetPasswordByEmail(@RequestParam String email,
						  @RequestParam String newpassword,
						  @RequestParam String confirmnewpassword,
						  Model model) {
		System.out.println("email : "+email);
		System.out.println("new password : "+newpassword);
		System.out.println("confirm newpassword : "+confirmnewpassword);
		
	
		boolean isvalid=resetpasswordservice.validateNewPassword(email,newpassword,confirmnewpassword);
		boolean result=resetpasswordservice.PasswordByEmail(email,newpassword,confirmnewpassword);
		System.out.println("isvalid.................."+ isvalid);
		System.out.println("is result.................."+result);
		if(result&&isvalid) {
			System.out.println("hi i am from sending mail");
			model.addAttribute("responseMessage","Your Request for Changing Password has done Successfully!!");
			return "/WEB-INF/ResetPassword.jsp";
			
		}else {
			
			model.addAttribute("responseMessage","Sorry User's Login was not correct!! Please Try Again!!.......");
			return "/WEB-INF/ResetPassword.jsp";
		}
	}

}
