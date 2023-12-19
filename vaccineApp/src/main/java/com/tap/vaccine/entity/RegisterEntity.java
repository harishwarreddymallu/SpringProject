package com.tap.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register")
public class RegisterEntity {
	
	@Column(name="ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="MOBILE_NO")
	private String mobileno;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="DATE_OF_BIRTH")
	private String dob;
	
	@Column(name="LOGIN_ATTEMPTS")
	private int loginattempts;
	
	@Column(name="MEMBER_COUNT")
	private int membercount;
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	public RegisterEntity(int id, String name, String email, String mobileno, String gender, String password,String dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileno = mobileno;
		this.gender = gender;
		this.password = password;
		this.dob=dob;
	}
	public RegisterEntity(int id, String name, String email, String mobileno, String gender, String password,String dob,int membercount) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileno = mobileno;
		this.gender = gender;
		this.password = password;
		this.dob=dob;
		this.membercount=membercount;
	}
	
	public RegisterEntity(String name, String email, String mobileno, String gender, String password,String dob) {
		this.name = name;
		this.email = email;
		this.mobileno = mobileno;
		this.gender = gender;
		this.password = password;
		this.dob=dob;
	}
	
	public RegisterEntity() {
		
	}
	
	public RegisterEntity(String email, String password) {
		
		this.email = email;
		this.password = password;
	}

	public String toString() {
		return id+" "+name+" "+email+" "+mobileno+" "+gender +" "+password+" "+dob+" "+membercount;
	}


	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNo() {
		return mobileno;
	}

	
	public void setMobileNo(String mobileno) {
		this.mobileno = mobileno;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getLoginAttempts() {
		return loginattempts;
	}

	public void setLoginAttempts(int loginattempts) {
		this.loginattempts = loginattempts;
		System.out.println(loginattempts);
		System.out.println("hey my logi attempts");
	}
	
	public int getMembercount() {
		System.out.println("entityclass member count"+membercount);
		return membercount;
	}
	
	public void setMembercount(int membercount) {
		this.membercount = membercount;
		System.out.println("hey my member attempts"+membercount);
	}
}
