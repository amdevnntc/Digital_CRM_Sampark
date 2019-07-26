package com.sampark.digitalCrm.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.SupervisorService;


@Controller
@RequestMapping(path="/supervisior")
public class SupervisiorController {
	
	private static final Logger logger = Logger.getLogger(SupervisiorController.class);
	
	@Autowired
	SupervisorService supervisorservice;
	
	ResponseObject rsobj=new ResponseObject();
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	private @ResponseBody ResponseEntity<ClientEntity> getUser(@PathVariable("id") String supervisorId)
			{
		ClientEntity bean = new ClientEntity();
		bean = supervisorservice.getSupervisorById(supervisorId);
		ResponseEntity<ClientEntity> resp = new ResponseEntity<>(bean,HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value = "/search/name/{name}", method = RequestMethod.POST)
	private @ResponseBody ResponseEntity<List<ClientEntity>> getUserByName(
			@PathVariable("name") String name) {
		List<ClientEntity> userList = new ArrayList<ClientEntity>();
		userList = supervisorservice.searchSupervisorName(name);
		ResponseEntity<List<ClientEntity>> resp = new ResponseEntity<>(userList,HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	private @ResponseBody ResponseEntity<Boolean> saveUser(
			@RequestBody ClientEntity bean) {
		     Boolean flag = false;
		     
		       
		flag = supervisorservice.addSupervisor(bean);
		ResponseEntity<Boolean> resp = new ResponseEntity<>(flag,HttpStatus.OK);
		
		return resp;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	private @ResponseBody ResponseEntity<Boolean> updateUser(
			@RequestBody ClientEntity bean) {
		Boolean flag = false;
		
		flag = supervisorservice.addSupervisor(bean);
		ResponseEntity<Boolean> resp = new ResponseEntity<>(flag,HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value="/supervisorlist",method = RequestMethod.POST)
	private @ResponseBody ResponseObject getAll() {
		
		List<ClientEntity> list = new ArrayList<ClientEntity>();
		try {
			list=supervisorservice.getAll();
			rsobj.setObject(list);
			
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return rsobj;
	}
}
