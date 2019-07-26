package com.sampark.digitalCrm.repository;

import java.util.List;

import com.sampark.digitalCrm.entity.SocietyEntity;

public interface SocietyRepository {

	public Boolean saveSociety(SocietyEntity register) throws Exception;
	public Boolean isSocietyExist(String society) throws Exception;
	public List<SocietyEntity> getSocietyList(Integer sectorId) throws Exception;

}
