package com.sampark.digitalCrm.service;

import java.util.List;

import com.sampark.digitalCrm.entity.DealerEntity;
import com.sampark.digitalCrm.entity.EmployeeEntity;
import com.sampark.digitalCrm.entity.EmployeeTask;
import com.sampark.digitalCrm.object.ResponseObject;

public interface EmployeeService {
	
	public ResponseObject saveEmployee(EmployeeEntity employee) throws Exception;
	
	public ResponseObject employeeList(Integer dealerId) throws Exception;
	
	public ResponseObject saveTask(EmployeeTask employeeTask) throws Exception;
	
	public ResponseObject employeeTaskList(Integer dealerid,Integer employeeId) throws Exception;
	
	public ResponseObject employeeDetails(Integer empid,String type) throws Exception;

	public ResponseObject dealerDetails(Integer dealerid, String string);
	
	public ResponseObject completeTask(Integer taskid,String type);
	
	public ResponseObject getTodaysTask(Integer dealerid,Integer employeeId);

}
