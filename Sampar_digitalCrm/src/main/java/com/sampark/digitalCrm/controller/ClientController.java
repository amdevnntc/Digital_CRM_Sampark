package com.sampark.digitalCrm.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.HomeController;
import com.sampark.digitalCrm.common.TimezoneConverter;
import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.ClientService;
import com.sampark.digitalCrm.util.CommonUtils;

@Controller
@RequestMapping(value="/client")
public class ClientController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	ClientService clientService;
	
	Date converteddate=TimezoneConverter.getDate(new Date());
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject saveUser(@RequestBody ClientEntity register) throws Exception
	{
		LoginEntity loginEntity=new LoginEntity();
		ResponseObject rsobj=null;
		register.setEnabled(1);
		register.setCreatedOn(converteddate);
		register.setModifiedon(converteddate);
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		register.setDealerid(loginEntity.getDealerIid());
		register.setEmployeeid(loginEntity.getEmployeeid());
	
		    try {
				rsobj=clientService.saveClient(register);
				logger.info("Success");
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.error("[logoutschool] Exception while logging out school user... " + e1);
			}  
		    return rsobj;
		
	}
	
	@RequestMapping(value = "/bulk/client", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveDocument(@RequestParam("file1") MultipartFile file,HttpSession session ) throws ParseException {
		LoginEntity loginEntity=new LoginEntity();
		ResponseObject rsobj=new ResponseObject();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
	   
		 BufferedReader br;
		 List<ClientEntity> clientlist = new ArrayList<ClientEntity>();
		 try {
		      String line;
		      boolean check = true;
		      InputStream is = file.getInputStream();
		      br = new BufferedReader(new InputStreamReader(is));
		      while ((line = br.readLine()) != null) {	
		    	  String[] parst = null;
		    	  if(check == true )
		    	  {
		    	  parst =  line.split(",");
		    	  check = false;
		    	  }
		    	  else
		    	  {
		    		  
		    		  parst =  line.split(",");
		    		  ClientEntity client=new ClientEntity();
		    		  client.setName(parst[0]);
		    		  client.setMobile(parst[1]);
		    		  
		    		  System.out.println(parst[2] +"Dob");
		    		  if(parst[2].trim().length()<1)
		    		  {
		    			  client.setDob(null);  
		    		  }
		    		  else
		    		  {
		    			  Date dob=new SimpleDateFormat("yyyy-MM-dd").parse(parst[2]);  
			    		  client.setDob(dob);
		    		  }
		    		  
		    		  if(parst[3].trim().length()<1)
		    		  {
		    			  client.setAnniversary(null);
		    		  }
		    		  else
		    		  {
		    			  Date anniversary=new SimpleDateFormat("yyyy-MM-dd").parse(parst[3]);  
			    		  client.setAnniversary(anniversary);
		    		  }
		    		  
		    		  client.setOccupation(parst[4]);
		    		  client.setEmail(parst[5]);
		    		  client.setHomeaddress(parst[6]);
		    		  client.setOfficeaddress(parst[7]);
		    		  client.setCreatedOn(converteddate);
		    		  client.setModifiedon(converteddate);
		    		  client.setDealerid(loginEntity.getDealerIid());
		    		  client.setEmployeeid(loginEntity.getEmployeeid());
		    		  client.setEnabled(1);
		    		  client.setClientType(parst[8]);
		    		  client.setSubClientType(parst[9]);
		    		  clientlist.add(client);
		    	 }
		      }
		      try {
				 rsobj=clientService.saveClientBulk(clientlist);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				logger.error("[logoutschool] Exception while logging out school user... " + e);
				
			}

		   } catch (IOException e) {
			   
			   e.printStackTrace();
			   logger.error("[logoutschool] Exception while logging out school user... " + e);
		     System.err.println(e.getMessage());       
		   }
		 
		return rsobj;
	}
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject clientList() throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		    try {
		    	
		    	if(loginEntity.getEmployeeid().equals(0))
		    	{
		    		rsobj=clientService.getClientList(loginEntity.getDealerIid(),0);
		    	}
		    	else
		    	{
		    		rsobj=clientService.getClientList(loginEntity.getDealerIid(),loginEntity.getEmployeeid());
		    	}
		    	
			
				logger.info("Success");
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.error("[logoutschool] Exception while logging out school user... " +e1);
			}  
		    return rsobj;
		
	}
	
	@RequestMapping(value="/notes/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject notesList(@RequestParam("clientid")String clientid) throws Exception
	{
		String[] parts = clientid.split(",");
		String clientids = parts[0]; // 004
		String dealerids = parts[1];
		String employeeids = parts[2];
		ResponseObject rsobj=new ResponseObject();
		    rsobj=clientService.notesList(Integer.valueOf(clientids),Integer.valueOf(dealerids),Integer.valueOf(employeeids));
			logger.info("Success");  
		    return rsobj;
		
	}

	
	
	
}
