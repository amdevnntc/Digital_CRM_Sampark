package com.sampark.digitalCrm.repositoryImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.entity.EmployeeNotes;
import com.sampark.digitalCrm.repository.ClientRepository;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

	private static final Logger logger = Logger.getLogger(ClientRepositoryImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	@Transactional
	public Boolean saveClient(ClientEntity register) throws Exception {
		Boolean flag=null;
	
		if(register.getId()!=null)
		{
			register.setModifiedon(new Date());
			entityManager.merge(register);
			flag=true;
		}
		else
		{
			entityManager.persist(register);
			if (register.getId() > 0) {
				flag=true;
			} else {
				flag=false;
			}
		}
		return flag;
	}

	@Override
	public Boolean isUserExist(String mobile) throws Exception {
		Boolean found = null;
		ClientEntity registerEntity = new ClientEntity();
		String sqlQuery = "select * from clientdetails where mobile=:mobile";
		Query query = null;

		try {
			query = getEntityManager().createNativeQuery(sqlQuery, ClientEntity.class);
			query.setParameter("mobile",mobile);
			registerEntity=(ClientEntity) query.getSingleResult();
			System.out.println(registerEntity);
			logger.info("Result Found"+ registerEntity);
			logger.info("sdjfkfdkjhfjkhdfkj");
			found=true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("No Result Found", e);
			found=false;
		}
		return found;

	}

	@Override
	public LoginEntity getCurrentUserid(String username) {
		
		LoginEntity loginEntity = new LoginEntity();
		String sqlQuery = "select * from users where username=:username";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, LoginEntity.class);
		query.setParameter("username", username);
		loginEntity = (LoginEntity) query.getSingleResult();
		return loginEntity;
	}
	@Override
	public List<ClientEntity> getClientList(Integer dealerId,Integer employeeid) throws Exception {
		List<ClientEntity> list = new ArrayList<ClientEntity>();
		
		if(employeeid!=null)
		{
			if(employeeid==0)
			{
				String sqlQuery = "select * from clientdetails where dealer_id=:dealerId";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, ClientEntity.class);
				query.setParameter("dealerId", dealerId);
				list = (List<ClientEntity>) query.getResultList();
				
			}
			else
			{
				String sqlQuery = "select * from clientdetails where dealer_id=:dealerId and employee_id=:employeeid";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, ClientEntity.class);
				query.setParameter("dealerId", dealerId);
				query.setParameter("employeeid", employeeid);
				list = (List<ClientEntity>) query.getResultList();
			}
		}
		else
		{
			Date date = new Date();  
			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");  
			String strDate= formatter.format(date); 
			System.out.println(strDate);
			String sqlQuery = "select * from clientdetails where dob LIKE:dob or anniversary LIKE:anniversary";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery, ClientEntity.class);
			query.setParameter("dob","%"+strDate+"%");
			query.setParameter("anniversary","%"+strDate+"%");
			list = (List<ClientEntity>) query.getResultList();
		}
		return list;
	}

	@Override
	@Transactional
	public ResponseObject saveClientBulk(List<ClientEntity> clientEntity) throws Exception {
		ResponseObject rsobj=new ResponseObject();
		Iterator<ClientEntity> it=clientEntity.iterator();
		while (it.hasNext()) {
			ClientEntity client=new ClientEntity();
			client=it.next();
			client.setEnabled(1);
			entityManager.persist(client);
			if(client.getId()>0)
			{
				rsobj.setStatus(true);
				rsobj.setMessage("SuccessFully Uploaded");
				
			}
			else
			{
				rsobj.setStatus(false);
				rsobj.setMessage("Failed");
			}
		}
		
		return rsobj;
	}

	@Override
	public ClientEntity getDetails(Integer clientid) {
		ClientEntity client = new ClientEntity();
		String sqlQuery = "select * from clientdetails where ID=:clientid";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, ClientEntity.class);
		query.setParameter("clientid", clientid);
		client = (ClientEntity) query.getSingleResult();
		return client;
	}

	@Override
	@Transactional
	public Boolean saveNotes(EmployeeNotes clientNotes) {
		Boolean flag=null;
		
		if(clientNotes.getId()!=null)
		{
			clientNotes.setModifiedon(new Date());
			entityManager.merge(clientNotes);
			flag=true;
		}
		else
		{
			entityManager.persist(clientNotes);
			if (clientNotes.getId() > 0) {
				flag=true;
			} else {
				flag=false;
			}
		}
		return flag;
	}

	@Override
	public List<EmployeeNotes> notesList(Integer clientid,Integer dealerId,Integer employeeid) {
		List<EmployeeNotes> client = new ArrayList<EmployeeNotes>();
			String sqlQuery = "select * from employee_notes where client_id=:clientid and dealer_id=:dealerid ORDER BY ID DESC";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery, EmployeeNotes.class);
			query.setParameter("clientid", clientid);
			query.setParameter("dealerid", dealerId);
			client = (List<EmployeeNotes>) query.getResultList();
		return client;
	}

	@Override
	public List<ClientEntity> clientListByType(Integer dealerId, Integer employeeid, String type) {
		List<ClientEntity> list = new ArrayList<ClientEntity>();

		if(employeeid==0)
		{
			String sqlQuery = "select * from clientdetails where dealer_id=:dealerId and client_Type=:clientType ";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery, ClientEntity.class);
			query.setParameter("dealerId", dealerId);
			query.setParameter("clientType", type);
			list = (List<ClientEntity>) query.getResultList();
		}
		else
		{
			String sqlQuery = "select * from clientdetails where dealer_id=:dealerId and employee_id=:employeeid and client_Type=:clientType";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery, ClientEntity.class);
			query.setParameter("dealerId", dealerId);
			query.setParameter("employeeid", employeeid);
			query.setParameter("clientType", type);
			list = (List<ClientEntity>) query.getResultList();
		}
		return list;
	}


}
