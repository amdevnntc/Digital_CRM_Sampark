package com.sampark.digitalCrm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.entity.BulkSmsEntity;
import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.BulkSmsRepository;
import com.sampark.digitalCrm.service.BulkSmsService;
@Service
public class BulkSmsServiceImpl implements BulkSmsService {
	
	@Autowired
	BulkSmsRepository smsrepo;

	@Override
	public ResponseObject saveSms(BulkSmsEntity smsEntity) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		if(smsrepo.saveSms(smsEntity))
		{
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
	public ResponseObject getSmsList(Integer dealerId, Integer employeeid,String date) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<BulkSmsEntity> list = new ArrayList<BulkSmsEntity>();
		list=smsrepo.getSmsList(dealerId, employeeid,date);
		rsobj.setObject(list);
		rsobj.setStatus(true);
		 
		 return rsobj;
	}

}
