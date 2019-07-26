package com.sampark.digitalCrm.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.controller.MobileController;
import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.entity.DealerEntity;
import com.sampark.digitalCrm.entity.EmployeeEntity;
import com.sampark.digitalCrm.entity.EmployeeTask;
import com.sampark.digitalCrm.entity.MeetingEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.EmployeeRepository;
import com.sampark.digitalCrm.repository.Meetingrepository;
import com.sampark.digitalCrm.service.EmployeeService;
import com.sampark.digitalCrm.service.Meetingservice;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	EmployeeRepository employeerepo;
	
	@Autowired
	Meetingservice meetinservice;

	@Override
	public ResponseObject saveEmployee(EmployeeEntity employee) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		
		if(employeerepo.isEmployeeExist(employee.getMobile()))
		{
			rsobj.setStatus(true);
			rsobj.setMessage("Mobile number already exists");
		}
		else
		{
			if(employeerepo.saveEmployee(employee))
			{
				rsobj.setStatus(true);
				rsobj.setMessage(digitalCrmConstant.success);
			}
			else
			{
				rsobj.setStatus(false);
				rsobj.setMessage(digitalCrmConstant.fail);
				
			}
		}
		
		
		
		return rsobj;
	}

	@Override
	public ResponseObject employeeList(Integer dealerId) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		list=employeerepo.employeeList(dealerId);
		rsobj.setObject(list);
		rsobj.setStatus(true);
		 
		 return rsobj;
	}

	@Override
	public ResponseObject saveTask(EmployeeTask employeeTask) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		if(employeerepo.saveTask(employeeTask))
		{
			rsobj.setStatus(true);
			rsobj.setMessage(digitalCrmConstant.success);
		}
		else
		{
			rsobj.setStatus(false);
			rsobj.setMessage(digitalCrmConstant.fail);
			
		}
		return rsobj;
	}

	@Override
	public ResponseObject employeeTaskList(Integer dealerid, Integer employeeId) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<EmployeeTask> list = new ArrayList<EmployeeTask>();
		list=employeerepo.employeeTaskList(dealerid, employeeId);
		Iterator<EmployeeTask> it=list.iterator();
		EmployeeTask employeeTask=null;
		while (it.hasNext()) {
			employeeTask=new EmployeeTask();
			employeeTask=it.next();
			List<String> daylist=employeerepo.taskRepeatList(employeeTask.getId());
			employeeTask.setRepeatDays(daylist);
		}
		rsobj.setObject(list);
		rsobj.setStatus(true);
		 
		 return rsobj;
	}

	@Override
	public ResponseObject completeTask(Integer taskid,String type) {
		ResponseObject rsobj=new ResponseObject();
		if(employeerepo.completeTask(taskid,type))
		{
			rsobj.setStatus(true);
		}
		else
		{
			rsobj.setStatus(false);
		}
		return rsobj;
	}

	@Override
	public ResponseObject employeeDetails(Integer empid, String type) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		EmployeeEntity bean = new EmployeeEntity();
		bean=employeerepo.employeeDetails(empid, type);
		rsobj.setObject(bean);
		rsobj.setStatus(true);
		 
		 return rsobj;
	}

	@Override
	public ResponseObject dealerDetails(Integer dealerid, String string) {
		
		ResponseObject rsobj=new ResponseObject();
		DealerEntity bean = new DealerEntity();
		bean=employeerepo.dealerDetails(dealerid, string);
		rsobj.setObject(bean);
		rsobj.setStatus(true);
		 
		 return rsobj;
	}

	@Override
	public ResponseObject getTodaysTask(Integer dealerid, Integer employeeId) {
		
		
		List<Object> list1=new ArrayList<Object>();
		
		HashMap<String,Object> hm=new HashMap<String,Object>();  
		
		List<MeetingEntity> listmeeting=new ArrayList<>();
		ResponseObject rsobj=new ResponseObject();
		List<EmployeeTask> list = new ArrayList<EmployeeTask>();
		list=employeerepo.getTodaysTask(dealerid, employeeId);
		Iterator<EmployeeTask> it=list.iterator();
		EmployeeTask employeeTask=null;
		while (it.hasNext()) {
			employeeTask=new EmployeeTask();
			employeeTask=it.next();
			List<String> daylist=employeerepo.taskRepeatList(employeeTask.getId());
			employeeTask.setRepeatDays(daylist);
		}
		
	      try {
		 listmeeting=meetinservice.gettodayMeetingList(employeeId, dealerid);
		 
		 logger.info("Todays Meeting List"+listmeeting);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      hm.put("task",list);
	      hm.put("meeting",listmeeting);
	
         rsobj.setObject(hm);
		rsobj.setStatus(true);
		 
		 return rsobj;
	}

}
