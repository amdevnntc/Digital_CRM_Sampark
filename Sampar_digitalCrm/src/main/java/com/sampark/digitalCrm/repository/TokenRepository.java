package com.sampark.digitalCrm.repository;

import java.util.List;

import com.sampark.digitalCrm.entity.BadgeEntity;
import com.sampark.digitalCrm.entity.TokenBean;




public interface TokenRepository {
	
	public String saveToken(TokenBean tokenBean) throws Exception;
	
	public TokenBean getToken(TokenBean tokenBean) throws Exception;
	public List<TokenBean> getTokenByEmployeeid(Integer employeeid) throws Exception;
	public List<TokenBean> getTokenByDealrid(Integer dealerId) throws Exception;
	
	public Boolean saveBadge(BadgeEntity badgeEntity);
	
	public BadgeEntity badgeDetails(Integer dealerId,Integer employeeId);
	

}
