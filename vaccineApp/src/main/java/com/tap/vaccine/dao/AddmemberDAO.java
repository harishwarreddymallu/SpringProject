package com.tap.vaccine.dao;

import java.util.List;

import com.tap.vaccine.entity.MemberEntity;

public interface AddmemberDAO {
	boolean saveMemberEntity(MemberEntity entity);
	List<MemberEntity> getAllMemeberEntity(String refemail);
	MemberEntity getMemberById(int memberid);
	boolean updateMemberEntity(MemberEntity entity);
	boolean deleteMemberEntity(int memberid); 
}
