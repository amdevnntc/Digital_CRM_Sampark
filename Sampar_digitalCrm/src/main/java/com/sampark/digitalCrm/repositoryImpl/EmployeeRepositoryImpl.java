package com.sampark.digitalCrm.repositoryImpl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.common.TimezoneConverter;
import com.sampark.digitalCrm.entity.DealerEntity;
import com.sampark.digitalCrm.entity.EmployeeEntity;
import com.sampark.digitalCrm.entity.EmployeeTask;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.entity.TaskRepeat;
import com.sampark.digitalCrm.repository.EmployeeRepository;
import com.sampark.digitalCrm.util.EncryptionUtils;
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	
	
	Date converteddate1=TimezoneConverter.getDate(new Date());
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
    String strDate= formatter.format(converteddate1);  
    
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	Date converteddate=TimezoneConverter.getDate(new Date());
	@Override
	@Transactional
	public Boolean saveEmployee(EmployeeEntity employee) throws Exception {
		Boolean flag=null;
		
		if(employee.getId()!=null)
		{
			entityManager.merge(employee);
			flag=true;
		}
		else
		{
			entityManager.persist(employee);
			if (employee.getId() > 0) {
				flag=true;
				createLogin(employee);
			} else {
				flag=false;
			}
		}
		return flag;
	}
	private  Boolean createLogin(EmployeeEntity employee) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
	{
		LoginEntity login=new LoginEntity();
		login.setUsername(employee.getMobile());
		login.setEnabled(digitalCrmConstant.STATUS_ACTIVE);
		login.setCreatedOn(converteddate);
		login.setModifiedon(converteddate);
		String password=EncryptionUtils.encryptPropertyValue(employee.getMobile());
		login.setPassword(employee.getMobile());
		login.setRoleid(6);
		login.setEmployeeid(employee.getId());
		login.setDealerIid(employee.getDealerid());
		login.setName(employee.getName());
		entityManager.persist(login);
		//SendMessage.otp(employee.getMobile(),employee.getMobile());
		return true;
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> employeeList(Integer dealerid) {
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		String sqlQuery = "select * from employeedetails where dealer_id=:dealerId and ENABLED='1' ORDER BY ID DESC";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery, EmployeeEntity.class);
			query.setParameter("dealerId", dealerid);
			list = (List<EmployeeEntity>) query.getResultList();	
	
		return list;
	}
	
	
	
	@Override
	@Transactional
	public Boolean saveTask(EmployeeTask employeeTask) {
		Boolean flag=null;
		TaskRepeat taskRepeat=null;
		if(employeeTask.getId()!=null)
		{
			entityManager.merge(employeeTask);
			flag=true;
		}
		else
		{
			entityManager.persist(employeeTask);
			if(employeeTask.getRepeatType().equalsIgnoreCase("Weekly"))
			{
				/*String days1="Monday,Tuesday,Wednesday,Thrusday,Friday,Saturday";
					String [] days2 =days1.split(",");
					List<String> dayslist = Arrays.asList(days2);
					employeeTask.setRepeatDays(dayslist);
				*/	
				
				Iterator<String> it=employeeTask.getRepeatDays().iterator();
				while (it.hasNext()) 
				{
					String days=it.next();
					taskRepeat=new TaskRepeat();
					taskRepeat.setCreatedOn(new Date());
					taskRepeat.setEnabled(digitalCrmConstant.STATUS_ACTIVE);
					taskRepeat.setModifiedon(new Date());
					taskRepeat.setRepeat(days);
					taskRepeat.setTaskId(employeeTask.getId());
					entityManager.persist(taskRepeat);
				}
				if (employeeTask.getId() > 0) {
					flag=true;
				} else {
					flag=false;
				}
			}
			else
			{
				if (employeeTask.getId() > 0) {
					flag=true;
				} else {
					flag=false;
				}
			}
		}
		return flag;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeTask> employeeTaskList(Integer dealerid, Integer employeeId) {
		List<EmployeeTask> list = new ArrayList<EmployeeTask>();
		if(employeeId!=null)
		{
			if(employeeId==0)
			{
				String sqlQuery = "select * from employee_task where employee_id=:employeeId and ENABLED='1' or  ENABLED='2' ORDER BY ID DESC";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, EmployeeTask.class);
				query.setParameter("employeeId", employeeId);
				list = (List<EmployeeTask>) query.getResultList();
			}
			else
			{

				String sqlQuery = "select * from employee_task where employee_id=:employeeId  and ENABLED='1' or ENABLED='2' ORDER BY ID DESC";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, EmployeeTask.class);
				query.setParameter("employeeId",employeeId);
				list = (List<EmployeeTask>) query.getResultList();
			}
		}
		else
		{
			String sqlQuery = "select * from employee_task where task_Date=:taskdate or all_Days='1' and  ENABLED='1' ORDER BY ID DESC";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery, EmployeeTask.class);
			query.setParameter("taskdate",strDate);
			list = (List<EmployeeTask>) query.getResultList();
		}
		return list;
	}
	@Override
	public EmployeeEntity employeeDetails(Integer empid,String type) throws Exception {
		
		
			String sqlQuery = "select * from employeedetails where ID=:empid";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery, EmployeeEntity.class);
			query.setParameter("empid",empid);
			EmployeeEntity bean = (EmployeeEntity) query.getSingleResult();	
			return bean;

	}
	

	@Override
       public DealerEntity dealerDetails(Integer empid,String type) {
			String sqlQuery = "select * from dealers where ID=:empid ORDER BY ID DESC";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery, DealerEntity.class);
			query.setParameter("empid",empid);
			DealerEntity bean = (DealerEntity) query.getSingleResult();
			return bean;
	}
	@Override
	@Transactional
	public Boolean completeTask(Integer taskid,String type) {
		
		String enable=null;
		if(type.equalsIgnoreCase("complete")||type.equalsIgnoreCase("cancle"))
		{
			enable="0";
		}
		else
		{
			enable="2";
		}
		
		
		String sqlQuery = "UPDATE employee_task SET ENABLED=:enable WHERE ID=:taskid";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery);
		query.setParameter("taskid",taskid);
		query.setParameter("enable",enable);
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
	public List<String> taskRepeatList(Integer taskid) {
		List<String> daylist = new ArrayList<String>();
		String sqlQuery = "select DISTINCT repeats from employee_task_repeat where task_id=:taskid";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery);
			query.setParameter("taskid", taskid);
			try {
				daylist = (List<String>) query.getResultList();	
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
	
		return daylist;
	}
	@Override
	public List<EmployeeTask> getTodaysTask(Integer dealerid, Integer employeeId) {
		List<EmployeeTask> list = new ArrayList<EmployeeTask>();
		if(employeeId!=null)
		{
			if(employeeId==0)
			{
				String sqlQuery = "select * from employee_task where task_Date=:taskdate or all_Days='1' and  employee_id=:employeeId and dealer_id=:dealerid  and ENABLED='1' or  ENABLED='2' ORDER BY ID DESC";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, EmployeeTask.class);
				query.setParameter("employeeId", employeeId);
				query.setParameter("taskdate", strDate);
				query.setParameter("dealerid", dealerid);
				list = (List<EmployeeTask>) query.getResultList();
			}
			else
			{
				String sqlQuery = "select * from employee_task where employee_id=:employeeId  and  task_Date=:taskdate or all_Days='1' and ENABLED='1' or ENABLED='2' ORDER BY ID DESC";
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, EmployeeTask.class);
				query.setParameter("employeeId",employeeId);
				query.setParameter("taskdate", new Date());
				list = (List<EmployeeTask>) query.getResultList();
			}
		}
		
		return list;
	}
	@Override
	public Boolean isEmployeeExist(String mobile) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		String sqlQuery = "select * from employeedetails where mobile=:mobile and ENABLED='1' ORDER BY ID DESC";
			Query query = null;
			query = getEntityManager().createNativeQuery(sqlQuery, EmployeeEntity.class);
			query.setParameter("mobile", mobile);
			try {
				employeeEntity = (EmployeeEntity) query.getSingleResult();
				if(employeeEntity!=null)
				{
					return true;
				}
				else
				{
					return false;
				}
			} catch (Exception e) {
				return false;
				// TODO: handle exception
			}
			
			
	
	}
}
