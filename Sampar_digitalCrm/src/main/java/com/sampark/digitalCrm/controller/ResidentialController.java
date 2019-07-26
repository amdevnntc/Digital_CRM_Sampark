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
import com.sampark.digitalCrm.entity.PropertyClientMapping;
import com.sampark.digitalCrm.entity.ResidentialEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.ClientService;
import com.sampark.digitalCrm.service.ResidentialService;
import com.sampark.digitalCrm.service.SectorService;
import com.sampark.digitalCrm.util.CommonUtils;

@Controller
@RequestMapping(value="/residential")
public class ResidentialController {
	
	
	private static final Logger logger = Logger.getLogger(ResidentialController.class);
	
	@Autowired
	SectorService sectorService;
	@Autowired
	 ClientService clientService;
	
	@Autowired
	ResidentialService residentialService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody ResponseObject saveProject(
			@RequestParam(value="id",required=false)Integer id,
			@RequestParam(value="ownername",required=true)String ownerName,
			@RequestParam(value="ownermobile",required=true)String ownermobile,
			@RequestParam(value="owneremail",required=false)String owneremail,
			@RequestParam(value="owneretype",required=true)String owneretype,
			@RequestParam(value="furnishedType",required=true)String furnishedType,
			@RequestParam(value="saletype",required=true) String saletype,
			@RequestParam(value="propertytype",required=true) String propertytype,
			@RequestParam(value="area",required=true)String area,
			@RequestParam(value="areatype",required=true)String areatype,
			@RequestParam(value="bedroom",required=true) String bedroom,
			@RequestParam(value="price",required=true) String price,
			@RequestParam(value="pricein",required=true) String pricein,
			@RequestParam(value="priceType",required=true )String priceType,
			@RequestParam(value="locality",required=true) String locality,
			@RequestParam(value="city",required=true )String city,
			@RequestParam(value="flatno",required=true )String flatno,
			@RequestParam(value="propertyname",required=true) String propertyname,
			@RequestParam(value="bathroom",required=false) String bathroom,
			@RequestParam(value="balcony",required=false) String balcony,
			@RequestParam(value="doa",required=false) String aod,
			@RequestParam(value="floor",required=false) String floor,
			@RequestParam(value="ownership",required=true)String ownership,
			@RequestParam(value="parking",required=false)String parking,
			@RequestParam(value="description",required=false) String description,
			@RequestParam(value="societyId",required=false)String societyId,
			@RequestParam(value="sectorId",required=false)String sectorId,
			@RequestParam(value="imagename",required=false) String imageName,
			@RequestParam(value="image",required=false) MultipartFile file,HttpSession session)
	{
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		ResidentialEntity residential=new ResidentialEntity();
		ResponseObject rsobj=new ResponseObject();
		String fname = null;
		
		System.out.println("balcony"+balcony);
		residential.setArea(area);
		residential.setBalcony(balcony);
		residential.setBathroom(bathroom);
		residential.setBedroom(bedroom);
		residential.setCity(city);
		residential.setCreatedOn(new Date());
		residential.setDealerid(loginEntity.getDealerIid());
		residential.setDescription(description);
		residential.setDoa(new Date());
        residential.setEmployeeid(loginEntity.getEmployeeid());
        residential.setEnabled(1);
        residential.setFlatNo(flatno);
        residential.setFloors(floor);
        residential.setLocality(locality);
        residential.setModifiedon(new Date());
        residential.setOwnerEmail(owneremail);
        residential.setOwnerMobile(ownermobile);
        residential.setOwnerName(ownerName);
        residential.setOwnerType(ownership);
        residential.setParking(parking);
        residential.setPrice(Integer.valueOf(price));
        residential.setPriceType(priceType);
        residential.setPropertyname(propertyname);
        residential.setPropertytype(propertytype);
        residential.setSaletype(saletype);
        residential.setOwnerType(owneretype);
		residential.setOwnership(ownership);
		residential.setId(id);
		residential.setAreatype(areatype);
		residential.setFurnishedType(furnishedType);
		residential.setPricein(pricein);
		residential.setSocietyId(Integer.valueOf(societyId));
		residential.setSocietyId(Integer.valueOf(societyId));
		residential.setSoldStatus(digitalCrmConstant.notsold);
		File dir = new File(digitalCrmConstant.residential_image);
		
	
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
 			
 				 residential.setImage(fname);
 				rsobj=residentialService.saveResidential(residential);
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
 					if(imageName.equalsIgnoreCase("residential.png"))
 	 				{
 	 					 residential.setImage("residential.png");
 	 				}
 	 				else
 	 				{
 	 					 residential.setImage(imageName);	
 	 				}
 	 					
 					
 					
 				}
 				
 				else
 				{
 					residential.setImage("residential.png");
 				}
 				
 				
 				rsobj=residentialService.saveResidential(residential);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
 	
		return rsobj;
		
	}
	
	@RequestMapping(value="/list/{id}",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject residentList(@PathVariable("id")Integer pageid) throws Exception
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
				rsobj=residentialService.getResidentialList(loginEntity.getDealerIid(),loginEntity.getEmployeeid(),pageid,total);
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.info(e1);
			}  
		    return rsobj;
	}
	
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject searchProject(@RequestParam("saletype")String saletype,
			@RequestParam("locality")String locality,
			@RequestParam("propertytype")String propertytype,
			@RequestParam("pricein")String pricein,
			@RequestParam("pricemax")String pricemax,
			@RequestParam("bedroom")String bedroom) throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		    try {
		    	List<String> propertytypelist = new ArrayList<String>(Arrays.asList(propertytype.split(",")));
				rsobj=residentialService.searchResidentialList(loginEntity.getDealerIid(),loginEntity.getEmployeeid(),saletype,locality,propertytypelist,pricein,pricemax,bedroom);
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.info(e1);
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
				rsobj=residentialService.getAllResidential(loginEntity.getDealerIid());
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.info(e1);
			}  
		    return rsobj;
	}

	
	
	@RequestMapping(value="/share",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject MailAndSms(@RequestParam("type")String type,
			@RequestParam("residentialid")String residentialid,
			@RequestParam("clientid")String clientid,
			@RequestParam("prorpertytype")String prorpertytype,
			@RequestParam("enquiryFor")String enquiryFor) throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		
		List<String> residentialidlist = new ArrayList<String>(Arrays.asList(residentialid.split(",")));
		List<String> clientidlist = new ArrayList<String>(Arrays.asList(clientid.split(",")));
		PropertyClientMapping propertyClientMapping=new PropertyClientMapping();
		propertyClientMapping.setDealerid(loginEntity.getDealerIid());
		propertyClientMapping.setEmployeeid(loginEntity.getEmployeeid());
		propertyClientMapping.setResidentProductid(residentialidlist);
	    propertyClientMapping.setClientid(clientidlist);
		propertyClientMapping.setType(type);
		propertyClientMapping.setProductType(prorpertytype);
		propertyClientMapping.setEnquiryFor(enquiryFor);
		rsobj=residentialService.saveClientPropertyNotification(propertyClientMapping);
		    return rsobj;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public @ResponseBody  ResponseEntity<Object> deleteResidential(@RequestBody ResidentialEntity residentialEntity)
	{
		return new ResponseEntity<Object>(residentialService.deleteResidential(residentialEntity), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/sold",method=RequestMethod.POST)
	public @ResponseBody  ResponseEntity<Object> soldResidential(@RequestBody ResidentialEntity residentialEntity)
	{
		return new ResponseEntity<Object>(residentialService.soldResidential(residentialEntity), HttpStatus.ACCEPTED);
	}
	
	
}
