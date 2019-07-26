package com.sampark.digitalCrm.controller;

import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.common.TimezoneConverter;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.entity.MeetingEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.ClientRepository;
import com.sampark.digitalCrm.service.ClientService;
import com.sampark.digitalCrm.service.Meetingservice;
import com.sampark.digitalCrm.util.CommonUtils;

@Controller
@RequestMapping(value="/meeting")
public class MeetingController {
	

	private static final Logger logger = Logger.getLogger(MeetingController.class);
	@Autowired
	Meetingservice meetingService;
	@Autowired
	ClientService clientService;
	
	@Autowired
	ClientRepository clientrepo;
	LoginEntity loginEntity=new LoginEntity();
	
	Date converteddate=TimezoneConverter.getDate(new Date());
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject saveUser(@RequestBody MeetingEntity meeting) throws Exception
	{
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		switch (meeting.getReminder()) {
		case "1":
		meeting.setReminder("60");
			break;

		case "2":
			meeting.setReminder("120");
				break;
		case "3":
			meeting.setReminder("180");
				break;

		default:
			break;
		}
		if(meeting.getId()!=null)
		{
			meeting.setModifiedon(converteddate);
		}
		else
		{
			
			meeting.setEnable(digitalCrmConstant.STATUS_ACTIVE);
			meeting.setCreatedon(converteddate);
			meeting.setModifiedon(converteddate);
			meeting.setEmployeeid(loginEntity.getEmployeeid());
			meeting.setDealerid(loginEntity.getDealerIid());
			meeting.setReminderStatus(digitalCrmConstant.STATUS_DEACTIVE);
		}
		
		
		return meetingService.saveMeeting(meeting);
		
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject clientList() throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientService.getCurrentUserid(CommonUtils.getCurrentUserName());
		    try {
				rsobj=meetingService.getMeetingList(loginEntity.getEmployeeid(),loginEntity.getDealerIid());
				logger.info("Success");
			}
		    catch(ParseException e1) 
		    {
				e1.printStackTrace();
				logger.info("" +e1);
			}  
		    return rsobj;
	}
	
	@RequestMapping(value="/cancle",method=RequestMethod.POST)
	public @ResponseBody ResponseObject cancleMeeting(@RequestParam("meetingid")String meetingid)
	{
		LoginEntity loginEntity=new LoginEntity();
		loginEntity=clientrepo.getCurrentUserid(CommonUtils.getCurrentUserName());
		ResponseObject rsobj=null;
		try {
			meetingService.cancleMeeting(Integer.valueOf(meetingid),loginEntity.getEmployeeid(), loginEntity.getDealerIid());
			rsobj=meetingService.getMeetingList(loginEntity.getEmployeeid(), loginEntity.getDealerIid());
			rsobj.setStatus(true);
			rsobj.setMessage("Meeting Cancle Successfully");
			return rsobj;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
             logger.info(e+"");
		} catch (Exception e) {
			   logger.info(e+"");
			e.printStackTrace();
		}
		return rsobj;
		
	}

}
