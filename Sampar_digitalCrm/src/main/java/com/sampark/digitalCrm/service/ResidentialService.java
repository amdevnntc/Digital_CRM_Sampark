package com.sampark.digitalCrm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.entity.PropertyClientMapping;
import com.sampark.digitalCrm.entity.ResidentialEntity;
import com.sampark.digitalCrm.object.ResponseObject;

@Service
public interface ResidentialService {
	
	public ResponseObject saveResidential(ResidentialEntity residential) throws Exception;
	public ResponseObject getResidentialList(Integer dealerId,Integer employeeid,Integer pageid,Integer total) throws Exception;
	
	public ResponseObject searchResidentialList(Integer dealerId,Integer employeeid,String saletype,String locality,List<String> propertytype,String pricein,String pricemax,String bedroom) throws Exception;
	
	public ResponseObject saveClientPropertyNotification(PropertyClientMapping propertyClientMapping);
	
	public ResponseObject getAllResidential(Integer dealerid) throws Exception;
	
	public ResponseObject deleteResidential(ResidentialEntity residentialEntity);
	public ResponseObject soldResidential(ResidentialEntity residentialEntity);
}
