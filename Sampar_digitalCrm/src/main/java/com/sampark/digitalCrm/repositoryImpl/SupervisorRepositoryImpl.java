package com.sampark.digitalCrm.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.repository.SupervisorRepository;


@Repository
public class SupervisorRepositoryImpl implements SupervisorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public ClientEntity getSupervisorById(String supervisorId) {
		ClientEntity bean = new ClientEntity();

		bean = getEntityManager().find(ClientEntity.class, supervisorId);

		return bean;
	}

	@Override
	public List<ClientEntity> searchSupervisorName(String name) {
		List<ClientEntity> list = new ArrayList<ClientEntity>();
		String sqlQuery = "Select * from device_master where dev_type like :type";

		Query query = null;
		try {
			try {
				query = getEntityManager().createNativeQuery(sqlQuery, ClientEntity.class);
				query.setParameter("name", "%"+name+"%");
				list = (List) query.getResultList();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public Boolean addSupervisor(ClientEntity bean) {
Boolean flag = false;
		
		getEntityManager().persist(bean);
		
		flag = true;

		return flag;
	}

	@Override
	@Transactional
	public Boolean updateSupervisor(ClientEntity bean) {
        Boolean flag = false;
		
		getEntityManager().merge(bean);
		
		flag = true;

		return flag;
	
	}

	@Override
	public List<ClientEntity> getAll() throws Exception {
		List<ClientEntity> list= new ArrayList<>();
		
		String sqlQuery="select * from supervisior_master";
		
		Query query=null;
		try {
			try {
		query= getEntityManager().createNativeQuery(sqlQuery, ClientEntity.class);
		
		list = query.getResultList();

		
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
