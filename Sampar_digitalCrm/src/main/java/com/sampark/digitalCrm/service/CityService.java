package com.sampark.digitalCrm.service;

import com.sampark.digitalCrm.entity.CityEntity;
import com.sampark.digitalCrm.object.ResponseObject;

public interface CityService {

	public ResponseObject saveCity(CityEntity register) throws Exception;

	public ResponseObject getCityList() throws Exception;

}
