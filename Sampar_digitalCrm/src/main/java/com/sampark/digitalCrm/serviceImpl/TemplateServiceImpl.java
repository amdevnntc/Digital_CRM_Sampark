package com.sampark.digitalCrm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.entity.PropertyEntity;
import com.sampark.digitalCrm.entity.TemplateEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.TemplateRepository;
import com.sampark.digitalCrm.service.TemplateService;

@Service
public class TemplateServiceImpl implements TemplateService {
	
	@Autowired
	TemplateRepository trepo;

	@Override
	public ResponseObject saveTemplate(TemplateEntity template) {
		
		ResponseObject rsobj=new ResponseObject();
		
		String templateDesign=digitalCrmConstant.templateDesign;
	String step1=templateDesign.replace("~`~TITLE~`~",template.getName());
String step2=step1.replace("~`~TITLEDESCRIPTION~`~",template.getDescription());
String step3=step2.replace("~`~URL~`~",template.getFilename());
String step4=step3.replace("~`~signature~`~",template.getSignature());
template.setTemplate(step4);
		
		TemplateEntity template1=trepo.saveTemplate(template);
		if(template1!=null)
		{		
			rsobj.setObject(template1);
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
	public ResponseObject templateList(Integer dealerId, Integer employeeid) {
		ResponseObject rsobj=new ResponseObject();
		List<TemplateEntity> list = new ArrayList<TemplateEntity>();
		list=trepo.templateList(dealerId, employeeid);
		
		rsobj.setObject(list);
		rsobj.setStatus(true);
		return rsobj;
	}

}
