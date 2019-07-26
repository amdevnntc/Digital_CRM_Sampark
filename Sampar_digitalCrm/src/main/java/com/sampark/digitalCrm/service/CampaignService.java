package com.sampark.digitalCrm.service;

import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.entity.CampaignEntity;
import com.sampark.digitalCrm.object.ResponseObject;

@Service
public interface CampaignService {
	
	public ResponseObject saveCampaign(CampaignEntity campaignEntity) throws Exception;
	public ResponseObject getCampaign(Integer dealerId,Integer employeeid) throws Exception;
	
	public ResponseObject getTemplate(Integer templateId) throws Exception;
	public ResponseObject getTemplateList() throws Exception;
}
