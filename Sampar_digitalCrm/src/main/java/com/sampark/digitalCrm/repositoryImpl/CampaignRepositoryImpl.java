package com.sampark.digitalCrm.repositoryImpl;

import java.text.Format;
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
import com.sampark.digitalCrm.entity.CampaignEntity;
import com.sampark.digitalCrm.entity.TemplateEntity;
import com.sampark.digitalCrm.message.SendMessage;
import com.sampark.digitalCrm.repository.CampaignRepository;
@Repository
public class CampaignRepositoryImpl implements CampaignRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}


	@Override
	@Transactional
	public Boolean saveCampaign(CampaignEntity campaignEntity) throws Exception {
		Boolean flag=null;
	
		if(campaignEntity.getId()!=null)
		{
			entityManager.merge(campaignEntity);
			flag=true;
		}
		else
		{
			entityManager.persist(campaignEntity);
			/* if(campaignEntity.getNotifiyBy().equals("0"))
			 {
				 Iterator<String> it=campaignEntity.getMobile().iterator();
					
					while (it.hasNext()) {
						String mobile=it.next();
						SendMessage.msg(mobile, "Title :"+campaignEntity.getName()+ "Description"+campaignEntity.getDescription());
					}
			 }*/
			/* else if(notifiyby.equals("1"))
			 {
				 campaign.setEmail(email);
			 }
			 else
			 {
				 campaign.setMobile(mobile); 
				 campaign.setEmail(email);
			 }
		*/
			
			
			
			if (campaignEntity.getId() > 0) {
				flag=true;
			} else {
				flag=false;
			}
		}
		return flag;
	}

	@Override
	public List<CampaignEntity> getCampaign(Integer dealerId, Integer employeeid) throws Exception {
		List<CampaignEntity> list = new ArrayList<CampaignEntity>();
		if(employeeid!=null)
		{
			if(employeeid==0)
			{
				String sqlQuery = "select * from tbl_campaign where dealer_id=:dealerId  ORDER BY CREATED_ON DESC";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, CampaignEntity.class);
				query.setParameter("dealerId", dealerId);
				list = (List<CampaignEntity>) query.getResultList();
			}
			else
			{
				String sqlQuery = "select * from tbl_campaign where dealer_id=:dealerId and employee_id=:employeeid ORDER BY CREATED_ON DESC";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, CampaignEntity.class);
				query.setParameter("dealerId", dealerId);
				query.setParameter("employeeid", employeeid);
				list = (List<CampaignEntity>) query.getResultList();
			}
		}
		return list;
	}


	@Override
	public TemplateEntity getTemplate(Integer templateId) throws Exception {
		TemplateEntity template = new TemplateEntity();
		
			String sqlQuery = "select * from tbl_template where Id=:templateId";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, TemplateEntity.class);
				query.setParameter("templateId", templateId);
				template = (TemplateEntity) query.getSingleResult();
			
		return template;
	}


	@Override
	public List<TemplateEntity> getTemplateList() throws Exception {
		List<TemplateEntity> list = new ArrayList<TemplateEntity>();
		Date converteddate=TimezoneConverter.getDate(new Date());
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String s = formatter.format(converteddate);
				String sqlQuery = "select * from tbl_template where end_date >=:date";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, TemplateEntity.class);
				query.setParameter("date",s);
				list = (List<TemplateEntity>) query.getResultList();
			
		return list;
	}

}
