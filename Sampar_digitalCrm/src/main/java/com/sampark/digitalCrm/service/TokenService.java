package com.sampark.digitalCrm.service;

import java.util.List;
import com.sampark.digitalCrm.entity.TokenBean;

public interface TokenService {
	
	public String saveToken(TokenBean tokenBean) throws Exception;
	
	public TokenBean getToken(TokenBean tokenBean) throws Exception;
	
	public List<TokenBean> getTokenByEmployeeid(Integer employeeid) throws Exception;

}
