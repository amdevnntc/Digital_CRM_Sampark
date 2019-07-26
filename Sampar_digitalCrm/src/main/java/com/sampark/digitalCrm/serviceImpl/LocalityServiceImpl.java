package com.sampark.digitalCrm.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sampark.digitalCrm.entity.LocalityEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.LocalityRepository;
import com.sampark.digitalCrm.service.LocalityService;

@Service
public class LocalityServiceImpl implements LocalityService {
	private static final Logger logger = LoggerFactory.getLogger(LocalityServiceImpl.class);

	@Autowired
	LocalityRepository localityrepo;

	@Autowired
	LocalityService localityservice;

	@Override
	public ResponseObject saveLocality(LocalityEntity register) throws Exception {

		ResponseObject rsobj = new ResponseObject();
		if (localityrepo.saveLocality(register)) {
			rsobj.setStatus(true);
			rsobj.setMessage("success");
			rsobj.setObject(localityrepo.getLocalityList(register.getLocalityid()));
		} else {
			rsobj.setStatus(false);
			rsobj.setMessage("something went wrong");
		}

		return rsobj;
	}

	@Override
	public ResponseObject getLocalityList(Integer cityid) throws Exception {
		ResponseObject rsobj = new ResponseObject();

		List<LocalityEntity> list = localityrepo.getLocalityList(cityid);
		logger.info("Success locality data fetched ");
		rsobj.setObject(list);
		return rsobj;
	}

}
