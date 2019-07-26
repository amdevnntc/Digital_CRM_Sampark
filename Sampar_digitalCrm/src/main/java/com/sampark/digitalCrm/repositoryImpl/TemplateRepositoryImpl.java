package com.sampark.digitalCrm.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.entity.TemplateEntity;
import com.sampark.digitalCrm.repository.TemplateRepository;

@Repository
public class TemplateRepositoryImpl  implements TemplateRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}



	@Override
	@Transactional
	public TemplateEntity saveTemplate(TemplateEntity template) {
		entityManager.persist(template);
		return template;
	}

	@Override
	public List<TemplateEntity> templateList(Integer dealerId, Integer employeeid) {
		// TODO Auto-generated method stub
		return null;
	}

}
