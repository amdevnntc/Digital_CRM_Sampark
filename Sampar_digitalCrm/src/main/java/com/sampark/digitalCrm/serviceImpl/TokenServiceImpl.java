package com.sampark.digitalCrm.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.entity.TokenBean;
import com.sampark.digitalCrm.repository.TokenRepository;
import com.sampark.digitalCrm.service.TokenService;


@Service
public class TokenServiceImpl implements TokenService {
	
	
	@Autowired
	TokenRepository tokenrepo;
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	@Transactional
	public String saveToken(TokenBean tokenBean) throws Exception {
		TokenBean  tokenBean1 = new TokenBean();	
		tokenBean1=tokenrepo .getToken(tokenBean);
		if(tokenBean1!=null)
		{
			tokenBean1.setToken(tokenBean.getToken());
			return tokenrepo.saveToken(tokenBean1);
		}
		else
		{
			
			return tokenrepo.saveToken(tokenBean);
		}
		
	}

	@Override
	public TokenBean getToken(TokenBean tokenBean) throws Exception {
		
		
		return tokenBean;
		
		
		
	}

	@Override
	public List<TokenBean> getTokenByEmployeeid(Integer dealerid) throws Exception {
		// TODO Auto-generated method stub
		return tokenrepo.getTokenByEmployeeid(dealerid);
	}

	
	

}
