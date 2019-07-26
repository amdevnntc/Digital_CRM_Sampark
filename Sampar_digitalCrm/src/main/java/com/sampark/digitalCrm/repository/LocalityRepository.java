package com.sampark.digitalCrm.repository;

import java.util.List;

import com.sampark.digitalCrm.entity.LocalityEntity;


public interface LocalityRepository {

	public Boolean saveLocality(LocalityEntity register) throws Exception;

	public Boolean islocalityExist(String locality) throws Exception;

	public List<LocalityEntity> getLocalityList(Integer cityid) throws Exception;

}
