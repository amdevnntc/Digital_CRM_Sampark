package com.sampark.digitalCrm.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.entity.BulkSmsEntity;
import com.sampark.digitalCrm.entity.SectorEntity;
import com.sampark.digitalCrm.entity.SocietyEntity;
import com.sampark.digitalCrm.repository.SocietyRepository;

@Repository
public class SocietyRepositoryImpl implements SocietyRepository {

	private static final Logger logger = Logger.getLogger(SocietyRepositoryImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	@Transactional
	public Boolean saveSociety(SocietyEntity register) throws Exception {
		Boolean flag=null;
	
		if(register.getSocietyid()!=null)
		{
			entityManager.merge(register);
			flag=true;
		}
		else
		{
			entityManager.persist(register);
			flag=true;
			
		}
		return flag;
	}

	@Override
	public Boolean isSocietyExist(String society) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<SocietyEntity> getSocietyList(Integer sectorId) throws Exception{
		List<SocietyEntity> list = new ArrayList<SocietyEntity>();
		String sqlQuery = "select * from society where sector_Id =:sectorId and status='1' order by ID DESC ";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, SocietyEntity.class);
		query.setParameter("sectorId", sectorId);
		list = (List<SocietyEntity>) query.getResultList();
		return list;
	}
	

}
