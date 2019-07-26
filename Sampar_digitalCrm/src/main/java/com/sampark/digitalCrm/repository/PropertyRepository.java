package com.sampark.digitalCrm.repository;

import java.util.List;

import com.sampark.digitalCrm.entity.PropertyEntity;

public interface PropertyRepository {
	
	public Boolean saveProperty(PropertyEntity property) throws Exception;
	public List<PropertyEntity> getPropertyList(Integer dealerId,Integer employeeid,Integer pageid,Integer total) throws Exception;
	
	public List<PropertyEntity> searchPropertyList(Integer dealerId,Integer employeeid,String by,String fors) throws Exception;

}
