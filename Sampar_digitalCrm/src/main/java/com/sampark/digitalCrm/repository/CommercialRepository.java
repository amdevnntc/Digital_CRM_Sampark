package com.sampark.digitalCrm.repository;

import java.util.List;
import com.sampark.digitalCrm.entity.CommercialEntity;


public interface CommercialRepository {
	
	public Boolean saveCommercial(CommercialEntity commercial) throws Exception;
	public List<CommercialEntity> getCommercial(Integer dealerId,Integer employeeid,Integer pageid,Integer total) throws Exception;
	
	public List<List<CommercialEntity>> searchCommercialList(Integer dealerId,Integer employeeid,String pricemin,String pricemax,String pricein,String areamin,String areamax,String areain,String locality,String wantto,List<String> propertytype) throws Exception;
	
	public List<CommercialEntity> getAllCommercial(Integer dealerId) throws Exception;
	
	public CommercialEntity getDetails(Integer id);
	
	public Boolean deleteCommercial(CommercialEntity commercialEntity);
	public Boolean soldCommercial(CommercialEntity commercialEntity);
}
