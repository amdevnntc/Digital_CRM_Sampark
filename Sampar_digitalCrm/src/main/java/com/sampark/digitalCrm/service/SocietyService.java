package com.sampark.digitalCrm.service;

import com.sampark.digitalCrm.entity.SocietyEntity;
import com.sampark.digitalCrm.object.ResponseObject;

public interface SocietyService {
	
	public ResponseObject saveSociety(SocietyEntity register) throws Exception;
	public ResponseObject getSocietyList(Integer sectorId) throws Exception;


}
