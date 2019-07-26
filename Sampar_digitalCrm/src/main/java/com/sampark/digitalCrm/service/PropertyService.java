package com.sampark.digitalCrm.service;

import com.sampark.digitalCrm.entity.PropertyEntity;
import com.sampark.digitalCrm.object.ResponseObject;

public interface PropertyService {

	public ResponseObject saveProperty(PropertyEntity property) throws Exception;
	public ResponseObject getPropertyList(Integer dealerId,Integer employeeid,Integer pageid,Integer total) throws Exception;
	
	public ResponseObject searchPropertyList(Integer dealerId,Integer employeeid,String by,String fors) throws Exception;
}
