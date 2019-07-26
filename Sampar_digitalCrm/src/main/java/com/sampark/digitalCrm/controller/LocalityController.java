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
import com.sampark.digitalCrm.entity.LocalityEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.LocalityService;

@Controller
@RequestMapping(value = "/locality")
public class LocalityController {

	private static final Logger logger = LoggerFactory.getLogger(LocalityController.class);

	@Autowired
	LocalityService localityService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveLocality(@RequestBody LocalityEntity register) throws Exception {
		ResponseObject rsobj = null;

		try {
			register.setStatus(digitalCrmConstant.STATUS_ACTIVE);
			rsobj = localityService.saveLocality(register);
			logger.info("Success locality data saved in database.");
		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.error("[logoutschool] Exception while logging out school user... " + e1);
		}
		return rsobj;

	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject getLocalityList(@RequestParam Integer cityid) throws Exception {
		return localityService.getLocalityList(cityid);

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody ResponseObject deleteLocality(@RequestBody LocalityEntity localityEntity) throws Exception {
		localityEntity.setStatus(digitalCrmConstant.STATUS_DEACTIVE);
		return localityService.saveLocality(localityEntity);
	}
}
