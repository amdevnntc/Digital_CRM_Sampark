package com.sampark.digitalCrm.repository;

import java.util.List;

import com.sampark.digitalCrm.entity.DealerEntity;
import com.sampark.digitalCrm.entity.EmployeeEntity;
import com.sampark.digitalCrm.entity.EmployeeTask;

public interface EmployeeRepository {
	
	public Boolean saveEmployee(EmployeeEntity employee) throws Exception;
	
	public List<EmployeeEntity> employeeList(Integer dealerid);
	
	public Boolean saveTask(EmployeeTask employeeTask);
	
	public List<EmployeeTask> employeeTaskList(Integer dealerid,Integer employeeId);
	
	public List<String> taskRepeatList(Integer taskid);
	
	public EmployeeEntity employeeDetails(Integer empid,String type) throws Exception;

	public DealerEntity dealerDetails(Integer dealerid, String string);

	 public Boolean completeTask(Integer taskid,String type);
	 
	 public List<EmployeeTask> getTodaysTask(Integer dealerid,Integer employeeId);
	 
	 public Boolean isEmployeeExist(String mobile);
}
