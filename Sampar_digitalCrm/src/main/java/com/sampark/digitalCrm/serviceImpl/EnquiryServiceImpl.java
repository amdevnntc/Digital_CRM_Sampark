package com.sampark.digitalCrm.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.entity.CommercialEntity;
import com.sampark.digitalCrm.entity.EnquiryEntity;
import com.sampark.digitalCrm.entity.EnquiryMeetingEntity;
import com.sampark.digitalCrm.entity.PropertyEntity;
import com.sampark.digitalCrm.entity.ResidentialEntity;
import com.sampark.digitalCrm.message.SendMessage;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.EnquiryRepository;
import com.sampark.digitalCrm.service.EnquiryService;
@Service
public class EnquiryServiceImpl implements EnquiryService {
	
	@Autowired
	EnquiryRepository enquiryRepo;

	@Override
	public ResponseObject saveEnquiry(EnquiryEntity enquiryEntity) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		if(enquiryRepo.saveEnquiry(enquiryEntity))
		{
			List<EnquiryEntity> list=enquiryRepo.getEnquiry(enquiryEntity.getDealerid(), enquiryEntity.getEmployeeid());
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
	public ResponseObject getEnquiryList(Integer dealerId, Integer employeeid) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<EnquiryEntity> list = new ArrayList<EnquiryEntity>();
		list=enquiryRepo.getEnquiry(dealerId, employeeid);
		rsobj.setObject(list);
		rsobj.setStatus(true);
		return rsobj;
	}

	@Override
	public ResponseObject enquirySearchResidential(EnquiryEntity enquiryEntity) {
		
		ResponseObject rsobj=new ResponseObject();
		List<ResidentialEntity> list = new ArrayList<ResidentialEntity>();
		list=enquiryRepo.enquirySearchResidential(enquiryEntity);
		Iterator<ResidentialEntity> it=list.iterator();
		ResidentialEntity residential=null;
		while (it.hasNext()) {
			residential=new ResidentialEntity();
			residential=it.next();
			residential.setImage(digitalCrmConstant.server_url+"images?image="+residential.getImage()+"&folder=residential");	
		}	
		rsobj.setObject(list);
		rsobj.setStatus(true);
		return rsobj;
	}

	@Override
	public ResponseObject enquirySearchCommericial(EnquiryEntity enquiryEntity) {
		ResponseObject rsobj=new ResponseObject();
	List<CommercialEntity> list = new ArrayList<CommercialEntity>();
	list=enquiryRepo.enquirySearchCommericial(enquiryEntity);
	Iterator<CommercialEntity> it=list.iterator();
	CommercialEntity commercial=null;
	while (it.hasNext()) {
		commercial=new CommercialEntity();
		commercial=it.next();
		commercial.setImage(digitalCrmConstant.server_url+"images?image="+commercial.getImage()+"&folder=commercial");	
	}	
	rsobj.setObject(list);
	rsobj.setStatus(true);
	return rsobj;
	}

	@Override
	public ResponseObject enquirySearchResidentialByAll(EnquiryEntity EnquiryEntity) {
		
		ResponseObject rsobj=new ResponseObject();
		List<ResidentialEntity> list = new ArrayList<ResidentialEntity>();
		list=enquiryRepo.enquirySearchResidentialByAll(EnquiryEntity);
		Iterator<ResidentialEntity> it=list.iterator();
		ResidentialEntity residential=null;
		while (it.hasNext()) {
			residential=new ResidentialEntity();
			residential=it.next();
			residential.setImage(digitalCrmConstant.server_url+"images?image="+residential.getImage()+"&folder=residential");	
		}	
		rsobj.setObject(list);
		rsobj.setStatus(true);
		return rsobj;
	}

	@Override
	public ResponseObject enquirySearchCommericialByAll(EnquiryEntity EnquiryEntity) {
		ResponseObject rsobj=new ResponseObject();
	List<CommercialEntity> list = new ArrayList<CommercialEntity>();
	list=enquiryRepo.enquirySearchCommericialByAll(EnquiryEntity);
	Iterator<CommercialEntity> it=list.iterator();
	CommercialEntity commercial=null;
	while (it.hasNext()) {
		commercial=new CommercialEntity();
		commercial=it.next();
		commercial.setImage(digitalCrmConstant.server_url+"images?image="+commercial.getImage()+"&folder=commercial");	
	}	
	rsobj.setObject(list);
	rsobj.setStatus(true);
	return rsobj;
	}

	@Override
	public ResponseObject saveEnquiryMeeting(EnquiryMeetingEntity enquiryMeetingEntity) {
		ResponseObject rsObject=new ResponseObject();
		if(enquiryRepo.saveEnquiryMeeting(enquiryMeetingEntity))
		{
		   EnquiryEntity enquiryEntity=enquiryRepo.getEnquiryDetails(enquiryMeetingEntity.getEnquiryId());
			String msg="Title : "+enquiryMeetingEntity.getTitle()+", Date : "+enquiryMeetingEntity.getMeetingDate()+", Start time :"+enquiryMeetingEntity.getFromTime()+", Location :"+enquiryMeetingEntity.getLocation();
		   SendMessage.msg(enquiryEntity.getContact(), msg);
			rsObject.setStatus(true);
		}
		else
		{
			rsObject.setStatus(false);
		}
		return rsObject;
	}

	@Override
	public ResponseObject listEnquiryMeeting(Integer dealerId, Integer employeeId) {
		ResponseObject rsObject=new ResponseObject();
		rsObject.setObject(enquiryRepo.listEnquiryMeeting(dealerId, employeeId));
		rsObject.setStatus(true);
		return rsObject;
	}

}
