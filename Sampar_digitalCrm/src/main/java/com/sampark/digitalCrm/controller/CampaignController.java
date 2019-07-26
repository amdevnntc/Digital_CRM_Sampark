package com.sampark.digitalCrm.controller;

import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.common.TimezoneConverter;
import com.sampark.digitalCrm.entity.CampaignEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.CampaignService;
import com.sampark.digitalCrm.service.ClientService;
import com.sampark.digitalCrm.util.CommonUtils;

@Controller
@RequestMapping(value="/campaign")
public class CampaignController {
	
	private static final Logger logger = Logger.getLogger(CampaignController.class);
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	CampaignService campaignServie;;
	Date converteddate=TimezoneConverter.getDate(new Date());
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject campaignSave(@RequestBody CampaignEntity campaignEntity) throws Exception
	{
		LoginEntity loginEntity=new LoginEntity();
		ResponseObject rsobj=null;
		campaignEntity.setEnabled(1);
		campaignEntity.setCreatedOn(converteddate);
		campaignEntity.setModifiedon(converteddate);
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		campaignEntity.setDealerid(loginEntity.getDealerIid());
		campaignEntity.setEmployeeid(loginEntity.getEmployeeid());
	
		    try {
				rsobj=campaignServie.saveCampaign(campaignEntity);
				
				if(rsobj.getStatus())
				{
					rsobj=campaignServie.getCampaign(loginEntity.getDealerIid(),loginEntity.getEmployeeid());
				}
				else
				{
					rsobj.setStatus(false);
				}
				
			}
		    catch(ParseException e1) 
		    {logger.info(e1);
				e1.printStackTrace();
				
			}  
		    return rsobj;
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject campaignList() throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		    try {
				rsobj=campaignServie.getCampaign(loginEntity.getDealerIid(),loginEntity.getEmployeeid());
			}
		    catch(ParseException e1) 
		    {
		    	logger.info(e1);
				e1.printStackTrace();
				
			}
			return rsobj;  
		
	}
	
	
	@RequestMapping(value="/template/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject templateList() throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		rsobj=campaignServie.getTemplateList();
		    return rsobj;
		
	}


}
