package com.sampark.digitalCrm.repositoryImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.common.TimezoneConverter;
import com.sampark.digitalCrm.entity.CommercialEntity;
import com.sampark.digitalCrm.entity.EnquiryEntity;
import com.sampark.digitalCrm.entity.EnquiryMeetingEntity;
import com.sampark.digitalCrm.entity.ResidentialEntity;
import com.sampark.digitalCrm.repository.EnquiryRepository;

@Repository
public class EnquiryRepositoryImpl  implements EnquiryRepository{
	
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}


	@Override
	@Transactional
	public Boolean saveEnquiry(EnquiryEntity EnquiryEntity) throws Exception {
		Boolean flag=null;
		
		
		if(EnquiryEntity.getId()!=null)
		{
			EnquiryEntity.setModifiedon(new Date());
			entityManager.merge(EnquiryEntity);
			if (EnquiryEntity.getId() > 0) {
				flag=true;
			} else {
				flag=false;
			}
			
		}
		else
		{
			entityManager.persist(EnquiryEntity);
			if (EnquiryEntity.getId() > 0) {
				flag=true;
			} else {
				flag=false;
			}
			
		}
		
		
		
		
		
		
		
		
		return flag;
	}

	@Override
	public List<EnquiryEntity> getEnquiry(Integer dealerId, Integer employeeid) throws Exception {
		List<EnquiryEntity> list = new ArrayList<EnquiryEntity>();
		if(employeeid!=null)
		{
			if(employeeid==0)
			{
				String sqlQuery = "select * from tbl_enquiry where dealer_id=:dealerId";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, EnquiryEntity.class);
				query.setParameter("dealerId", dealerId);
				list = (List<EnquiryEntity>) query.getResultList();
			}
			else
			{
				String sqlQuery = "select * from tbl_enquiry where dealer_id=:dealerId and employee_id=:employeeid";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, EnquiryEntity.class);
				query.setParameter("dealerId", dealerId);
				query.setParameter("employeeid", employeeid);
				list = (List<EnquiryEntity>) query.getResultList();
			}
		}
		return list;
	}


	@Override
	public List<ResidentialEntity> enquirySearchResidential(EnquiryEntity enquiryEntity) {
		List<ResidentialEntity> list=new ArrayList<ResidentialEntity>();
		Query query = null;
		if(enquiryEntity.getEmployeeid()==0)
		{
			String sqlQuery = "select * from tbl_residential where dealer_id=:dealerId and property_type=:propertytype and  locality=:locality and  area_Type=:areatype  and price_in=:pricein  and price between :pricemin and :pricemax and area between :areamin and :areamax";
			query = getEntityManager().createNativeQuery(sqlQuery, ResidentialEntity.class);
			query.setParameter("dealerId", enquiryEntity.getDealerid());
			query.setParameter("areatype", enquiryEntity.getAreain());
			query.setParameter("pricein", enquiryEntity.getPricein());
			query.setParameter("pricemin", enquiryEntity.getPriceMin());
			query.setParameter("pricemax", enquiryEntity.getPriceMax());
			query.setParameter("areamin", enquiryEntity.getAreaMin());
			query.setParameter("areamax", enquiryEntity.getAreaMax());
			query.setParameter("locality", enquiryEntity.getLocation());
			query.setParameter("propertytype",enquiryEntity.getPropertytype());
			 list = (List<ResidentialEntity>) query.getResultList();	
		}
		else
		{
			String sqlQuery = "select * from tbl_residential where dealer_id=:dealerId and employee_id=:employeeid and property_type=:propertytype and  locality=:locality and  area_Type=:areatype  and price_in=:pricein  and price between :pricemin and :pricemax and area between :areamin and :areamax";
			
			query = getEntityManager().createNativeQuery(sqlQuery, ResidentialEntity.class);
			query.setParameter("dealerId",enquiryEntity.getDealerid() );
			query.setParameter("employeeid",enquiryEntity.getEmployeeid());
			query.setParameter("areatype", enquiryEntity.getAreain());
			query.setParameter("pricein", enquiryEntity.getPricein());
			query.setParameter("pricemin", enquiryEntity.getPriceMin());
			query.setParameter("pricemax", enquiryEntity.getPriceMax());
			query.setParameter("areamin", enquiryEntity.getAreaMin());
			query.setParameter("areamax", enquiryEntity.getAreaMax());
			query.setParameter("locality", enquiryEntity.getLocation());
			query.setParameter("propertytype",enquiryEntity.getPropertytype());
			 list = (List<ResidentialEntity>) query.getResultList();
		}
		return list;
	}


	@Override
	public List<CommercialEntity> enquirySearchCommericial(EnquiryEntity enquiryEntity) {
		
		List<CommercialEntity> list=new ArrayList<CommercialEntity>();
		Query query = null;
		if(enquiryEntity.getEmployeeid()==0)
		{
			String sqlQuery = "select * from tbl_commercial where dealer_id=:dealerId and propertytype=:propertytype and  locality=:locality and  areatype=:areatype  and pricein=:pricein  and price between :pricemin and :pricemax and area between :areamin and :areamax";
			query = getEntityManager().createNativeQuery(sqlQuery, CommercialEntity.class);
			query.setParameter("dealerId", enquiryEntity.getDealerid());
			query.setParameter("areatype", enquiryEntity.getAreain());
			query.setParameter("pricein", enquiryEntity.getPricein());
			query.setParameter("pricemin", enquiryEntity.getPriceMin());
			query.setParameter("pricemax", enquiryEntity.getPriceMax());
			query.setParameter("areamin", enquiryEntity.getAreaMin());
			query.setParameter("areamax", enquiryEntity.getAreaMax());
			query.setParameter("locality", enquiryEntity.getLocation());
			query.setParameter("propertytype",enquiryEntity.getPropertytype());
			return list = (List<CommercialEntity>) query.getResultList();	
		}
		else
		{
			String sqlQuery = "select * from tbl_commercial where dealer_id=:dealerId and employee_id=:employeeid and propertytype=:propertytype and  locality=:locality and  areatype=:areatype  and pricein=:pricein  and price between :pricemin and :pricemax and area between :areamin and :areamax";		
			query = getEntityManager().createNativeQuery(sqlQuery, CommercialEntity.class);
			query.setParameter("dealerId",enquiryEntity.getDealerid() );
			query.setParameter("employeeid",enquiryEntity.getEmployeeid());
			query.setParameter("areatype", enquiryEntity.getAreain());
			query.setParameter("pricein", enquiryEntity.getPricein());
			query.setParameter("pricemin", enquiryEntity.getPriceMin());
			query.setParameter("pricemax", enquiryEntity.getPriceMax());
			query.setParameter("areamin", enquiryEntity.getAreaMin());
			query.setParameter("areamax", enquiryEntity.getAreaMax());
			query.setParameter("locality", enquiryEntity.getLocation());
			query.setParameter("propertytype",enquiryEntity.getPropertytype());
			return list = (List<CommercialEntity>) query.getResultList();
		}
	
	}


	@Override
	public List<ResidentialEntity> enquirySearchResidentialByAll(EnquiryEntity enquiryEntity) {
		List<ResidentialEntity> list=new ArrayList<ResidentialEntity>();
		Query query = null;
		if(enquiryEntity.getEmployeeid()==0)
		{
			String sqlQuery = "select * from tbl_residential where dealer_id=:dealerId and property_type=:propertytype";
			query = getEntityManager().createNativeQuery(sqlQuery, ResidentialEntity.class);
			query.setParameter("dealerId", enquiryEntity.getDealerid());
			query.setParameter("propertytype", enquiryEntity.getPropertytype());
		
			return list = (List<ResidentialEntity>) query.getResultList();	
		}
		else
		{
			String sqlQuery = "select * from tbl_residential where dealer_id=:dealerId and employee_id=:employeeid and property_type=:propertytype";
			
			query = getEntityManager().createNativeQuery(sqlQuery, ResidentialEntity.class);
			query.setParameter("dealerId", enquiryEntity.getDealerid());
			query.setParameter("employeeid", enquiryEntity.getEmployeeid());
			query.setParameter("propertytype", enquiryEntity.getPropertytype());
			
			return list = (List<ResidentialEntity>) query.getResultList();
		}
	}


	@Override
	public List<CommercialEntity> enquirySearchCommericialByAll(EnquiryEntity enquiryEntity) {
		
		List<CommercialEntity> list=new ArrayList<CommercialEntity>();
		Query query = null;
		if(enquiryEntity.getEmployeeid()==0)
		{
			String sqlQuery = "select * from tbl_commercial where dealer_id=:dealerId and propertytype=:propertytype";
			query = getEntityManager().createNativeQuery(sqlQuery, CommercialEntity.class);
			query.setParameter("dealerId", enquiryEntity.getDealerid());
			query.setParameter("propertytype", enquiryEntity.getPropertytype());
			return list = (List<CommercialEntity>) query.getResultList();	
		}
		else
		{
			String sqlQuery = "select * from tbl_commercial where dealer_id=:dealerId and employee_id=:employeeid and propertytype=:propertytype";		
			query = getEntityManager().createNativeQuery(sqlQuery, CommercialEntity.class);
			query.setParameter("dealerId", enquiryEntity.getDealerid());
			query.setParameter("employeeid", enquiryEntity.getEmployeeid());
			query.setParameter("propertytype", enquiryEntity.getPropertytype());
			
			return list = (List<CommercialEntity>) query.getResultList();
		}
	
	}

	@Override
	public EnquiryEntity getEnquiryDetails(Integer id) {
		EnquiryEntity enquiryEntity = new EnquiryEntity();
		
				String sqlQuery = "select * from tbl_enquiry where Id=:id";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, EnquiryEntity.class);
				query.setParameter("id", id);
				enquiryEntity = (EnquiryEntity) query.getSingleResult();
		
		return enquiryEntity;
	}


	@Override
	@Transactional
	public Boolean saveEnquiryMeeting(EnquiryMeetingEntity enquiryMeetingEntity) {
		
		if(enquiryMeetingEntity.getId()!=null && enquiryMeetingEntity.getId()>0)
		{
			entityManager.merge(enquiryMeetingEntity);
		}
		else
		{
			   entityManager.persist(enquiryMeetingEntity);
	           updateMeetingStatus(enquiryMeetingEntity.getEnquiryId());
		}
        
		return true;
	}

    @Transactional
	private void updateMeetingStatus(Integer enquiryId)
	{
    	Query query = null;
    	query=entityManager.createNativeQuery("update tbl_enquiry set meeting_Status=:meetingStatus where Id=:id");
    	query.setParameter("meetingStatus", digitalCrmConstant.STATUS_ACTIVE);
    	query.setParameter("id",enquiryId);
        Integer i=query.executeUpdate();
        
	}
	@Override
	public List<EnquiryMeetingEntity> listEnquiryMeeting(Integer dealerId, Integer employeeId) {
		List<EnquiryMeetingEntity> list = new ArrayList<EnquiryMeetingEntity>();
		Query query = null;
		String sqlQuery = "select * from tbl_enquiry_meeting where dealer_Id=:dealerId";
		if(employeeId==0)
		{
			query = getEntityManager().createNativeQuery(sqlQuery, EnquiryMeetingEntity.class);
			query.setParameter("dealerId", dealerId);
			list = (List<EnquiryMeetingEntity>) query.getResultList();

		}
		else
		{
			query = getEntityManager().createNativeQuery("select * from tbl_enquiry_meeting where dealer_Id=:dealerId and employee_Id=:employeeId", EnquiryMeetingEntity.class);
			query.setParameter("dealerId", dealerId);
			query.setParameter("employeeId", employeeId);
			list = (List<EnquiryMeetingEntity>) query.getResultList();
		}
       return list;
}

	@Override
	public List<EnquiryMeetingEntity> getAllEnquiryMeeting() {
		List<EnquiryMeetingEntity> list = new ArrayList<EnquiryMeetingEntity>();
		Date convertedtime = TimezoneConverter.getDate(new Date());
		SimpleDateFormat localDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = localDateFormat.format(convertedtime);
		 Query query = null;
		String sqlQuery = "select * from tbl_enquiry_meeting  where meeting_Date=:meetingDate and reminder_Status=:reminderStatus";
		query = getEntityManager().createNativeQuery(sqlQuery, EnquiryMeetingEntity.class);
		query.setParameter("meetingDate",date);
		query.setParameter("reminderStatus", digitalCrmConstant.STATUS_DEACTIVE);
		
		list = (List<EnquiryMeetingEntity>) query.getResultList(); 
		
       return list;

		
	}

}
