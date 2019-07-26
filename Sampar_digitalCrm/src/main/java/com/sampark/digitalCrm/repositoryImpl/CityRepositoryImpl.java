package com.sampark.digitalCrm.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.entity.CityEntity;
import com.sampark.digitalCrm.entity.SectorEntity;
import com.sampark.digitalCrm.repository.CityRepository;

@Repository
public class CityRepositoryImpl implements CityRepository {

	private static final Logger logger = Logger.getLogger(CityRepositoryImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	@Transactional
	public Boolean saveCity(CityEntity register) throws Exception {
		Boolean flag = null;

		if (register.getCityid() != null) {
			entityManager.merge(register);
			flag = true;
		} else {
			entityManager.persist(register);
			flag = true;

		}
		return flag;
	}

	@Override
	public Boolean isCityExist(String sector) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> getCityList() {
		List<CityEntity> list = new ArrayList<CityEntity>();
		logger.info("getting list of Cities  ");
		String sqlQuery = "select * from city where status='1' order by ID DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, CityEntity.class);
		list = (List<CityEntity>) query.getResultList();
		return list;
	}

}
