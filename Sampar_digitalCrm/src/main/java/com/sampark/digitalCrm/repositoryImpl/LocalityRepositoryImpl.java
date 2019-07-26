package com.sampark.digitalCrm.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.entity.LocalityEntity;
import com.sampark.digitalCrm.entity.SocietyEntity;
import com.sampark.digitalCrm.repository.LocalityRepository;

@Repository
public class LocalityRepositoryImpl implements LocalityRepository {

	private static final Logger logger = Logger.getLogger(LocalityRepositoryImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	@Transactional
	public Boolean saveLocality(LocalityEntity register) throws Exception {
		Boolean flag = null;

		if (register.getLocalityid() != null) {
			entityManager.merge(register);
			flag = true;
		} else {
			entityManager.persist(register);
			flag = true;

		}
		return flag;
	}

	@Override
	public Boolean islocalityExist(String locality) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocalityEntity> getLocalityList(Integer cityid) throws Exception {
		List<LocalityEntity> list = new ArrayList<LocalityEntity>();
		String sqlQuery = "select * from locality where cityid =:cityid and status='1' order by ID DESC ";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, LocalityEntity.class);
		query.setParameter("cityid", cityid);
		list = (List<LocalityEntity>) query.getResultList();
		return list;
	}

}
