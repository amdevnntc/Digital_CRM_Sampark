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
import com.sampark.digitalCrm.entity.CityEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.CityService;

@Controller
@RequestMapping(value = "/city")
public class CityController {

	private static final Logger logger = LoggerFactory.getLogger(CityController.class);

	@Autowired
	CityService cityService;
	
	/*
	 *  this methdod is to add city name in database
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveCity(@RequestBody CityEntity register) throws Exception {
		ResponseObject rsobj = null;
              System.out.println(register.getCityname());
		try {
			register.setStatus(digitalCrmConstant.STATUS_ACTIVE);
			rsobj = cityService.saveCity(register);
			logger.info("City Data Saved Successfully ");
		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.error("[logoutschool] Exception while logging out school user... " + e1);
		}
		return rsobj;

	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject cityList() throws Exception {
		ResponseObject rsobj = new ResponseObject();
		rsobj = cityService.getCityList();
		logger.info("data fetched city ");
		return rsobj;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody ResponseObject deleteCity(@RequestBody CityEntity cityEntity) throws Exception {
		cityEntity.setStatus(digitalCrmConstant.STATUS_DEACTIVE);
		return cityService.saveCity(cityEntity);
	}

}
