package com.sampark.digitalCrm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.Loginrepository;
import com.sampark.digitalCrm.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	
	
	@Autowired 
	Loginrepository loginrepo;

	@Override
	public ResponseObject login(LoginEntity login) throws Exception {
		LoginEntity loginEntity = new LoginEntity();
		ResponseObject rsobj=new ResponseObject();
		loginEntity=loginrepo.login(login);
		if (loginEntity.getId()!=null) 
		{
			rsobj=new ResponseObject();
			rsobj.setObject(loginEntity);
			rsobj.setStatus(true);
			rsobj.setMessage("Login Success");
		} 
		else
		{
			rsobj.setStatus(false);
			rsobj.setMessage("Wrong username or password");
		}
		return rsobj;
	}
 
}
