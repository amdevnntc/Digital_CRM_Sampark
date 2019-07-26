package com.sampark.digitalCrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.MailService;

@Controller
@RequestMapping(value="/mail")
public class MailController {
	
	@Autowired
	MailService mservice;
	
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject smsList() throws Exception
	{
		ResponseObject rsobj=new ResponseObject();	
	/*	loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());*/
		rsobj=mservice.getmailList();
		    return rsobj;
	}
	

}
