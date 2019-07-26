package com.sampark.digitalCrm.controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.entity.SocietyEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.SocietyService;

@Controller
@RequestMapping(value="/society")
public class SocietyController {

private static final Logger logger = LoggerFactory.getLogger(SectorController.class);
	
	@Autowired
	SocietyService societyService;
	

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject saveSociety(@RequestBody SocietyEntity register) throws Exception
	{
		ResponseObject rsobj=null;
	
		    try {
		    	register.setStatus(digitalCrmConstant.STATUS_ACTIVE);
				rsobj=societyService.saveSociety(register);
				logger.info("Success");
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.error("[logoutschool] Exception while logging out school user... " + e1);
			}  
		    return rsobj;
		
	}
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject getSocietyList(@RequestParam Integer sectorId) throws Exception
	{ 
		    return societyService.getSocietyList(sectorId);
	
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public @ResponseBody ResponseObject deleteSociety(@RequestBody SocietyEntity societyEntity) throws Exception 
	{
		societyEntity.setStatus(digitalCrmConstant.STATUS_DEACTIVE);
		return societyService.saveSociety(societyEntity);
	}
}
