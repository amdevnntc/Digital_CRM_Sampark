package com.sampark.digitalCrm.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.controller.CampaignController;
import com.sampark.digitalCrm.entity.CampaignEntity;
import com.sampark.digitalCrm.entity.TemplateEntity;
import com.sampark.digitalCrm.mail.SendMail;
import com.sampark.digitalCrm.message.SendMessage;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.CampaignRepository;
import com.sampark.digitalCrm.service.CampaignService;
@Service
public class CampaignServiceImpl implements CampaignService {
	
	private static final Logger logger = Logger.getLogger(CampaignServiceImpl.class);
	
	@Autowired
	CampaignRepository campaignRepo;

	@Override
	public ResponseObject saveCampaign(CampaignEntity campaignEntity) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		
		String msg="Campaign Name: "+campaignEntity.getName()+","+"Document Url: "+campaignEntity.getFilename();
		
		if(campaignEntity.getNotifiyBy().equals("Sms"))
		{
			Iterator<String> it=campaignEntity.getMobile().iterator();
			while (it.hasNext()) {
				String mobile=it.next();
				SendMessage.msg(mobile, msg);
			}
		}
		else
		{
			TemplateEntity templateEntity=new TemplateEntity();
			templateEntity=campaignRepo.getTemplate(campaignEntity.getTemplateid());
			List<String> emailList=campaignEntity.getEmail();
			String email=StringUtils.join(emailList, ',');
			
			try {
				SendMail.send(email,templateEntity.getTemplate(),"Campaign Details:");
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("Email Errors"+e);
			}
			
			
			
			campaignEntity.setTemplate(templateEntity.getTemplate());
			campaignEntity.setName(templateEntity.getName());
			campaignEntity.setDescription(templateEntity.getDescription());
			campaignEntity.setFilename(templateEntity.getFilename());
		}
		
		if(campaignRepo.saveCampaign(campaignEntity))
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
	public ResponseObject getCampaign(Integer dealerId, Integer employeeid) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<CampaignEntity> list = new ArrayList<CampaignEntity>();
		list=campaignRepo.getCampaign(dealerId, employeeid);
		rsobj.setObject(list);
		rsobj.setStatus(true);
		return rsobj;
	}

	@Override
	public ResponseObject getTemplate(Integer templateId) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		TemplateEntity list = new  TemplateEntity();
		list=campaignRepo.getTemplate(1);
		
		rsobj.setObject(list);
		rsobj.setStatus(true);
		return rsobj;
	}

	@Override
	public ResponseObject getTemplateList() throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<TemplateEntity> list = new ArrayList<TemplateEntity>();
		list=campaignRepo.getTemplateList();
		rsobj.setObject(list);
		rsobj.setStatus(true);
		return rsobj;
	}

}
