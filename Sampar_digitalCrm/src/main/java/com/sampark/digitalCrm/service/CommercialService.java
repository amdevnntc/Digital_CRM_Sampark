package com.sampark.digitalCrm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.entity.CommercialEntity;
import com.sampark.digitalCrm.object.ResponseObject;

@Service
public interface CommercialService {
	
	public ResponseObject saveCommercial(CommercialEntity commercial) throws Exception;
	public ResponseObject getCommercialList(Integer dealerId,Integer employeeid,Integer pageid,Integer total) throws Exception;
	
	public ResponseObject searchCommercialList(Integer dealerId,Integer employeeid,String pricemin,String pricemax,String pricein,String areamin,String areamax,String areain,String locality,String wantto,List<String> propertytype ) throws Exception;
	
	public ResponseObject getAllCommercial(Integer dealerId) throws Exception;
	
	
	public ResponseObject deleteCommercial(CommercialEntity commercialEntity);
	public ResponseObject soldCommercial(CommercialEntity commercialEntity);
}
