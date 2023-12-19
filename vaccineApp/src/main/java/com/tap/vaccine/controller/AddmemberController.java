package com.tap.vaccine.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tap.vaccine.dao.LoginDAO;
import com.tap.vaccine.entity.MemberEntity;
import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.service.Addmemberservice;

@Controller
public class AddmemberController {
	
	private Addmemberservice addmemberservice;
	private LoginDAO loginDAO;
	private LoginController loginController;

	@Autowired
	public AddmemberController(Addmemberservice addmemberservice,LoginDAO loginDAO,LoginController loginController) {
		System.out.println("hey I am AddmemberController Constructor!!");
		this.addmemberservice=addmemberservice;
		this.loginDAO=loginDAO;
		this.loginController=loginController;
		
	}
	
	@RequestMapping(value="/addmember")
	public String addMember() {
		return "/WEB-INF/Addmember.jsp";
	}
	
	@RequestMapping(value="/Addmemberreg")
	public String acceptFirstRequest(@RequestParam String membername,
									@RequestParam String gender,
									@RequestParam String dob,
									@RequestParam String idProof,
									@RequestParam String idproofno,
									@RequestParam String vaccinetype,
									@RequestParam int noofdoses,
									@RequestParam String refemail,
									Model model) {
		System.out.println("Name : "+membername);
		System.out.println("gender : "+gender);
		System.out.println("dob    : "+dob);
		System.out.println("idProof : "+idProof);
		System.out.println("idproofno : "+idproofno);
		System.out.println("vaccinetype : "+vaccinetype);
		System.out.println("noofdoses : "+noofdoses);
		System.out.println("refemail : "+refemail);
		System.out.println("hey nuv valid aa!!.............");
		

		boolean isvalid= addmemberservice.validateAddmember(membername,gender,dob,idProof,idproofno,vaccinetype,noofdoses,refemail);
		int c=addmemberservice.increment(refemail);
		RegisterEntity entity =loginDAO.getRegisterEntityBy(refemail);
		int s=entity.getMembercount();
		if(isvalid&&s>0&&s<4) {
			//check whether the count is 4 or not.
			model.addAttribute("responseMessage","Registration Successfull! ");
		}else if(s>=4){
			
			model.addAttribute("responseMessage","Your Limit exceeds for Adding Memebers!!.......");
		}else {
			model.addAttribute("responseMessage","Something went wrong!! Please Try Again!!.......");
			
		}
		return "/WEB-INF/Addmember.jsp";
			
	}
	
	@RequestMapping(value="/getallMemberDetails")
	public String getallMemberDetails(Model model,HttpServletRequest request) {
		System.out.println("getallAirportDetails........!");
		 HttpSession session = request.getSession(false);
		 
		// Invalidate the session if it exists
	    
		String refemail=(String)(session.getAttribute("EMAIL")); 
		System.out.println("session object in getallMemberEntity().AddmemberServiceClass........."+refemail);
		
		List<MemberEntity> allMemberEntity=addmemberservice.getallMemberEntity(refemail);
		model.addAttribute("Member_ID", "Member_ID");
		model.addAttribute("Member_NAME", "Member_Name");
		model.addAttribute("GENDER", "Gender");
		model.addAttribute("DATE_OF_BIRTH", "Date_Of_Birth");
		model.addAttribute("ID_PROOF", "Id_Proof");
		model.addAttribute("ID_PROOF_NO", "Id_Proof_No");
		model.addAttribute("VACCINE_TYPE", "Vaccine_Type");
		model.addAttribute("DOSE", "Dose");
		model.addAttribute("EDIT", "Edit");
		model.addAttribute("DELETE", "Delete");
		model.addAttribute("getMember",allMemberEntity);
		return "/WEB-INF/Addmember.jsp";
	}
		
	@RequestMapping(value="/editMember/{memberid}")    //path variable
	public String editMemberDetails(@PathVariable int memberid,Model model) {
		System.out.println("Invoked editMembertid() "+ memberid);
		MemberEntity entity=addmemberservice.getMemberById(memberid);
		
		model.addAttribute("ID",entity.getMemberid());
		model.addAttribute("NAME",entity.getMembername());
		model.addAttribute("GENDER",entity.getGender());
		model.addAttribute("DATE_OF_BIRTH",entity.getDateofbirth());
		model.addAttribute("IDPROOF",entity.getIdproof());
		model.addAttribute("ID_PROOF_NO",entity.getIdproofno());
		model.addAttribute("VACCINE_TYPE",entity.getVaccinetype());
		model.addAttribute("DOSE ",entity.getVaccinedose());
		model.addAttribute("REF_EMAIL",entity.getRefEmail());
		
		
		return "/WEB-INF/Editmemberpage.jsp";
		
	}
	

	@RequestMapping(value="/updateMember")   
	public String updateAirport(@RequestParam String membername,
			@RequestParam int memberid,
			@RequestParam String gender,
			@RequestParam String dob,
			@RequestParam String idProof,
			@RequestParam String idproofno,
			@RequestParam String vaccinetype,
			@RequestParam int noofdoses,
			@RequestParam String refemail,
			Model model){
		System.out.println("invoked updateMemberEntity");
		try {
			boolean result=addmemberservice.updatememberEntity(memberid,membername,gender,dob,idProof,idproofno,vaccinetype,noofdoses,refemail);
			
			if(result) {
				
				model.addAttribute("responseMessage","Member entity has been updated!!!");
				
			}else {
				model.addAttribute("responseMessage","Something went Wrong!!!");
				
			}
		}catch(Exception e) {
			model.addAttribute("responseMessage","Something went Wrong!!!");
		}
		return "/WEB-INF/Addmember.jsp";
	}
	
	
	@RequestMapping(value="/deleteMember/{memberid}")   
	public ModelAndView deleteMemberDetails(@PathVariable int memberid,ModelMap model){
		System.out.println("invoked updateAirport()");
		MemberEntity entity=addmemberservice.getMemberById(memberid);
		
		try {
			int c=addmemberservice.decrement(entity.getRefEmail());
			boolean result=addmemberservice.deletememberEntity(memberid);
			System.out.println(c);
			
			if(result&&c>0) {
				
				model.addAttribute("responseMessage","Member entitywith id "+memberid +" has been deleted!!!");
				
			}else {
				model.addAttribute("responseMessage","Something went Wrong!!!");
				
			}
		}catch(Exception e) {
			model.addAttribute("responseMessage","Something went Wrong!!!");
		}
		return new ModelAndView("redirect:/addmember",model);
	}
}
