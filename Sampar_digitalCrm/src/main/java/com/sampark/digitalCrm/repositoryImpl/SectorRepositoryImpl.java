package com.sampark.digitalCrm.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.entity.SectorEntity;
import com.sampark.digitalCrm.repository.SectorRepository;

@Repository
public class SectorRepositoryImpl implements SectorRepository{
	
	private static final Logger logger = Logger.getLogger(SectorRepositoryImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	@Transactional
	public Boolean saveSector(SectorEntity register) throws Exception {
		Boolean flag=null;
	
		if(register.getSectorid()!=null)
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
	public Boolean isSectorExist(String sector) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<SectorEntity> getSectorList() {
		List<SectorEntity> list = new ArrayList<SectorEntity>();
		     logger.info("getting list of sector ");
				String sqlQuery = "select * from sector where status='1' order by ID DESC";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, SectorEntity.class);
				list = (List<SectorEntity>) query.getResultList();

		return list;
	}


	}


