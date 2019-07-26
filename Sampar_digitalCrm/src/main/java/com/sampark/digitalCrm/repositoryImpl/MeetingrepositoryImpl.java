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

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.common.TimezoneConverter;
import com.sampark.digitalCrm.entity.MeetingEmployeeEntity;
import com.sampark.digitalCrm.entity.MeetingEntity;
import com.sampark.digitalCrm.entity.PropertyEntity;
import com.sampark.digitalCrm.repository.Meetingrepository;
@Repository
public class MeetingrepositoryImpl  implements Meetingrepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	Date converteddate1=TimezoneConverter.getDate(new Date());
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
    String strDate= formatter.format(converteddate1);  

	@Override
	@Transactional
	public Boolean saveMeeting(MeetingEntity meeting) throws Exception {
		Boolean flag=null;
		if(meeting.getId()!=null)
		{
			meeting.setReminderStatus(digitalCrmConstant.STATUS_DEACTIVE);
			entityManager.merge(meeting);
			flag=true;
		}
		else
		{
			entityManager.persist(meeting);
			List<Integer> list=meeting.getEmployeeids();
			Iterator<Integer> it=list.iterator();
			MeetingEmployeeEntity meetingemployee;
			while (it.hasNext()) {
				Integer empid=it.next();
				meetingemployee=new MeetingEmployeeEntity();
				meetingemployee.setEmployeeid(empid);
				meetingemployee.setMeetingid(meeting.getId());
				meetingemployee.setEnabled(digitalCrmConstant.STATUS_ACTIVE);
				meetingemployee.setEmployeeMeetingStatus(digitalCrmConstant.STATUS_ACTIVE);
				meetingemployee.setDealerid(meeting.getDealerid());
				meetingemployee.setMeetingDate(meeting.getMeetingdate());
				entityManager.persist(meetingemployee);
			}
			if(meeting.getId()>0)
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
		}
		
		return flag;
	}
	@Override
	public MeetingEntity getMeetingList(Integer meetingid,Integer employeeid,Integer dealerid) throws Exception {
		
		MeetingEntity bean = new MeetingEntity();
		if(meetingid!=null)
		{
			if(employeeid==0)
			{
				String sqlQuery = "select * from client_meeting where ID=:meetingid and dealer_id=:dealerid and ENABLED='1' ORDER BY ID DESC";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, MeetingEntity.class);
				query.setParameter("meetingid", meetingid);
				query.setParameter("dealerid", dealerid);
				bean = (MeetingEntity) query.getSingleResult();	
				return bean;
			}
			else
			{
				String sqlQuery = "select * from client_meeting where ID=:meetingid and employee_id=:employeeid";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, MeetingEntity.class);
				query.setParameter("meetingid", meetingid);
				query.setParameter("employeeid", employeeid);
				try {
					bean = (MeetingEntity) query.getSingleResult();	
					return bean;
				} catch (Exception e)
				{
					return bean;
				}
				
				
			}
		}
		else
		{
			String sqlQuery = "select * from client_meeting where meeting_date=:meetingdate and reminder_status=:reminderstatus and ENABLED='1'";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery, MeetingEntity.class);
			query.setParameter("reminderstatus",digitalCrmConstant.STATUS_DEACTIVE);
            query.setParameter("meetingdate",strDate);
            bean = (MeetingEntity) query.getSingleResult();	
			return bean;
		}
		
		
	}

	@Override
	@Transactional
	public Boolean cancleMeeting(Integer meetingid,Integer employeeid,Integer dealerid) {
		Query query = null;
		if(employeeid.equals(0))
		{
			String sqlQuery = "update client_meeting set ENABLED='0' where ID=:meetingid";
			String sqlQuery1 = "update meeting_emplyee_mapping  set ENABLED='0' where meeting_id=:meetingid";
			query = getEntityManager().createNativeQuery(sqlQuery);
			query = getEntityManager().createNativeQuery(sqlQuery1);
			query.setParameter("meetingid",meetingid);
		}
		else
		{
			String sqlQuery = "update meeting_emplyee_mapping  set employee_meeting_status='0' where meeting_id=:meetingid and employee_id=:employeeid";
			query = getEntityManager().createNativeQuery(sqlQuery);
			query.setParameter("meetingid",meetingid);
			query.setParameter("employeeid", employeeid);
		}
		int i=query.executeUpdate();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean updateReminder(MeetingEntity meeting) {
		Boolean flag=null;
		if(meeting.getId()!=null)
		{
			meeting.setReminderStatus(digitalCrmConstant.STATUS_ACTIVE);
			entityManager.merge(meeting);
			flag=true;
		}
		
		return flag;
	}

	@Override
	public List<Integer> getmeetingIdByEmployeeId(Integer employeeid, Integer dealerid) {
		
		List<Integer> list=new ArrayList<Integer>();
        
		if(employeeid.equals(0))
		{
			String sqlQuery = "select DISTINCT meeting_id from meeting_emplyee_mapping where dealer_id=:dealerid and ENABLED='1' ORDER BY meeting_id DESC";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery);
			query.setParameter("dealerid",dealerid);
			list = (List<Integer>) query.getResultList();	
			return list;	
		}
		else
		{
			String sqlQuery = "select DISTINCT meeting_id from meeting_emplyee_mapping where employee_id=:employeeid and dealer_id=:dealerid and ENABLED='1' and employee_meeting_status='1' ORDER BY meeting_id DESC";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery);
			query.setParameter("employeeid",employeeid);
			query.setParameter("dealerid",dealerid);
			list = (List<Integer>) query.getResultList();	
			return list;
		}
		
	}

	@Override
	public List<Integer> getEmployeeIdByMeetingId(Integer meetingid) {
		List<Integer> list=new ArrayList<Integer>();
		String sqlQuery = "select employee_id  from meeting_emplyee_mapping where meeting_id=:meetingid and ENABLED='1'";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery);
		query.setParameter("meetingid",meetingid);
		list = (List<Integer>) query.getResultList();	
		return list;	
	}
	@Override
	public List<MeetingEntity> getAllMeetingList() throws Exception {
		
		List<MeetingEntity> list=new ArrayList<MeetingEntity>();
		String sqlQuery = "select * from client_meeting where ENABLED='1'";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, MeetingEntity.class);
		list = (List<MeetingEntity>) query.getResultList();	
		return list;
}
	@Override
	public List<Integer> gettodaymeetingIdByEmployeeId(Integer employeeid, Integer dealerid) {
		
		List<Integer> list=new ArrayList<Integer>();
        
		if(employeeid.equals(0))
		{
			String sqlQuery = "select DISTINCT meeting_id from meeting_emplyee_mapping where  meeting_date=:meeting_date and dealer_id=:dealerid and ENABLED='1' ORDER BY meeting_id DESC";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery);
			query.setParameter("dealerid",dealerid);
			query.setParameter("meeting_date",strDate);
			list = (List<Integer>) query.getResultList();	
			return list;	
		}
		else
		{
			String sqlQuery = "select DISTINCT meeting_id from meeting_emplyee_mapping where  meeting_date=:meeting_date and  employee_id=:employeeid and dealer_id=:dealerid and ENABLED='1' and employee_meeting_status='1' ORDER BY meeting_id DESC";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery);
			query.setParameter("employeeid",employeeid);
			query.setParameter("dealerid",dealerid);
			query.setParameter("meeting_date",strDate);
			list = (List<Integer>) query.getResultList();	
			return list;
		}
		
	}
}
