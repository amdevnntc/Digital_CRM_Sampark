package com.sampark.digitalCrm.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.common.TimezoneConverter;
import com.sampark.digitalCrm.entity.EnquiryEntity;
import com.sampark.digitalCrm.entity.EnquiryMeetingEntity;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.ClientService;
import com.sampark.digitalCrm.service.EnquiryService;
import com.sampark.digitalCrm.util.CommonUtils;

@Controller
@RequestMapping(value="/enquiry")
public class EnquiryController {
	
	
	private static final Logger logger = Logger.getLogger(EnquiryController.class);
	
	@Autowired
	EnquiryService enquiryService;
	@Autowired
	ClientService clientService;
	
	Date converteddate=TimezoneConverter.getDate(new Date());
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject saveEnquiry(@RequestBody EnquiryEntity enquiryEntity) throws Exception
	{
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		ResponseObject rsobj=null;
		enquiryEntity.setEnabled(1);
		enquiryEntity.setCreatedOn(converteddate);
		enquiryEntity.setModifiedon(converteddate);
		enquiryEntity.setMeetingStatus(digitalCrmConstant.STATUS_DEACTIVE);
		
		Random rand = new Random();
		int  n = rand.nextInt(9876542) + 1;
		System.out.println(n);
		enquiryEntity.setEnquiryid(n+""+n);
		enquiryEntity.setDealerid(loginEntity.getDealerIid());
		enquiryEntity.setEmployeeid(enquiryEntity.getEmployeeid());
		if(enquiryEntity.getId()!=null)
		{
			
		}
		else
		{
			enquiryEntity.setEmployeeid(loginEntity.getEmployeeid());	
		}
		
		    try {
				rsobj=enquiryService.saveEnquiry(enquiryEntity);
				
				if(enquiryEntity.getPropertytype().equalsIgnoreCase("Residential"))
				{
					rsobj=enquiryService.enquirySearchResidentialByAll(enquiryEntity);
					rsobj.setMessage("success");
				}
				else if(enquiryEntity.getPropertytype().equalsIgnoreCase("Commercial"))
				{
					rsobj=enquiryService.enquirySearchCommericialByAll(enquiryEntity);
					rsobj.setMessage("success");
				}
				else
				{
					
				}
				
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.info(e1);
			}  
		    return rsobj;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject updateEnquiry(@RequestBody EnquiryEntity enquiryEntity) throws Exception
	{
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		ResponseObject rsobj=null;
		enquiryEntity.setEnabled(1);
		enquiryEntity.setModifiedon(converteddate);
		enquiryEntity.setDealerid(loginEntity.getDealerIid());
		    try {
				rsobj=enquiryService.saveEnquiry(enquiryEntity);
				
				if(enquiryEntity.getPropertytype().equalsIgnoreCase("Residential"))
				{
					rsobj=enquiryService.enquirySearchResidentialByAll(enquiryEntity);
					rsobj.setMessage("success");
				}
				else if(enquiryEntity.getPropertytype().equalsIgnoreCase("Commercial"))
				{
					rsobj=enquiryService.enquirySearchCommericialByAll(enquiryEntity);
					rsobj.setMessage("success");
				}
				else
				{
					
				}
				
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.info(e1);
			}  
		    return rsobj;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject enquiryList() throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		    try {
				rsobj=enquiryService.getEnquiryList(loginEntity.getDealerIid(),loginEntity.getEmployeeid());
			
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.info(e1);
			}  
		    return rsobj;
	}
	
	@RequestMapping(value="/search/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject searchenquiryList(@RequestBody EnquiryEntity enquiryEntity) throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		enquiryEntity.setDealerid(loginEntity.getDealerIid());
		enquiryEntity.setEmployeeid(loginEntity.getEmployeeid());
		    if(enquiryEntity.getEnquiryFor().equalsIgnoreCase("Residential"))
			{
				rsobj=enquiryService.enquirySearchResidential(enquiryEntity);
			}
			else
			{
				rsobj=enquiryService.enquirySearchCommericial(enquiryEntity);
			}  
		    return rsobj;
	}
	@RequestMapping(value="/save/enquiryMeeting",method=RequestMethod.POST)
	public  @ResponseBody  ResponseEntity<Object> saveEnquiryMeeting(@RequestBody EnquiryMeetingEntity enquiryMeetingEntity) throws Exception
	{
		LoginEntity loginEntity=new LoginEntity();
		enquiryMeetingEntity.setEnabled(digitalCrmConstant.STATUS_ACTIVE);
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		enquiryMeetingEntity.setDealerId(loginEntity.getDealerIid());
		enquiryMeetingEntity.setEmployeeId(loginEntity.getEmployeeid());
	    enquiryMeetingEntity.setReminderStatus(digitalCrmConstant.STATUS_DEACTIVE);
		switch (enquiryMeetingEntity.getReminder()) {
		case 1:
			enquiryMeetingEntity.setReminder(60);
			break;
		case 2:
			enquiryMeetingEntity.setReminder(120);
			break;
			
		case 3:
			enquiryMeetingEntity.setReminder(180);
			break;

		default:
			break;
		}
		return new ResponseEntity<Object>(enquiryService.saveEnquiryMeeting(enquiryMeetingEntity), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/list/enquiryMeeting",method=RequestMethod.POST)
	public  @ResponseBody  ResponseEntity<Object> enquiryMeetingList() throws Exception
	{
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
	    return new ResponseEntity<Object>(enquiryService.listEnquiryMeeting(loginEntity.getDealerIid(),loginEntity.getEmployeeid()),HttpStatus.OK);
	}
}
