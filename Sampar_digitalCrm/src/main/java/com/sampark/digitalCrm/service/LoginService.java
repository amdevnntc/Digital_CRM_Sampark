package com.sampark.digitalCrm.service;

import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.object.ResponseObject;

public interface LoginService {
	
	
	public ResponseObject login(LoginEntity login)throws Exception;

}
