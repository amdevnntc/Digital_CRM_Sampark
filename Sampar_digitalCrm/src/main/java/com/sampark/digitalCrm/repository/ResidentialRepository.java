package com.sampark.digitalCrm.repository;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.sampark.digitalCrm.entity.ProjectEntity;
import com.sampark.digitalCrm.entity.PropertyClientMapping;
import com.sampark.digitalCrm.entity.ResidentialEntity;


public interface ResidentialRepository {
	
	public Boolean saveResidential(ResidentialEntity residential) throws Exception;
	public List<ResidentialEntity> getResidential(Integer dealerId,Integer employeeid,Integer pageid,Integer total) throws Exception;
	public List<List<ResidentialEntity>> searchResidentialList(Integer dealerId,Integer employeeid,String saletype,String locality,List<String> propertytype,String pricein,String pricemax,String bedroom) throws Exception;
	public List<ResidentialEntity> getAllResidential(Integer dealerId) throws Exception;
	public Boolean saveClientPropertyNotification(PropertyClientMapping propertyClientMapping,String type);
	public List<PropertyClientMapping> getClientPropertyNotification();
	public ResidentialEntity getDetails(Integer residentialProductId);
	
	public Boolean deleteResidential(ResidentialEntity residentialEntity);
	public Boolean soldResidential(ResidentialEntity residentialEntity);
}
