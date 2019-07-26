package com.sampark.digitalCrm.repository;

import com.sampark.digitalCrm.entity.LoginEntity;

public interface Loginrepository {
	
	public LoginEntity login(LoginEntity login)throws Exception;

}
