package com.sampark.digitalCrm.controller;

import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.digitalCrm.common.TimezoneConverter;
import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.entity.PropertyEntity;
import com.sampark.digitalCrm.message.SendMessage;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.ClientService;
import com.sampark.digitalCrm.service.PropertyService;
import com.sampark.digitalCrm.util.CommonUtils;
@Controller
@RequestMapping(value="/property")
public class PropertyController {
	
	private static final Logger logger = Logger.getLogger(PropertyController.class);
	
	@Autowired
	PropertyService proservice;
	
	@Autowired
	ClientService clientService;
	
	
    Date converteddate=TimezoneConverter.getDate(new Date());
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject saveUser(@RequestBody PropertyEntity property) throws Exception
	{
		LoginEntity loginEntity=new LoginEntity();
		ResponseObject rsobj=null;
		property.setEnabled(1);
		property.setCreatedOn(converteddate);
		property.setModifiedon(converteddate);
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		property.setDealerid(loginEntity.getDealerIid());
		property.setEmployeeid(loginEntity.getEmployeeid());
		property.setPostedby(loginEntity.getUsername());
	
		    try {
				rsobj=proservice.saveProperty(property);
				logger.info("Success");
			}
		    catch(ParseException e1) 
		    {
		    	logger.info(e1);
				e1.printStackTrace();
				
			}  
		    return rsobj;
		
	}
	
	
	
	@RequestMapping(value="/list/{pageid}",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject propertyList(@PathVariable int pageid) throws Exception
	{
		  int total=8;  
		  if(pageid==1){
			  
		  }  
	        else{  
	            pageid=(pageid-1)*total+1;  
	        }  
		
		
		
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		    try {
		    	
		    	if(loginEntity.getEmployeeid().equals(0))
		    	{
		    		rsobj=proservice.getPropertyList(loginEntity.getDealerIid(),0,pageid,total);
		    	}
		    	else
		    	{
		    		rsobj=proservice.getPropertyList(loginEntity.getDealerIid(),loginEntity.getEmployeeid(),pageid,total);
		    	}
		    	
			
				logger.info("Success");
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
logger.info(e1);
			}  
		    return rsobj;
		
	}
	
	
	
	
	@RequestMapping(value="/search/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject searchpropertyList(@RequestParam("by")String by,@RequestParam("fors")String fors) throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		    try {
		    	
		    	if(loginEntity.getEmployeeid().equals(0))
		    	{
		    		rsobj=proservice.searchPropertyList(loginEntity.getDealerIid(),0,by,fors);
		    	}
		    	else
		    	{
		    		rsobj=proservice.searchPropertyList(loginEntity.getDealerIid(),loginEntity.getEmployeeid(),by,fors);
		    	}
		    	
			
				logger.info("Success");
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();

             logger.info(e1);
			}  
		    return rsobj;
		
	}
	
	
	@RequestMapping(value="/notifiy/{contact}",method=RequestMethod.POST)
	public @ResponseBody ResponseObject notifiyBy(@RequestBody PropertyEntity property,@PathVariable("contact")String mobile)
	{
		ResponseObject rsobj=new ResponseObject();
		System.out.println(property);
		String msg="Property Detail As Per your details, name:"+property.getPropertyname()+",propertytype:"+property.getPropertytype()+",area:"+property.getArea()+",price:"+property.getPrice()+",location:"+property.getLocation()+",status"+property.getConstructionstatus()+",For more details contact"+property.getClient().getName()+","+property.getClient().getMobile();
	System.out.println(msg);
		//SendMessage.msg(mobile, msg);
		
		
		
		
		
		rsobj.setStatus(true);
		return rsobj;
		
	}
	

}
