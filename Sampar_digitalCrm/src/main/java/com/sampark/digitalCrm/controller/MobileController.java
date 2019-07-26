package com.sampark.digitalCrm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.common.TimezoneConverter;
import com.sampark.digitalCrm.entity.BulkSmsEntity;
import com.sampark.digitalCrm.entity.CampaignEntity;
import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.entity.CommercialEntity;
import com.sampark.digitalCrm.entity.EmployeeNotes;
import com.sampark.digitalCrm.entity.EmployeeTask;
import com.sampark.digitalCrm.entity.EnquiryEntity;
import com.sampark.digitalCrm.entity.EmployeeEntity;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.entity.MeetingEntity;
import com.sampark.digitalCrm.entity.ProjectEntity;
import com.sampark.digitalCrm.entity.PropertyClientMapping;
import com.sampark.digitalCrm.entity.PropertyEntity;
import com.sampark.digitalCrm.entity.ResidentialEntity;
import com.sampark.digitalCrm.entity.TokenBean;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.service.BulkSmsService;
import com.sampark.digitalCrm.service.CampaignService;
import com.sampark.digitalCrm.service.ClientService;
import com.sampark.digitalCrm.service.CommercialService;
import com.sampark.digitalCrm.service.EmployeeService;
import com.sampark.digitalCrm.service.EnquiryService;
import com.sampark.digitalCrm.service.LoginService;
import com.sampark.digitalCrm.service.Meetingservice;
import com.sampark.digitalCrm.service.ProjectService;
import com.sampark.digitalCrm.service.PropertyService;
import com.sampark.digitalCrm.service.ResidentialService;
import com.sampark.digitalCrm.service.SectorService;
import com.sampark.digitalCrm.service.SocietyService;
import com.sampark.digitalCrm.service.TokenService;
import com.sampark.digitalCrm.util.CommonUtils;

@Controller
@RequestMapping(value = "/mobile")
public class MobileController {

	private static final Logger logger = Logger.getLogger(MobileController.class);

	@Autowired
	LoginService loginservice;

	@Autowired
	ClientService clientService;

	@Autowired
	Meetingservice meetingService;

	@Autowired
	TokenService tokenservice;

	@Autowired
	EmployeeService empservice;

	@Autowired
	BulkSmsService smsService;
	@Autowired
	PropertyService proservice;

	@Autowired
	EnquiryService enquiryService;

	@Autowired
	ProjectService projectService;

	@Autowired
	CampaignService campaignService;

	@Autowired
	ResidentialService residentialService;

	@Autowired
	CommercialService commercialService;

	@Autowired
	SectorService sectorService;

	@Autowired
	SocietyService societyService;

	ResponseObject rsobj;

	Date converteddate = TimezoneConverter.getDate(new Date());

	@RequestMapping(value = "/login")
	public @ResponseBody ResponseObject login(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		LoginEntity login = new LoginEntity();
		login.setUsername(username);
		login.setPassword(password);
		try {

			rsobj = loginservice.login(login);
			logger.info("Login " + rsobj);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return rsobj;

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveUser(@RequestBody ClientEntity register, BindingResult result)
			throws Exception {
		ResponseObject rsObject = new ResponseObject();
		if (result.hasErrors()) {
			rsObject.setMessage("Please Fill All Mandatory Field");
			rsObject.setStatus(false);
			rsObject.setObject(result.getFieldError().getDefaultMessage());
		}

		register.setEnabled(1);
		register.setCreatedOn(converteddate);
		register.setModifiedon(converteddate);
		try {
			rsobj = clientService.saveClient(register);
			logger.info("success");
		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.info(e1);
		}
		return rsobj;

	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject clientList(@RequestParam("dealerid") String dealerid,
			@RequestParam("employeeid") String employeeid) throws Exception {
		ResponseObject rsobj = new ResponseObject();
		try {
			rsobj = clientService.getClientList(Integer.parseInt(dealerid), Integer.parseInt(employeeid));
		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.info(e1);
		}
		return rsobj;

	}

	@RequestMapping(value = "/listbyType", method = RequestMethod.POST)
	public @ResponseBody ResponseObject clientListByType(@RequestParam("dealerid") String dealerid,
			@RequestParam("employeeid") String employeeid, @RequestParam("type") String type) throws Exception {
		ResponseObject rsobj = new ResponseObject();
		rsobj = clientService.clientListByType(Integer.parseInt(dealerid), Integer.parseInt(employeeid), type);
		return rsobj;

	}

	@RequestMapping(value = "/save/meeting", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveMeeting(@RequestBody MeetingEntity meeting) throws Exception {
		ResponseObject rsobj = null;
		meeting.setEnable(digitalCrmConstant.STATUS_ACTIVE);
		meeting.setCreatedon(converteddate);
		meeting.setModifiedon(converteddate);
		meeting.setReminderStatus(digitalCrmConstant.STATUS_DEACTIVE);
		try {
			rsobj = meetingService.saveMeeting(meeting);
		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.info(e1);
		}
		return rsobj;
	}

	@RequestMapping(value = "/meeting/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject meetingList(@RequestParam("dealerid") String dealerid,
			@RequestParam("employeeid") String employeeid) throws Exception {
		ResponseObject rsobj = new ResponseObject();
		try {
			rsobj = meetingService.getMeetingList(Integer.parseInt(employeeid), Integer.parseInt(dealerid));
		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.info(e1);
		}
		return rsobj;

	}

	@RequestMapping(value = "/save/token", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveToken(@RequestBody TokenBean tokenBean) {
		ResponseObject rsobj = new ResponseObject();
		try {
			String msg = tokenservice.saveToken(tokenBean);
			if (msg.equals("success")) {
				rsobj.setStatus(true);
				rsobj.setMessage(msg);
			} else {
				rsobj.setStatus(false);
				rsobj.setMessage(msg);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(e);
		}
		return rsobj;

	}

	@RequestMapping(value = "/save/note", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveNotes(@RequestBody EmployeeNotes employeeNotes) throws Exception {
		ResponseObject rsobj = null;
		employeeNotes.setEnabled(1);

		System.out.println("Employee" + employeeNotes);

		try {

			if (employeeNotes.getId() == 0) {
				employeeNotes.setId(null);
			}

			rsobj = clientService.saveNotes(employeeNotes);
			logger.info("success");
		} catch (ParseException e1) {
			e1.printStackTrace();

			logger.info(e1);
		}
		return rsobj;

	}

	@RequestMapping(value = "/notes/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject notesList(@RequestParam("clientid") String clientid,
			@RequestParam("dealerid") String dealerid, @RequestParam("employeeid") String employeeid) throws Exception {
		ResponseObject rsobj = new ResponseObject();
		rsobj = clientService.notesList(Integer.valueOf(clientid), Integer.valueOf(dealerid),
				Integer.valueOf(employeeid));

		return rsobj;

	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveUser(@RequestBody EmployeeEntity employee) throws Exception {
		ResponseObject rsobj = null;
		employee.setEnabled(1);
		employee.setCreatedOn(converteddate);
		employee.setModifiedon(converteddate);

		try {
			rsobj = empservice.saveEmployee(employee);
			logger.info("Success");
		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.error("save Employee" + e1);
		}
		return rsobj;

	}

	@RequestMapping(value = "/employee/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject employeeList(@RequestParam("dealerid") String dealerid) {
		ResponseObject rsobj = new ResponseObject();
		try {
			rsobj = empservice.employeeList(Integer.valueOf(dealerid));
		} catch (NumberFormatException e) {
			logger.info("/employee/list" + e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("/employee/list" + e);
			e.printStackTrace();
		}
		logger.info("Success");
		return rsobj;

	}

	@RequestMapping(value = "/employee/task", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveEmployeeTask(@RequestBody EmployeeTask employeeTask) throws Exception {
		ResponseObject rsobj = null;
		employeeTask.setEnabled(1);
		employeeTask.setCreatedOn(converteddate);
		employeeTask.setModifiedon(converteddate);
		// String days1="Monday,Tuesday,Wednesday,Thrusday,Friday,Saturday";
		/*
		 * String [] days = employeeTask.getDays().split(","); List<String> dayslist =
		 * Arrays.asList(days); employeeTask.setRepeatDays(dayslist);
		 */ try {
			rsobj = empservice.saveTask(employeeTask);
			logger.info("Success");
		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.info("save Employee" + e1);
		}
		return rsobj;
	}

	@RequestMapping(value = "/employee/task/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject employeeTaskList(@RequestParam("dealerid") String dealerid,
			@RequestParam("employeeid") String employeeId) {
		ResponseObject rsobj = new ResponseObject();
		try {
			rsobj = empservice.employeeTaskList(Integer.valueOf(dealerid), Integer.valueOf(employeeId));
		} catch (NumberFormatException e) {
			logger.info("/employee/task/list" + e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("/employee/task/list" + e);
			e.printStackTrace();
		}
		logger.info("Success");
		return rsobj;
	}

	@RequestMapping(value = "/sms/save", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveSms(@RequestBody BulkSmsEntity smsEntity) {
		ResponseObject rsobj = null;
		smsEntity.setEnabled(1);
		smsEntity.setCreatedOn(converteddate);
		smsEntity.setModifiedon(converteddate);
		try {
			rsobj = smsService.saveSms(smsEntity);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return rsobj;
	}

	@RequestMapping(value = "/sms/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject smsList(@RequestParam("employeeid") String employeeid,
			@RequestParam("dealerid") String dealerid) throws Exception {
		Date converteddate1 = TimezoneConverter.getDate(new Date());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = formatter.format(converteddate1);
		ResponseObject rsobj = new ResponseObject();
		try {
			if (Integer.valueOf(employeeid) == 0) {
				rsobj = smsService.getSmsList(Integer.valueOf(dealerid), 0, strDate);
			} else {
				rsobj = smsService.getSmsList(Integer.valueOf(dealerid), Integer.valueOf(employeeid), strDate);
			}
		} catch (ParseException e1) {
			logger.info(e1);
			e1.printStackTrace();

		}
		return rsobj;
	}

	@RequestMapping(value = "/save/property", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveUser(@RequestBody PropertyEntity property) throws Exception {
		ResponseObject rsobj = null;
		property.setEnabled(1);
		property.setCreatedOn(converteddate);
		property.setModifiedon(converteddate);
		property.setDealerid(property.getDealerid());
		property.setEmployeeid(property.getEmployeeid());

		try {
			rsobj = proservice.saveProperty(property);

		} catch (ParseException e1) {
			logger.info(e1);
			e1.printStackTrace();

		}
		return rsobj;
	}

	@RequestMapping(value = "/list/property", method = RequestMethod.POST)
	public @ResponseBody ResponseObject propertyList(@RequestParam("dealerid") String dealerid,
			@RequestParam("employeeid") String employeeid, @RequestParam("pageid") String pageid) throws Exception {
		Integer page = Integer.valueOf(pageid);
		int total = digitalCrmConstant.paginationLimit;
		if (page == 1) {

		} else {
			page = (page - 1) * total + 1;
		}

		ResponseObject rsobj = new ResponseObject();
		try {

			if (Integer.valueOf(employeeid) == 0) {
				rsobj = proservice.getPropertyList(Integer.valueOf(dealerid), Integer.valueOf(employeeid), page, total);
			} else {
				rsobj = proservice.getPropertyList(Integer.valueOf(dealerid), Integer.valueOf(employeeid), page, total);
			}
		} catch (ParseException e1) {
			logger.info(e1);
			e1.printStackTrace();

		}
		return rsobj;

	}

	@RequestMapping(value = "/save/enquiry", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveEnquiry(@RequestBody EnquiryEntity enquiryEntity) throws Exception {
		ResponseObject rsobj = null;
		Random rand = new Random();
		int n = rand.nextInt(9876542) + 1;
		System.out.println(n);
		enquiryEntity.setEnquiryid("" + n + "" + n);
		enquiryEntity.setEnabled(1);
		enquiryEntity.setCreatedOn(converteddate);
		enquiryEntity.setModifiedon(converteddate);
		try {
			rsobj = enquiryService.saveEnquiry(enquiryEntity);
			if (rsobj.getStatus()) {
				if (enquiryEntity.getEnquiryFor().equalsIgnoreCase("Residential")) {
					rsobj = enquiryService.enquirySearchResidential(enquiryEntity);
				} else if (enquiryEntity.getEnquiryFor().equalsIgnoreCase("Commercial")) {
					rsobj = enquiryService.enquirySearchCommericial(enquiryEntity);
				} else {

				}
			} else {

			}
		} catch (ParseException e1) {
			logger.info(e1);
			e1.printStackTrace();

		}
		return rsobj;
	}

	/*
	 * @SuppressWarnings("unused")
	 * 
	 * @RequestMapping(value="/save/project",method=RequestMethod.POST)
	 * public @ResponseBody ResponseObject saveProject(@RequestParam("projectname")
	 * String projectname,
	 * 
	 * @RequestParam("projecstatus") String projecstatus,
	 * 
	 * @RequestParam("area") String area,
	 * 
	 * @RequestParam("bhk") String bhk,
	 * 
	 * @RequestParam("price") String price,
	 * 
	 * @RequestParam("location") String location,
	 * 
	 * @RequestParam("possessionDate") String possessionDate,
	 * 
	 * @RequestParam("city") String city,
	 * 
	 * @RequestParam("bookingtype") String bookingtype,
	 * 
	 * @RequestParam("description") String description,
	 * 
	 * @RequestParam("employeeid") Integer employeeid,
	 * 
	 * @RequestParam("dealerid") Integer dealerid,
	 * 
	 * @RequestParam("projecttype") String projecttype,
	 * 
	 * @RequestParam(value="file1",required=false) MultipartFile file,HttpSession
	 * session) {
	 * 
	 * 
	 * ProjectEntity project=new ProjectEntity(); ResponseObject rsobj=new
	 * ResponseObject();
	 * 
	 * 
	 * 
	 * String fname = null;
	 * 
	 * project.setArea(area); project.setBhk(bhk);
	 * project.setBookingtype(bookingtype); project.setCreatedOn(new Date());
	 * project.setDealerid(dealerid); project.setEmployeeid(employeeid);
	 * project.setCity(city); project.setDescription(description);
	 * 
	 * project.setLocation(location); project.setModifiedon(new Date());
	 * project.setPrice(price); project.setProjecstatus(projecstatus);
	 * project.setProjectname(projectname); project.setEnabled(1);
	 * project.setPossessionDate(possessionDate);
	 * project.setProjecttype(projecttype);
	 * 
	 * 
	 * File dir = new File(TrackConstanats.project_image); if (file!=null) { try {
	 * byte[] bytes = file.getBytes();
	 * 
	 * // Creating the directory to store file if (!dir.exists()) dir.mkdirs(); //
	 * Create the file on server
	 * 
	 * fname = UUID.randomUUID().toString() +
	 * file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('
	 * .'));
	 * 
	 * File serverFile = new File(dir.getAbsolutePath() + File.separator + fname);
	 * 
	 * System.out.println(serverFile); BufferedOutputStream stream = new
	 * BufferedOutputStream(new FileOutputStream(serverFile)); stream.write(bytes);
	 * stream.close();
	 * 
	 * project.setImagename(fname); rsobj=projectService.saveProject(project);
	 * 
	 * 
	 * 
	 * } catch (Exception e) { logger.info(e); e.printStackTrace(); } }
	 * 
	 * else { project.setImagename("project.png"); try {
	 * rsobj=projectService.saveProject(project); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * return rsobj;
	 * 
	 * }
	 * 
	 * 
	 */

	@RequestMapping(value = "/project/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject projectList(@RequestParam("dealerid") String dealerid,
			@RequestParam("employeeid") String employeeid, @RequestParam("pageid") String pageid) throws Exception {

		Integer page = Integer.valueOf(pageid);
		int total = digitalCrmConstant.paginationLimit;
		if (page == 1) {

		} else {
			page = (page - 1) * total + 1;
		}

		ResponseObject rsobj = new ResponseObject();
		try {
			rsobj = projectService.getProjectList(Integer.valueOf(dealerid), Integer.valueOf(employeeid), page, total);

		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.info(e1);
		}
		return rsobj;
	}

	@RequestMapping(value = "/project/search", method = RequestMethod.POST)
	public @ResponseBody ResponseObject searchProject(@RequestParam("dealerid") String dealerid,
			@RequestParam("employeeid") String employeeid, @RequestParam("saleType") String saleType,
			@RequestParam("locality") String locality, @RequestParam("projectType") String projectType,
			@RequestParam("pricemin") String pricemin, @RequestParam("pricemax") String pricemax,
			@RequestParam("pricein") String pricein) throws Exception {
		ResponseObject rsobj = new ResponseObject();

		try {
			rsobj = projectService.searchProjectList(Integer.valueOf(dealerid), Integer.valueOf(employeeid), saleType,
					locality, projectType, pricemin, pricemax, pricein);
		} catch (ParseException e1) {
			logger.info(e1);
			e1.printStackTrace();

		}
		return rsobj;
	}

	@RequestMapping(value = "/sector/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject sectorList() throws Exception {
		ResponseObject rsobj = new ResponseObject();
		rsobj = sectorService.getSectorList();
		logger.info("Success");
		return rsobj;

	}

	@RequestMapping(value = "/sector/society/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject getSocietyList(@RequestParam Integer sectorId) throws Exception {
		return societyService.getSocietyList(sectorId);

	}

	@RequestMapping(value = "/save/campaign", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveCampaign(@RequestParam("name") String name,
			@RequestParam("notifiyby") String notifiyby, @RequestParam("emaillist") List email,
			@RequestParam("mobilelist") List mobile, @RequestParam("description") String description,
			@RequestParam("employeeid") Integer employeeid, @RequestParam("dealerid") Integer dealerid,
			@RequestParam("file1") MultipartFile file, HttpSession session) {
		CampaignEntity campaign = new CampaignEntity();
		ResponseObject rsobj = new ResponseObject();
		System.out.println(file.getOriginalFilename());
		String fname = null;
		fname = UUID.randomUUID().toString()
				+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));

		campaign.setCreatedOn(new Date());
		campaign.setDealerid(dealerid);
		campaign.setEmployeeid(employeeid);
		campaign.setDescription(description);
		campaign.setFilename(fname);
		campaign.setModifiedon(new Date());
		campaign.setName(name);
		campaign.setEnabled(1);
		campaign.setNotifiyBy(notifiyby);

		if (notifiyby.equals("0")) {
			campaign.setMobile(mobile);
		} else if (notifiyby.equals("1")) {
			campaign.setEmail(email);
		} else {
			campaign.setMobile(mobile);
			campaign.setEmail(email);
		}

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

				rsobj = campaignService.saveCampaign(campaign);

			} catch (Exception e) {
				logger.info(e);
				e.printStackTrace();
			}
		}

		return rsobj;

	}

	@RequestMapping(value = "/campaign/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject campaignList(@RequestParam("dealerid") String dealerid,
			@RequestParam("employeeid") String employeeid) throws Exception {
		ResponseObject rsobj = new ResponseObject();
		try {
			rsobj = campaignService.getCampaign(Integer.valueOf(dealerid), Integer.valueOf(employeeid));

		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.info(e1);
		}
		return rsobj;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/save/residential", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveResidential(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "ownername", required = true) String ownerName,
			@RequestParam(value = "ownermobile", required = true) String ownermobile,
			@RequestParam(value = "owneremail", required = false) String owneremail,
			@RequestParam(value = "owneretype", required = true) String owneretype,
			@RequestParam(value = "furnishedType", required = true) String furnishedType,
			@RequestParam(value = "saletype", required = true) String saletype,
			@RequestParam(value = "propertytype", required = true) String propertytype,
			@RequestParam(value = "area", required = true) String area,
			@RequestParam(value = "bedroom", required = true) String bedroom,
			@RequestParam(value = "price", required = true) String price,

			@RequestParam(value = "pricein", required = true) String pricein,
			@RequestParam(value = "areatype", required = true) String areatype,
			@RequestParam(value = "pricetype", required = true) String priceType,
			@RequestParam(value = "locality", required = true) String locality,
			@RequestParam(value = "city", required = true) String city,
			@RequestParam(value = "flatno", required = true) String flatno,
			@RequestParam(value = "propertyname", required = false) String propertyname,
			@RequestParam(value = "bathroom", required = false) String bathroom,
			@RequestParam(value = "balcony", required = false) String balcony,
			@RequestParam(value = "doa", required = false) String aod,
			@RequestParam(value = "floor", required = false) String floor,
			@RequestParam(value = "ownership", required = false) String ownership,
			@RequestParam(value = "parking", required = false) String parking,
			@RequestParam(value = "employeeid", required = true) String employeeid,
			@RequestParam(value = "dealerid", required = true) String dealerid,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "imagename", required = false) String imageName,
			@RequestParam(value = "image", required = false) MultipartFile file) {

		ResidentialEntity residential = new ResidentialEntity();
		ResponseObject rsobj = new ResponseObject();
		String fname = null;

		System.out.println("employeeid" + employeeid);
		residential.setArea(area);
		residential.setBalcony(balcony);
		residential.setBathroom(bathroom);
		residential.setBedroom(bedroom);
		residential.setCity(city);
		residential.setCreatedOn(new Date());
		residential.setDealerid(Integer.valueOf(dealerid));
		residential.setDescription(description);
		residential.setDoa(converteddate);
		residential.setEmployeeid(Integer.valueOf(employeeid));
		residential.setEnabled(1);
		residential.setFlatNo(flatno);
		residential.setFloors(floor);
		residential.setLocality(locality);
		residential.setModifiedon(converteddate);
		residential.setOwnerEmail(owneremail);
		residential.setOwnerMobile(ownermobile);
		residential.setOwnerName(ownerName);
		residential.setOwnerType(owneretype);
		residential.setOwnership(ownership);
		residential.setParking(parking);
		residential.setPrice(Integer.valueOf(price));
		residential.setPriceType(priceType);
		residential.setPropertyname(propertyname);
		residential.setPropertytype(propertytype);
		residential.setSaletype(saletype);
		residential.setPricein(pricein);
		residential.setAreatype(areatype);
		residential.setFurnishedType(furnishedType);
		residential.setSoldStatus(digitalCrmConstant.notsold);

		if (id.equals(0) || id.equals("0")) {
			residential.setId(null);

		} else {
			residential.setId(Integer.valueOf(id));
		}

		File dir = new File(digitalCrmConstant.residential_image);
		if (file != null) {
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
				rsobj = residentialService.saveResidential(residential);
			} catch (Exception e) {
				logger.info(e);
				e.printStackTrace();
			}
		} else {
			try {

				System.out.println(imageName);

				if (imageName != null) {
					if (imageName.equalsIgnoreCase("residential.png")) {
						residential.setImage("residential.png");
					} else {
						residential.setImage(imageName);
					}

				}

				else {
					residential.setImage("residential.png");
				}

				rsobj = residentialService.saveResidential(residential);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return rsobj;

	}

	@RequestMapping(value = "/residential/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject residentList(@RequestParam("employeeid") String employeeid,
			@RequestParam("dealerid") String dealerid, @RequestParam("pageid") String pageid) throws Exception {
		ResponseObject rsobj = new ResponseObject();

		Integer page = Integer.valueOf(pageid);
		int total = digitalCrmConstant.paginationLimit;
		if (page == 1) {

		} else {
			page = (page - 1) * total + 1;
		}
		try {
			rsobj = residentialService.getResidentialList(Integer.valueOf(dealerid), Integer.valueOf(employeeid), page,
					total);
		} catch (ParseException e1) {
			logger.info(e1);
			e1.printStackTrace();

		}
		return rsobj;
	}

	@RequestMapping(value = "/residential/search", method = RequestMethod.POST)
	public @ResponseBody ResponseObject searchResidential(@RequestParam("saletype") String saletype,
			@RequestParam("locality") String locality, @RequestParam("propertytype") String propertytype,
			@RequestParam("pricemin") String pricemin, @RequestParam("pricemax") String pricemax,
			@RequestParam("bedroom") String bedroom, @RequestParam("pricein") String pricein,
			@RequestParam("employeeid") String employeeid, @RequestParam("dealerid") String dealerid) throws Exception {
		ResponseObject rsobj = new ResponseObject();

		List<String> propertytypelist = new ArrayList<String>(Arrays.asList(propertytype.split(",")));
		try {
			rsobj = residentialService.searchResidentialList(Integer.valueOf(dealerid), Integer.valueOf(employeeid),
					saletype, locality, propertytypelist, pricein, pricemax, bedroom);
		} catch (ParseException e1) {
			logger.info(e1);
			e1.printStackTrace();

		}
		return rsobj;
	}

	@RequestMapping(value = "/save/commercial", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveProject(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "wantto", required = true) String wantto,
			@RequestParam(value = "propertytype", required = true) String propertytype,
			@RequestParam(value = "ownertype", required = true) String ownertype,
			@RequestParam(value = "pricetype", required = true) String pricetype,
			@RequestParam(value = "lift", required = false) String lift,
			@RequestParam(value = "ownerName", required = true) String ownerName,
			@RequestParam(value = "ownerMobile", required = true) String ownerMobile,
			@RequestParam(value = "ownerEmail", required = true) String ownerEmail,
			@RequestParam(value = "price", required = true) String price,
			@RequestParam(value = "pricein", required = true) String pricein,
			@RequestParam(value = "area", required = true) String area,
			@RequestParam(value = "areatype", required = true) String areatype,
			@RequestParam(value = "maintainence", required = true) String maintainence,
			@RequestParam(value = "maintainencetype", required = true) String maintainencetype,
			@RequestParam(value = "locality", required = true) String locality,
			@RequestParam(value = "city", required = true) String city,
			@RequestParam(value = "floors", required = true) String floors,
			@RequestParam(value = "imagename", required = false) String imageName,
			@RequestParam(value = "projectname", required = false) String projectname,
			@RequestParam(value = "file1", required = false) MultipartFile file,
			@RequestParam(value = "washroom", required = false) String washroom,
			@RequestParam(value = "doa", required = false) String doa,
			@RequestParam(value = "ownership", required = false) String ownership,
			@RequestParam(value = "parking", required = false) String parking,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam("employeeid") String employeeid, @RequestParam("dealerid") String dealerid) {
		CommercialEntity commercial = new CommercialEntity();
		ResponseObject rsobj = new ResponseObject();
		String fname = null;
		commercial.setArea(Integer.valueOf(area));
		commercial.setAreatype(areatype);
		commercial.setCity(city);
		commercial.setCreatedOn(new Date());
		commercial.setDealerid(Integer.valueOf(dealerid));
		commercial.setDescription(description);
		commercial.setDoa(doa);
		commercial.setEmployeeid(Integer.valueOf(employeeid));
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
		commercial.setSoldStatus(digitalCrmConstant.notsold);

		File dir = new File(digitalCrmConstant.commercial_image);
		if (file != null) {
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

				rsobj = commercialService.saveCommercial(commercial);
			} catch (Exception e) {
				logger.info(e);
				e.printStackTrace();
			}
		} else {
			try {

				System.out.println(imageName);

				if (imageName != null) {
					if (imageName.equalsIgnoreCase("commercial.png")) {
						commercial.setImage("commercial.png");
					} else {
						commercial.setImage(imageName);
					}

				}

				else {
					commercial.setImage("commercial.png");
				}

				rsobj = commercialService.saveCommercial(commercial);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return rsobj;

	}

	@RequestMapping(value = "/commercial/list", method = RequestMethod.POST)
	public @ResponseBody ResponseObject commercialList(@RequestParam("employeeid") String employeeid,
			@RequestParam("dealerid") String dealerid) throws Exception {
		ResponseObject rsobj = new ResponseObject();

		try {
			rsobj = commercialService.getCommercialList(Integer.valueOf(dealerid), Integer.valueOf(employeeid), 1, 10);
		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.info(e1);
		}
		return rsobj;
	}

	@RequestMapping(value = "/commercial/search", method = RequestMethod.POST)
	public @ResponseBody ResponseObject searchcommercialProject(@RequestParam("saletype") String saletype,
			@RequestParam("locality") String locality, @RequestParam("propertytype") String propertytype,
			@RequestParam("pricemax") String pricemax, @RequestParam("pricemin") String pricemin,
			@RequestParam("pricein") String pricein, @RequestParam("areamax") String areamax,
			@RequestParam("areamin") String areamin, @RequestParam("areain") String areain,
			@RequestParam("employeeid") String employeeid, @RequestParam("dealerid") String dealerid) throws Exception {
		ResponseObject rsobj = new ResponseObject();
		try {

			List<String> propertytypelist = new ArrayList<String>(Arrays.asList(propertytype.split(",")));
			rsobj = commercialService.searchCommercialList(Integer.valueOf(dealerid), Integer.valueOf(employeeid),
					pricemin, pricemax, pricein, areamin, areamax, areain, locality, saletype, propertytypelist);
		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.info(e1);
		}
		return rsobj;
	}

	@RequestMapping(value = "/complete/task", method = RequestMethod.POST)
	public @ResponseBody ResponseObject completeTask(@RequestParam("taskid") Integer taskid,
			@RequestParam("type") String type) {
		ResponseObject rsobj = new ResponseObject();
		rsobj = empservice.completeTask(taskid, type);
		return rsobj;
	}

	@RequestMapping(value = "/todays/activities", method = RequestMethod.POST)
	public @ResponseBody ResponseObject todayActivity(@RequestParam("employeeid") String employeeid,
			@RequestParam("dealerid") String dealerid) throws Exception {
		ResponseObject rsobj = new ResponseObject();

		rsobj = empservice.getTodaysTask(Integer.valueOf(dealerid), Integer.valueOf(employeeid));

		return rsobj;
	}

	@RequestMapping(value = "/share", method = RequestMethod.POST)
	public @ResponseBody ResponseObject MailAndSms(@RequestParam("type") String type,
			@RequestParam("residentialid") String residentialid, @RequestParam("clientid") String clientid,
			@RequestParam("prorpertytype") String prorpertytype, @RequestParam("employeeid") String employeeid,
			@RequestParam("dealerid") String dealerid) throws Exception {
		ResponseObject rsobj = new ResponseObject();
		List<String> residentialidlist = new ArrayList<String>(Arrays.asList(residentialid.split(",")));
		List<String> clientidlist = new ArrayList<String>(Arrays.asList(clientid.split(",")));
		PropertyClientMapping propertyClientMapping = new PropertyClientMapping();
		propertyClientMapping.setDealerid(Integer.valueOf(dealerid));
		propertyClientMapping.setEmployeeid(Integer.valueOf(employeeid));
		propertyClientMapping.setResidentProductid(residentialidlist);
		propertyClientMapping.setClientid(clientidlist);
		propertyClientMapping.setType(type);
		propertyClientMapping.setProductType(prorpertytype);
		rsobj = residentialService.saveClientPropertyNotification(propertyClientMapping);
		return rsobj;
	}

	@RequestMapping(value = "/enquiry/List", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> enquiryList(@RequestParam("dealerId") Integer dealerId,
			@RequestParam("employeeId") Integer employeeid) throws Exception {

		return new ResponseEntity<Object>(enquiryService.getEnquiryList(dealerId, employeeid), HttpStatus.OK);
	}

	@RequestMapping(value = "/enquiry/details", method = RequestMethod.POST)
	public @ResponseBody ResponseObject searchenquiryList(@RequestBody EnquiryEntity enquiryEntity) throws Exception {
		ResponseObject rsobj = new ResponseObject();
		LoginEntity loginEntity = new LoginEntity();
		loginEntity = clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		enquiryEntity.setDealerid(loginEntity.getDealerIid());
		enquiryEntity.setEmployeeid(loginEntity.getEmployeeid());
		if (enquiryEntity.getEnquiryFor().equalsIgnoreCase("Residential")) {
			rsobj = enquiryService.enquirySearchResidential(enquiryEntity);
		} else {
			rsobj = enquiryService.enquirySearchCommericial(enquiryEntity);
		}
		return rsobj;
	}
}
