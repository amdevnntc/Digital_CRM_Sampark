package com.sampark.digitalCrm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.entity.ProjectEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.ClientService;
import com.sampark.digitalCrm.service.ProjectService;
import com.sampark.digitalCrm.util.CommonUtils;

@Controller
@RequestMapping(value="/project")
public class ProjectController {
	
	
	private static final Logger logger = Logger.getLogger(MeetingController.class);
	
	@Autowired
	 ClientService clientService;
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody ResponseObject saveProject(
			@RequestParam(value="id",required=false) Integer id,
			@RequestParam(value="imagename",required=false) String imagename,
			@RequestParam("projectname") String projectname,
			@RequestParam(value="contactperson",required=true)String contactperson,
			@RequestParam(value="contactpersonmobile",required=true)String contactpersonmobile,
			@RequestParam(value="possessionDate",required=true) String possessionDate,
			@RequestParam(value="projecstatus",required=true) String projecstatus,
			@RequestParam(value="area",required=true) String area,
			@RequestParam(value="areatype",required=true) String areatype,
			@RequestParam(value="price",required=true) String price,
			@RequestParam(value="pricein",required=true) String pricein,
			@RequestParam(value="locality",required=true) String locality,
			@RequestParam(value="city",required=true) String city,
			@RequestParam(value="bookingtype",required=true) String bookingtype,
			@RequestParam(value="description",required=true) String description,
			@RequestParam(value="projecttype",required=true)String projecttype,
			@RequestParam(value="societyId",required=false)String societyId,
			@RequestParam(value="file1",required=false) MultipartFile file,HttpSession session)
	{
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		ProjectEntity project=new ProjectEntity();
		ResponseObject rsobj=new ResponseObject();
		String fname = null;
		 project.setArea(area);
		 project.setAreatype(areatype);
		 project.setBookingtype(bookingtype);
		 project.setCreatedOn(new Date());
		 project.setDealerid(loginEntity.getDealerIid());
		 project.setEmployeeid(loginEntity.getEmployeeid());
		 project.setCity(city);
		 project.setDescription(description);
		 project.setLocality(locality);
		 project.setPrice(Integer.valueOf(price));
		 project.setPricein(pricein);
		 project.setProjecstatus(projecstatus);
		 project.setProjectname(projectname);
		 project.setPersonName(contactperson);
		 project.setPersonMobile(contactpersonmobile);
		 project.setEnabled(1);
		 project.setPossessionDate(possessionDate);
		 project.setProjecttype(projecttype);
		 project.setId(id);
	     project.setSocietyId(Integer.valueOf(societyId));
		File dir = new File(digitalCrmConstant.project_image);
 		if (file!=null) {
 			try {
 				byte[] bytes = file.getBytes();

 				// Creating the directory to store file
 				if (!dir.exists())
 					dir.mkdirs();
 				// Create the file on server

 				fname = UUID.randomUUID().toString()
 						+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
 				File serverFile = new File(dir.getAbsolutePath() + File.separator + fname);
 				System.out.println(serverFile);
 				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
 				stream.write(bytes);
 				stream.close();
 			 project.setImagename(fname);
 				rsobj=projectService.saveProject(project);
 			} catch (Exception e) {
 				
 				e.printStackTrace();
 				logger.info(e);
 			}
 		} 
 		else
 		{
 			try {
 				
 				
 				if(imagename!=null)
 				{
 					if(imagename.equalsIgnoreCase("project.png"))
 	 				{
 						project.setImagename("project.png");
 	 				}
 	 				else
 	 				{
 	 					project.setImagename(imagename);	
 	 				}
 	 						
 				}
 				
 				else
 				{
 					project.setImagename("project.png");
 				}
 				rsobj=projectService.saveProject(project);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
 	
		return rsobj;
		
	}
	
	@RequestMapping(value="/list/{id}",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject projectList(@PathVariable("id")Integer pageid) throws Exception
	{
		
		  int total=8;  
		  if(pageid==1){
			  
		  }  
	        else{  
	            pageid=(pageid-1)*total+1;  
	        }  
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		    try {
				rsobj=projectService.getProjectList(loginEntity.getDealerIid(),loginEntity.getEmployeeid(),pageid,total);
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.info(e1);
			}  
		    return rsobj;
	}
	
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject searchProject(
			@RequestParam("saleType")String saleType,
			@RequestParam("locality")String locality,
			@RequestParam("projectType")String projectType,
			@RequestParam("pricemin")String pricemin,
			@RequestParam("pricemax")String pricemax,
			@RequestParam("pricein")String pricein) throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		    try {
				rsobj=projectService.searchProjectList(loginEntity.getDealerIid(),loginEntity.getEmployeeid(),saleType,locality,projectType,pricemin,pricemax,pricein);
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.info(e1);
			}  
		    return rsobj;
	}

}
