package com.sampark.digitalCrm.repository;



import java.util.List;

import com.sampark.digitalCrm.entity.SectorEntity;

public interface SectorRepository {

	public Boolean saveSector(SectorEntity register) throws Exception;
	public Boolean isSectorExist(String sector) throws Exception;
	public List<SectorEntity> getSectorList();


}

