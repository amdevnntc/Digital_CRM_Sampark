package com.sampark.digitalCrm.repository;

import java.util.List;

import com.sampark.digitalCrm.entity.BulkSmsEntity;

public interface BulkSmsRepository {
	
	
	public Boolean saveSms(BulkSmsEntity smsEntity);
	public List<BulkSmsEntity> getSmsList(Integer dealerId,Integer employeeid,String date);

}
