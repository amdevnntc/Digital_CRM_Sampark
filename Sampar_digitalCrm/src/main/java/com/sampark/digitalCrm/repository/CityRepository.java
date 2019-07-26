package com.sampark.digitalCrm.repository;

import java.util.List;

import com.sampark.digitalCrm.entity.CityEntity;

public interface CityRepository {

	public Boolean saveCity(CityEntity register) throws Exception;

	public Boolean isCityExist(String city) throws Exception;

	public List<CityEntity> getCityList();

}
