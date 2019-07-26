package com.sampark.digitalCrm.service;

import com.sampark.digitalCrm.entity.BulkSmsEntity;
import com.sampark.digitalCrm.object.ResponseObject;

public interface BulkSmsService {

	public ResponseObject saveSms(BulkSmsEntity smsEntity) throws Exception;
	public ResponseObject getSmsList(Integer dealerId,Integer employeeid,String date) throws Exception;
}
