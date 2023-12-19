package com.tap.vaccine.dao;

import com.tap.vaccine.entity.RegisterEntity;

public interface RegisterDAO {
	abstract boolean saveRegisterEntity(RegisterEntity entity);
	int updateAddMember(String email, int membercount);

}
