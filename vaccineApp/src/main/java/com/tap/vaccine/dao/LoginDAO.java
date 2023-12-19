package com.tap.vaccine.dao;

import com.tap.vaccine.entity.RegisterEntity;

public interface LoginDAO {
	RegisterEntity getRegisterEntityBy(String email);
	int updateEntityBy(String email, int loginattempts);
}
