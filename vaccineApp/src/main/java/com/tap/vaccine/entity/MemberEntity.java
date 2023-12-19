package com.tap.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_table")
public class MemberEntity {
	
	@Column(name="MEMBER_ID")
	@Id
	private int memberid;
	
	@Column(name="MEMBER_NAME")
	private String membername;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DATE_OF_BIRTH")
	private String dateofbirth;
	
	@Column(name="ID_PROOF")
	private String idproof;
	
	@Column(name="ID_PROOF_NO")
	private String idproofno;
	
	@Column(name="VACCINE_TYPE")
	private String vaccinetype;
	
	@Column(name="VACCINE_DOSE")
	private int vaccinedose;
	
	@Column(name="REF_EMAIL")
	private String refEmail;

	public MemberEntity(String membername, String gender, String dateofbirth, String idproof,
			String idproofno, String vaccinetype, int vaccinedose, String refEmail) {
		super();
		this.membername = membername;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.idproof = idproof;
		this.idproofno = idproofno;
		this.vaccinetype = vaccinetype;
		this.vaccinedose = vaccinedose;
		this.refEmail = refEmail;
	}


	public String getRefEmail() {
		return refEmail;
	}

	
	public void setRefEmail(String refEmail) {
		this.refEmail = refEmail;
	}

	public MemberEntity() {

	}

	public MemberEntity(int memberid, String membername, String gender, String dateofbirth, String idproof,
			String idproofno, String vaccinetype, int vaccinedose,String refEmail) {
		this.memberid = memberid;
		this.membername = membername;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.idproof = idproof;
		this.idproofno = idproofno;
		this.vaccinetype = vaccinetype;
		this.vaccinedose = vaccinedose;
		this.refEmail = refEmail;
	}
	public MemberEntity(String membername, String gender, String dateofbirth, String idproof,
			String idproofno, String vaccinetype, int vaccinedose) {
		
		this.membername = membername;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.idproof = idproof;
		this.idproofno = idproofno;
		this.vaccinetype = vaccinetype;
		this.vaccinedose = vaccinedose;
	}
	
	
	public String toString() {
		return membername+" "+gender+" "+dateofbirth+" "+idproof+" "+idproofno+" "+vaccinetype+" "+vaccinedose;
	}
	
	public int getMemberid() {
		return memberid;
	}

	
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	
	public String getMembername() {
		return membername;
	}

	
	public void setMembername(String membername) {
		this.membername = membername;
	}

	
	public String getGender() {
		return gender;
	}

	
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	
	public String getIdproof() {
		return idproof;
	}

	
	public void setIdproof(String idproof) {
		this.idproof = idproof;
	}

	
	public String getIdproofno() {
		return idproofno;
	}

	
	public void setIdproofno(String idproofno) {
		this.idproofno = idproofno;
	}

	
	public String getVaccinetype() {
		return vaccinetype;
	}

	
	public void setVaccinetype(String vaccinetype) {
		this.vaccinetype = vaccinetype;
	}

	
	public int getVaccinedose() {
		return vaccinedose;
	}

	
	public void setVaccinedose(int vaccinedose) {
		this.vaccinedose = vaccinedose;
	}
	
}
