package com.sampark.digitalCrm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.digitalCrm.common.TimezoneConverter;
import com.sampark.digitalCrm.entity.BulkSmsEntity;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.BulkSmsService;
import com.sampark.digitalCrm.service.ClientService;
import com.sampark.digitalCrm.util.CommonUtils;
@Controller
@RequestMapping(value="/sms")
public class BulkSmsController {
	
	
	private static final Logger logger = Logger.getLogger(BulkSmsController.class);
	
	@Autowired
	BulkSmsService smsService;
	
	@Autowired
	ClientService clientService;
	
	Date converteddate=TimezoneConverter.getDate(new Date());
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody ResponseObject saveSms(@RequestBody BulkSmsEntity smsEntity)
	{
		LoginEntity loginEntity=new LoginEntity();
		ResponseObject rsobj=null;
		smsEntity.setEnabled(1);
		smsEntity.setCreatedOn(converteddate);
		smsEntity.setModifiedon(converteddate);
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		smsEntity.setDealerid(loginEntity.getDealerIid());
		smsEntity.setEmployeeid(loginEntity.getEmployeeid());
		    try {
				rsobj=smsService.saveSms(smsEntity);
			} catch (Exception e) {
				logger.info(e);
				e.printStackTrace();
			}  
		    return rsobj;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject smsList(@RequestParam("date")String strDate) throws Exception
	{
		Date converteddate1=TimezoneConverter.getDate(new Date());
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	     strDate= formatter.format(converteddate1);  
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		    try {
		    	
		    	if(loginEntity.getEmployeeid().equals(0))
		    	{
		    		rsobj=smsService.getSmsList(loginEntity.getDealerIid(),0,strDate);
		    	}
		    	else
		    	{
		    		rsobj=smsService.getSmsList(loginEntity.getDealerIid(),loginEntity.getEmployeeid(),strDate);
		    	}
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.info(e1);
			}  
		    return rsobj;
	}
	
	
	@RequestMapping(value="/history/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject historysmsList(@RequestParam("date")String strDate) throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		    try {
		    	
		    	if(loginEntity.getEmployeeid().equals(0))
		    	{
		    		rsobj=smsService.getSmsList(loginEntity.getDealerIid(),0,strDate);
		    	}
		    	else
		    	{
		    		rsobj=smsService.getSmsList(loginEntity.getDealerIid(),loginEntity.getEmployeeid(),strDate);
		    	}
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.info(e1);
			}  
		    return rsobj;
	}

}
