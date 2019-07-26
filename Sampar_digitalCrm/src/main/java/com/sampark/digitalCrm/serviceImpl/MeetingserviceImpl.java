package com.sampark.digitalCrm.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.entity.MeetingEmployeeEntity;
import com.sampark.digitalCrm.entity.MeetingEntity;
import com.sampark.digitalCrm.mail.SendMail;
import com.sampark.digitalCrm.message.SendMessage;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.ClientRepository;
import com.sampark.digitalCrm.repository.Meetingrepository;
import com.sampark.digitalCrm.service.Meetingservice;
import com.sampark.digitalCrm.util.CommonUtils;
@Service
public class MeetingserviceImpl  implements Meetingservice{
	
	@Autowired
	Meetingrepository meetingrepo;
   
	@Autowired
	ClientRepository clientrepo;
	@Override
	public ResponseObject saveMeeting(MeetingEntity meeting) throws Exception {
		ResponseObject rsobj=new ResponseObject();
		 if(meetingrepo.saveMeeting(meeting))
		 {
			 
			ClientEntity clientEntity= clientrepo.getDetails(meeting.getClientid());
		
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			String strDate = dateFormat.format(meeting.getMeetingdate());  
			
			 String msg="A new meeting is schedule for you, Title: "+meeting.getMeetingtitle()+ ","+"Description: "+meeting.getMeetingdesc()+", Date:  "+strDate+ " , From Time:"+meeting.getFromtime();
			SendMessage.msg(clientEntity.getMobile(), msg);
			 SendMail.send(clientEntity.getEmail(), msg,"Meeting Details");
			 rsobj.setStatus(true);
			 rsobj.setMessage(digitalCrmConstant.success);
		 }
		 else
		 {
			 rsobj.setStatus(false);
			 rsobj.setMessage(digitalCrmConstant.fail);
		 }
		return rsobj;
	}

	@Override
	public ResponseObject getMeetingList(Integer employeeid,Integer dealerid) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<MeetingEntity> list = new ArrayList<MeetingEntity>();
		List<Integer> meetingempid=new ArrayList<Integer>();
		
		meetingempid=meetingrepo.getmeetingIdByEmployeeId(employeeid, dealerid);
		
		Iterator<Integer> it1=meetingempid.iterator();
		MeetingEntity meeting=null;
		while (it1.hasNext()) {
			Integer meetingid=it1.next();
			meeting=new MeetingEntity();
			meeting=meetingrepo.getMeetingList(meetingid,employeeid,dealerid);
			if(meeting.getId()!=null)
			{
				list.add(meeting);	
			}
			else
			{
				System.out.println("no data");
			}
			
		}
		
		rsobj.setObject(list);
		rsobj.setStatus(true);
		 
		 return rsobj;
	}

	@Override
	@Transactional
	public ResponseObject cancleMeeting(Integer meetingid,Integer employeeid,Integer dealerid) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		if(meetingrepo.cancleMeeting(meetingid,employeeid,dealerid))
		{
			rsobj.setMessage("Meeting Cancle Successfully");
		}
		else
		{
			rsobj.setStatus(false);
			rsobj.setMessage("Something Went Wrong");
		}
		return rsobj;
	}

	@Override
	public List<MeetingEntity> gettodayMeetingList(Integer employeeid, Integer dealerid) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<MeetingEntity> list = new ArrayList<MeetingEntity>();
		List<Integer> meetingempid=new ArrayList<Integer>();
		
		meetingempid=meetingrepo.gettodaymeetingIdByEmployeeId(employeeid, dealerid);
		
		Iterator<Integer> it1=meetingempid.iterator();
		MeetingEntity meeting=null;
		while (it1.hasNext()) {
			Integer meetingid=it1.next();
			meeting=new MeetingEntity();
			meeting=meetingrepo.getMeetingList(meetingid,employeeid,dealerid);
			if(meeting.getId()!=null)
			{
				list.add(meeting);	
			}
			else
			{
				System.out.println("no data");
			}
			
		}
		
		
		 
		 return list;
	}

}
