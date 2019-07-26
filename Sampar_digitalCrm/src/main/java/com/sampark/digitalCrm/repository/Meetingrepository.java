package com.sampark.digitalCrm.repository;

import java.util.List;
import com.sampark.digitalCrm.entity.MeetingEmployeeEntity;
import com.sampark.digitalCrm.entity.MeetingEntity;

public interface Meetingrepository {
	
	public Boolean saveMeeting(MeetingEntity meeting) throws Exception;
	public MeetingEntity getMeetingList(Integer meetingid,Integer employeeid,Integer dealerid) throws Exception;
	
	public List<MeetingEntity> getAllMeetingList() throws Exception;
	
	
	public List<Integer> getmeetingIdByEmployeeId(Integer employeeid,Integer dealerid);
	
	
	public List<Integer> getEmployeeIdByMeetingId(Integer meetingid);
	
	public Boolean cancleMeeting(Integer meetingid,Integer employeeid,Integer dealerid);
	public Boolean updateReminder(MeetingEntity meeting);
	
	public List<Integer> gettodaymeetingIdByEmployeeId(Integer employeeid,Integer dealerid);
	

}
