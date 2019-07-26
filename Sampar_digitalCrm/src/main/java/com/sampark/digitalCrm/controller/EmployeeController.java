package com.sampark.digitalCrm.controller;

import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.digitalCrm.entity.EmployeeEntity;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.ClientService;
import com.sampark.digitalCrm.service.EmployeeService;
import com.sampark.digitalCrm.util.CommonUtils;
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService empservice;
	
	@Autowired
	ClientService clientService;
	LoginEntity loginEntity=new LoginEntity();
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject saveUser(@RequestBody EmployeeEntity employee) throws Exception
	{
	
		
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		ResponseObject rsobj=null;
		employee.setEnabled(1);
		employee.setCreatedOn(new Date());
		employee.setModifiedon(new Date());
		employee.setDealerid(loginEntity.getDealerIid());
	
		    try {
				rsobj=empservice.saveEmployee(employee);
				logger.info("Success");
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.info("save Employee" + e1);
			}  
		    return rsobj;
		
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject employeeList()
	{
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		ResponseObject rsobj=new ResponseObject();
		    try {
				rsobj=empservice.employeeList(loginEntity.getDealerIid());
			} catch (NumberFormatException e) {
				logger.info("/employee/list" + e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.info("/employee/list" + e);
				e.printStackTrace();
			}
			logger.info("Success");  
		    return rsobj;
		
	}
	
	
	
	
	@RequestMapping(value="/profile",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject userProfile() throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		    try {
		    	
		    	if(loginEntity.getEmployeeid().equals(0))
		    	{
		    		rsobj=empservice.dealerDetails(loginEntity.getDealerIid(),null);
		    	}
		    	else
		    	{
		    		rsobj=empservice.employeeDetails(loginEntity.getEmployeeid(),null);
		    	}
		    	
			
				logger.info("Successfull LoggedIn");
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.error("[logoutschool] Exception while logging out school user... " +e1);
			}  
		    return rsobj;
		
	}
	

}
