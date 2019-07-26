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

import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.common.TimezoneConverter;
import com.sampark.digitalCrm.entity.BulkSmsEntity;
import com.sampark.digitalCrm.message.SendMessage;
import com.sampark.digitalCrm.repository.BulkSmsRepository;

@Repository
public class BulkSmsRepositoryImpl implements BulkSmsRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
    
	
	
    
	@Override
	@Transactional
	public Boolean saveSms(BulkSmsEntity smsEntity) {
		
		BulkSmsEntity bulksms=null;
		Iterator<String> it=smsEntity.getContacts().iterator();
		while (it.hasNext()) {
			bulksms=new BulkSmsEntity();
			String contatct=it.next();
			bulksms.setContact(contatct);
			bulksms.setCreatedOn(smsEntity.getCreatedOn());
			bulksms.setDealerid(smsEntity.getDealerid());
			bulksms.setEmployeeid(smsEntity.getEmployeeid());
			bulksms.setEnabled(1);
			bulksms.setModifiedon(smsEntity.getModifiedon());
			bulksms.setMessage(smsEntity.getMessage());
			entityManager.persist(bulksms);
			SendMessage.msg(contatct,smsEntity.getMessage());
		}
		
		if(bulksms.getId()>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public List<BulkSmsEntity> getSmsList(Integer dealerId, Integer employeeid,String date) {
		List<BulkSmsEntity> list = new ArrayList<BulkSmsEntity>();
		
		if(employeeid!=null)
		{
			if(employeeid==0)
			{
				String sqlQuery = "select * from sms_details where dealer_id=:dealerId and CREATED_ON LIKE:createdon";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, BulkSmsEntity.class);
				query.setParameter("dealerId", dealerId);
				query.setParameter("createdon","%"+date+"%");
				list = (List<BulkSmsEntity>) query.getResultList();
				
			}
			else
			{
				String sqlQuery = "select * from sms_details where dealer_id=:dealerId and employee_id=:employeeid and CREATED_ON LIKE:createdon";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, BulkSmsEntity.class);
				query.setParameter("dealerId", dealerId);
				query.setParameter("employeeid",employeeid);
				query.setParameter("createdon","%"+date+"%");
				list = (List<BulkSmsEntity>) query.getResultList();
			}
		}
		return list;
	}

}
