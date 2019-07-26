package com.sampark.digitalCrm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.digitalCrm.controller.SocietyController;
import com.sampark.digitalCrm.entity.BulkSmsEntity;
import com.sampark.digitalCrm.entity.EmployeeEntity;
import com.sampark.digitalCrm.entity.SectorEntity;
import com.sampark.digitalCrm.entity.SocietyEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.SocietyRepository;
import com.sampark.digitalCrm.service.SocietyService;

@Service
public class SocietyServiceImpl implements SocietyService{
	private static final Logger logger = LoggerFactory.getLogger(SocietyController.class);


	@Autowired
	SocietyRepository societyrepo;
	
	@Autowired
	SocietyService societyService;

	@Override
	public ResponseObject saveSociety(SocietyEntity register) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		if(societyrepo.saveSociety(register))
		{
			rsobj.setStatus(true);
			rsobj.setMessage("success");
			rsobj.setObject(societyrepo.getSocietyList(register.getSectorId()));
		}
		else
		{
			rsobj.setStatus(false);
			rsobj.setMessage("something went wrong");
		}
		
		return rsobj;
	}
	

	@Override
	public ResponseObject getSocietyList(Integer sectorId) throws Exception {
		ResponseObject rsobj=new ResponseObject();
		
		List<SocietyEntity> list=societyrepo.getSocietyList(sectorId);
			logger.info("Success"); 
			rsobj.setObject(list);
		    return rsobj;
	}

	

	
}
