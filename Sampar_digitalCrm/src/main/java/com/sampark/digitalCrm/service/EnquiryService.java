package com.sampark.digitalCrm.service;

import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.entity.EnquiryEntity;
import com.sampark.digitalCrm.entity.EnquiryMeetingEntity;
import com.sampark.digitalCrm.object.ResponseObject;

@Service
public interface EnquiryService {
	
	public ResponseObject saveEnquiry(EnquiryEntity enquiryEntity) throws Exception;
	public ResponseObject getEnquiryList(Integer dealerId,Integer employeeid) throws Exception;
	
	public ResponseObject enquirySearchResidential(EnquiryEntity enquiryEntity);
	public ResponseObject enquirySearchCommericial(EnquiryEntity enquiryEntity);
	
	public ResponseObject enquirySearchResidentialByAll(EnquiryEntity EnquiryEntity);
	public ResponseObject enquirySearchCommericialByAll(EnquiryEntity EnquiryEntity);
	
	public ResponseObject saveEnquiryMeeting(EnquiryMeetingEntity enquiryMeetingEntity);
	
	public ResponseObject listEnquiryMeeting(Integer dealerId,Integer employeeId);

}
