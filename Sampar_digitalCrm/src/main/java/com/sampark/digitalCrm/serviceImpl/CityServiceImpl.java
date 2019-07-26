package com.sampark.digitalCrm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.entity.CityEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.CityRepository;
import com.sampark.digitalCrm.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepository sectorrepo;

	@Override
	public ResponseObject saveCity(CityEntity register) throws Exception {

		ResponseObject rsobj = new ResponseObject();
		if (sectorrepo.saveCity(register)) {
			rsobj.setStatus(true);
			rsobj.setMessage("success");
			rsobj.setObject(sectorrepo.getCityList());
		} else {
			rsobj.setStatus(false);
			rsobj.setMessage("something went wrong");
		}

		return rsobj;
	}

	@Override
	public ResponseObject getCityList() throws Exception {

		ResponseObject rsobj = new ResponseObject();
		List<CityEntity> list = new ArrayList<CityEntity>();
		list = sectorrepo.getCityList();
		rsobj.setObject(list);
		rsobj.setStatus(true);

		return rsobj;
	}

}
