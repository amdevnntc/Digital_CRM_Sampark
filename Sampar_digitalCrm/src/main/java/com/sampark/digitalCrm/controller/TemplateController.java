package com.sampark.digitalCrm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.entity.ProjectEntity;
import com.sampark.digitalCrm.entity.TemplateEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.ClientService;
import com.sampark.digitalCrm.service.TemplateService;
import com.sampark.digitalCrm.util.CommonUtils;

@Controller
@RequestMapping(value="/template")
public class TemplateController {
	
	
	@Autowired
	TemplateService tservice;
	
	@Autowired
	ClientService clientService;
	
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody ResponseObject saveTemplate(@RequestParam("name") String name,
			@RequestParam("startdate") String startdate,
			@RequestParam("enddate") String enddate,
			@RequestParam("description") String description,
			@RequestParam("signature") String signature,
			@RequestParam("file1") MultipartFile file,HttpSession session) throws ParseException
	{
		  Date startdate1=new SimpleDateFormat("yyyy-MM-dd").parse(startdate); 
		  Date enddate1=new SimpleDateFormat("yyyy-MM-dd").parse(enddate); 
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		TemplateEntity template=new TemplateEntity();
		ResponseObject rsobj=new ResponseObject();
		String fname = null;
		 fname = UUID.randomUUID().toString()
					+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
		
		
		 template.setCreatedOn(new Date());
		 template.setDealerid(loginEntity.getDealerIid());
		 template.setEmployeeid(loginEntity.getEmployeeid());
		 template.setDescription(description);
		 template.setFilename(digitalCrmConstant.server_url+"images?image="+fname+"&folder=campaign");
		 template.setName(name);
		 template.setModifiedon(new Date());
		 template.setSignature(signature);
		 template.setEnabled(1);
		 template.setStartDate(startdate1);
		 template.setEndDate(enddate1);
		
		File dir = new File(digitalCrmConstant.campaign);
 		if (!file.isEmpty()) {
 			try {
 				byte[] bytes = file.getBytes();

 				// Creating the directory to store file
 				if (!dir.exists())
 					dir.mkdirs();
 				// Create the file on server
 				
 				File serverFile = new File(dir.getAbsolutePath() + File.separator + fname);
 				System.out.println(serverFile);
 				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
 				stream.write(bytes);
 				stream.close();
 				rsobj=tservice.saveTemplate(template);
 			} catch (Exception e) {
 				
 				e.printStackTrace();
 				
 			}
 		} 
 	
		return rsobj;
		
	}
	

}
