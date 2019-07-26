package com.sampark.digitalCrm.service;

import java.util.List;

import com.sampark.digitalCrm.entity.MeetingEntity;
import com.sampark.digitalCrm.object.ResponseObject;

public interface Meetingservice {
	
	public ResponseObject saveMeeting(MeetingEntity meeting) throws Exception;
	public ResponseObject getMeetingList(Integer employeeid,Integer dealerid) throws Exception;
	
	public ResponseObject cancleMeeting(Integer meetingid,Integer employeeid,Integer dealerid) throws Exception;
	
	public List<MeetingEntity> gettodayMeetingList(Integer employeeid,Integer dealerid) throws Exception;

}
