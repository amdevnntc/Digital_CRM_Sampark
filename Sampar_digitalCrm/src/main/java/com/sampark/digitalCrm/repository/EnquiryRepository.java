package com.sampark.digitalCrm.repository;

import java.util.List;

import com.sampark.digitalCrm.entity.CommercialEntity;
import com.sampark.digitalCrm.entity.EnquiryEntity;
import com.sampark.digitalCrm.entity.EnquiryMeetingEntity;
import com.sampark.digitalCrm.entity.ResidentialEntity;


public interface EnquiryRepository {
	
	public Boolean saveEnquiry(EnquiryEntity EnquiryEntity) throws Exception;
	public List<EnquiryEntity> getEnquiry(Integer dealerId,Integer employeeid) throws Exception;
	public List<ResidentialEntity> enquirySearchResidential(EnquiryEntity enquiryEntity);
	public List<CommercialEntity> enquirySearchCommericial(EnquiryEntity enquiryEntity);
	
	public List<ResidentialEntity> enquirySearchResidentialByAll(EnquiryEntity EnquiryEntity);
	public List<CommercialEntity> enquirySearchCommericialByAll(EnquiryEntity EnquiryEntity);
	
	public EnquiryEntity getEnquiryDetails(Integer id);
	
	
	public Boolean saveEnquiryMeeting(EnquiryMeetingEntity enquiryMeetingEntity);
	
	public List<EnquiryMeetingEntity> listEnquiryMeeting(Integer dealerId,Integer employeeId);
	
	public List<EnquiryMeetingEntity> getAllEnquiryMeeting();
	
	
	
}
