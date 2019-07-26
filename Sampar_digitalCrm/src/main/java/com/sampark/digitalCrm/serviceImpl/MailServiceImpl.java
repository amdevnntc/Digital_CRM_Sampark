package com.sampark.digitalCrm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.entity.MailEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.MailRepository;
import com.sampark.digitalCrm.service.MailService;

@Service
public class MailServiceImpl  implements MailService{
	
	@Autowired
	MailRepository mailrepo;

	@Override
	public ResponseObject getmailList() throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<MailEntity> list = new ArrayList<MailEntity>();
		list=mailrepo.getmailList();
		rsobj.setObject(list);
		rsobj.setStatus(true);
		 
		 return rsobj;
	}

}
