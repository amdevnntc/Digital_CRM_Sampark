package com.sampark.digitalCrm.repositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.repository.Loginrepository;
@Repository
public class LoginrepositoryImpl  implements Loginrepository{

	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	@Override
	public LoginEntity login(LoginEntity login) throws Exception {
		Boolean found = null;
		LoginEntity loginEntity = new LoginEntity();
		String sqlQuery = "select * from users where username=:username and password=:password";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, LoginEntity.class);
		query.setParameter("username",login.getUsername());
		query.setParameter("password",login.getPassword());
		try {
			loginEntity = (LoginEntity) query.getSingleResult();
				return loginEntity;
		} catch (Exception e) {
			return loginEntity;
		}
		
		
	}

}
