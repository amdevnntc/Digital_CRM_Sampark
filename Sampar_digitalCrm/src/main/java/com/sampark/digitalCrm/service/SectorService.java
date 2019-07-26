package com.sampark.digitalCrm.service;

import com.sampark.digitalCrm.entity.SectorEntity;
import com.sampark.digitalCrm.object.ResponseObject;

public interface SectorService {

	public ResponseObject saveSector(SectorEntity register) throws Exception;
	public ResponseObject getSectorList() throws Exception;
	
}
