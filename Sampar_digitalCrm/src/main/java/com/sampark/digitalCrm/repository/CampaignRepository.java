package com.sampark.digitalCrm.repository;

import java.util.List;

import com.sampark.digitalCrm.entity.CampaignEntity;
import com.sampark.digitalCrm.entity.TemplateEntity;


public interface CampaignRepository {
	
	public Boolean saveCampaign(CampaignEntity campaignEntity) throws Exception;
	public List<CampaignEntity> getCampaign(Integer dealerId,Integer employeeid) throws Exception;
	
	public TemplateEntity getTemplate(Integer templateId) throws Exception;
	public List<TemplateEntity> getTemplateList() throws Exception;
	
}
