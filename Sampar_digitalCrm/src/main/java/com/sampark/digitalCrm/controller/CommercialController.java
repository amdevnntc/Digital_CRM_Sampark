package com.sampark.digitalCrm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.entity.CommercialEntity;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.entity.ProjectEntity;
import com.sampark.digitalCrm.entity.ResidentialEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.ClientService;
import com.sampark.digitalCrm.service.CommercialService;
import com.sampark.digitalCrm.service.ProjectService;
import com.sampark.digitalCrm.service.ResidentialService;
import com.sampark.digitalCrm.util.CommonUtils;

@Controller
@RequestMapping(value="/commercial")
public class CommercialController {
	
	
	private static final Logger logger = Logger.getLogger(CommercialController.class);
	
	@Autowired
	 ClientService clientService;
	
	@Autowired
	CommercialService commercialService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody ResponseObject saveProject(
			
			@RequestParam(value="id",required=false) Integer id,
			@RequestParam(value="wantto",required=true) String wantto,
			@RequestParam(value="propertytype",required=true) String propertytype,
			@RequestParam(value="ownertype",required=true) String ownertype,
			@RequestParam(value="pricetype",required=true) String pricetype,
			@RequestParam(value="lift",required=true) String lift,
			@RequestParam(value="ownerName",required=true) String ownerName,
			@RequestParam(value="ownerMobile",required=true) String ownerMobile,
			@RequestParam(value="ownerEmail",required=true) String ownerEmail,
			@RequestParam(value="price",required=true) String price,
			@RequestParam(value="pricein",required=true) String pricein,
			@RequestParam(value="area",required=true) String area,
			@RequestParam(value="areatype",required=true) String areatype,
			@RequestParam(value="maintainence",required=true) String maintainence,
			@RequestParam(value="maintainencetype",required=true) String maintainencetype,
			@RequestParam(value="locality",required=true) String locality,
			@RequestParam(value="city",required=true) String city,
			@RequestParam(value="floors",required=true) String floors,
			@RequestParam(value="imagename",required=false) String imageName,
			@RequestParam(value="projectname",required=false) String projectname,
			@RequestParam(value="file1",required=false) MultipartFile file,
			@RequestParam(value="washroom",required=false) String washroom,
			@RequestParam(value="doa",required=false) String doa,
			@RequestParam(value="ownership",required=false) String ownership,
			@RequestParam(value="parking",required=false) String parking,
			@RequestParam(value="societyId",required=false)String societyId,
			@RequestParam(value="description",required=false) String description,HttpSession session)
	{
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		CommercialEntity commercial=new CommercialEntity();
		ResponseObject rsobj=new ResponseObject();
		String fname = null;
		
		commercial.setArea(Integer.valueOf(area));
		commercial.setAreatype(areatype);
		commercial.setCity(city);
		commercial.setCreatedOn(new Date());
		commercial.setDealerid(loginEntity.getDealerIid());
		commercial.setDescription(description);
		commercial.setDoa(doa);
		commercial.setEmployeeid(loginEntity.getEmployeeid());
		commercial.setEnabled(digitalCrmConstant.STATUS_ACTIVE);
		commercial.setFloors(floors);
		commercial.setId(id);
		commercial.setLift(lift);
		commercial.setLocality(locality);
		commercial.setMaintenance(maintainence);
		commercial.setMaintenancetype(maintainencetype);
		commercial.setModifiedon(new Date());
		commercial.setOwnerEmail(ownerEmail);
		commercial.setOwnerMobile(ownerMobile);
		commercial.setOwnerName(ownerName);
		commercial.setOwnership(ownership);
		commercial.setOwnertype(ownertype);
		commercial.setParking(parking);
		commercial.setPrice(Integer.valueOf(price));
		commercial.setPricein(pricein);
		commercial.setPriceType(pricetype);
		commercial.setProjectname(projectname);
		commercial.setPropertytype(propertytype);
		commercial.setWantto(wantto);
		commercial.setWashroom(washroom);
		commercial.setSocietyId(Integer.valueOf(societyId));
		commercial.setSoldStatus(digitalCrmConstant.notsold);
		
		 
		File dir = new File(digitalCrmConstant.commercial_image);
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
 				commercial.setImage(fname);	
 				rsobj=commercialService.saveCommercial(commercial);
 			} catch (Exception e) {
 				logger.info(e);
 				e.printStackTrace();
 			}
 		} 
 		else
 		{
 			try {
 				
 				System.out.println(imageName);
 				if(imageName!=null)
 				{
 					if(imageName.equalsIgnoreCase("commercial.png"))
 	 				{
 						commercial.setImage("commercial.png");
 	 				}
 	 				else
 	 				{
 	 					commercial.setImage(imageName);	
 	 				}
 	 					
 					
 					
 				}
 				
 				else
 				{
 					commercial.setImage("commercial.png");
 				}
 				
 				
 				rsobj=commercialService.saveCommercial(commercial);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
 	
		return rsobj;
		
	}
	
	@RequestMapping(value="/list/{id}",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject commercialList(@PathVariable("id")Integer pageid) throws Exception
	{
		 int total=digitalCrmConstant.paginationLimit;  
		  if(pageid==1){
			  
		  }  
	        else{  
	            pageid=(pageid-1)*total+1;  
	        }  
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		    try {
				rsobj=commercialService.getCommercialList(loginEntity.getDealerIid(),loginEntity.getEmployeeid(),pageid,total);
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.info(e1);
			}  
		    return rsobj;
	}
	
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject searchResidential(
			@RequestParam("saletype")String saletype,
			@RequestParam("locality")String locality,
			@RequestParam("propertytype")String propertytype,
			@RequestParam("pricemax")String pricemax,
			@RequestParam("pricemin")String pricemin,
			@RequestParam("pricein")String pricein,
			@RequestParam("areamax")String areamax,
			@RequestParam("areamin")String areamin,
			@RequestParam("areain")String areain
			) throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		
		List<String> propertytypelist = new ArrayList<String>(Arrays.asList(propertytype.split(",")));
		
		try {
				rsobj=commercialService.searchCommercialList(loginEntity.getDealerIid(),loginEntity.getEmployeeid(),pricemin,pricemax,pricein,areamin,areamax,areain,locality,saletype,propertytypelist);
			}
		    catch(ParseException e1) 
		    {
		    	logger.info(e1);
				e1.printStackTrace();
				
			}  
		    return rsobj;
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/graph/data",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject graphDataCommercial() throws Exception
	{

		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		
		ResponseObject rsobj=new ResponseObject();
		    try {
				rsobj=commercialService.getAllCommercial(loginEntity.getDealerIid());
			}
		    catch(ParseException e1) 
		    {
		    	logger.info(e1);
		    	e1.printStackTrace();
				
			}  
		    return rsobj;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public @ResponseBody  ResponseEntity<Object> deleteCommercial(@RequestBody CommercialEntity commercialEntity)
	{
		return new ResponseEntity<Object>(commercialService.deleteCommercial(commercialEntity), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/sold",method=RequestMethod.POST)
	public @ResponseBody  ResponseEntity<Object> soldCommercial(@RequestBody CommercialEntity commercialEntity)
	{
		return new ResponseEntity<Object>(commercialService.soldCommercial(commercialEntity), HttpStatus.ACCEPTED);
	}
}
