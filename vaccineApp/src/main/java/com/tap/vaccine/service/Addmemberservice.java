package com.tap.vaccine.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.AddmemberDAO;
import com.tap.vaccine.dao.LoginDAOimpl;
import com.tap.vaccine.dao.RegisterDAOimpl;
import com.tap.vaccine.entity.MemberEntity;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class Addmemberservice {
	
	private AddmemberDAO addmemberDAO;
	private RegisterDAOimpl registerDAO;
	private LoginDAOimpl loginDAO;
	
	
	@Autowired
	public Addmemberservice(AddmemberDAO addmemberDAO,RegisterDAOimpl registerDAO,LoginDAOimpl loginDAO) {
		this.addmemberDAO=addmemberDAO;
		this.registerDAO=registerDAO;
		this.loginDAO=loginDAO;
		System.out.println("i m in tbhe way");
	}
	
	
	public boolean validateAddmember(String membername,String gender, String dob, String idProof,String idproofno,String vaccinetype,int noofdoses, String refemail) {
		MemberEntity entity=new MemberEntity(membername,gender,dob,idProof,idproofno,vaccinetype,noofdoses,refemail);
		System.out.println("i m in tbhe way2");
		boolean flag=false;
		if(membername!=null && !membername.isEmpty()&& !membername.isBlank()) {
			flag=true;
		}else {
			flag= false;
		}
		if(gender!=null&& !gender.isEmpty()&& !gender.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		if(dob!=null&& !dob.isEmpty()&& !dob.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		if(idProof!=null&& !idProof.isEmpty()&& !idProof.isBlank()){
			flag=true;
		}else {
			flag= false;
		}	
		if(vaccinetype!=null&& !vaccinetype.isEmpty()&& !vaccinetype.isBlank()){
			flag=true;
		}else { 
			flag=false;
		}
		
		if(refemail!=null&& !refemail.isEmpty()&& !refemail.isBlank()){
			flag=true;
		}else { 
			flag=false;
		}
		RegisterEntity entity2 =loginDAO.getRegisterEntityBy(refemail);
		int memcount=entity2.getMembercount();
		if(flag&&entity2.getMembercount()<4) {
			boolean fl=addmemberDAO.saveMemberEntity(entity);
			if(fl) {
				flag=true;
			}else {
				flag=false;
			}
			
		}
		return flag;
	}
	
	public List<MemberEntity> getallMemberEntity(String refemail){
		System.out.println("Invoked getAllMemberEntity");
		if(addmemberDAO.getAllMemeberEntity(refemail).size()!=0) {
			return addmemberDAO.getAllMemeberEntity(refemail);			
		}
		return null;
	}
	
	public int increment(String email) {
		int i=0;
		RegisterEntity entity =loginDAO.getRegisterEntityBy(email);
		if(entity.getMembercount()<4) {
			i=registerDAO.updateAddMember(email,entity.getMembercount()+1);
		}
		System.out.println("add members............in service....."+entity.getMembercount());
		return i;
		
	}
	
	public int decrement(String email) {
		int i=0;
		RegisterEntity entity =loginDAO.getRegisterEntityBy(email);
		i=registerDAO.updateAddMember(email,entity.getMembercount()-1);
		System.out.println("add members............in service....."+entity.getMembercount());
		return i;
	}
	
	public MemberEntity getMemberById(int memberid) {
		System.out.println("validate.....id by ");
		return addmemberDAO.getMemberById(memberid);
	}


	public boolean updatememberEntity(int memberid,String membername, String gender, String dob, String idProof, String idproofno,
		String vaccinetype, int noofdoses, String refemail) {
		System.out.println("invoked updateAirportEntity");
		MemberEntity entity=new MemberEntity(memberid,membername,gender,dob,idProof,idproofno,vaccinetype,noofdoses,refemail);
		return addmemberDAO.updateMemberEntity(entity);
	} 
	
	public boolean deletememberEntity(int memberid) {
		System.out.println("invoked deleteMemberEntity in Service class");
		return addmemberDAO.deleteMemberEntity(memberid);
	} 
	
}
