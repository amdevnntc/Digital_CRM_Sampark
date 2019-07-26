package com.sampark.digitalCrm.repository;

import java.util.List;

import com.sampark.digitalCrm.entity.TemplateEntity;

public interface TemplateRepository {
	
	public TemplateEntity saveTemplate(TemplateEntity template);
	
	public List<TemplateEntity> templateList(Integer dealerId,Integer employeeid);

}
