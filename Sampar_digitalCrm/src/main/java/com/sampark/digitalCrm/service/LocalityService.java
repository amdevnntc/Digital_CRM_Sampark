package com.sampark.digitalCrm.service;

import com.sampark.digitalCrm.entity.LocalityEntity;
import com.sampark.digitalCrm.object.ResponseObject;

public interface LocalityService {

	public ResponseObject saveLocality(LocalityEntity register) throws Exception;

	public ResponseObject getLocalityList(Integer city) throws Exception;

}
