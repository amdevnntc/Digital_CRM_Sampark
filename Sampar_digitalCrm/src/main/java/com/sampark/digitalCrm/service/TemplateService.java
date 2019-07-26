package com.sampark.digitalCrm.service;

import com.sampark.digitalCrm.entity.TemplateEntity;
import com.sampark.digitalCrm.object.ResponseObject;

public interface TemplateService {
	
	
     public ResponseObject saveTemplate(TemplateEntity template);
	public ResponseObject templateList(Integer dealerId,Integer employeeid);

}
