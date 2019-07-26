package com.sampark.digitalCrm.controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.entity.SectorEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.SectorService;

@Controller
@RequestMapping(value = "/sector")
public class SectorController {

	private static final Logger logger = LoggerFactory.getLogger(SectorController.class);

	@Autowired
	SectorService sectorService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveSector(@RequestBody SectorEntity register) throws Exception {
		ResponseObject rsobj = null;

		try {
			register.setStatus(digitalCrmConstant.STATUS_ACTIVE);
			rsobj = sectorService.saveSector(register);
			logger.info("Success");
		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.error("[logoutschool] Exception while logging out school user... " + e1);
		}
		return rsobj;

	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject sectorList() throws Exception {
		ResponseObject rsobj = new ResponseObject();
		rsobj = sectorService.getSectorList();
		logger.info("Success");
		return rsobj;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody ResponseObject deleteSector(@RequestBody SectorEntity sectorEntity) throws Exception {
		sectorEntity.setStatus(digitalCrmConstant.STATUS_DEACTIVE);
		return sectorService.saveSector(sectorEntity);
	}

}
