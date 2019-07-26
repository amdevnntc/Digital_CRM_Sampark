package com.sampark.digitalCrm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.entity.SectorEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.SectorRepository;
import com.sampark.digitalCrm.service.SectorService;


@Service
public class SectorServiceImpl implements SectorService{

	@Autowired
	SectorRepository sectorrepo;

	@Override
	public ResponseObject saveSector(SectorEntity register) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		if(sectorrepo.saveSector(register))
		{
			rsobj.setStatus(true);
			rsobj.setMessage("success");
			rsobj.setObject(sectorrepo.getSectorList());
		}
		else
		{
			rsobj.setStatus(false);
			rsobj.setMessage("something went wrong");
		}
		
		return rsobj;
	}

@Override
public ResponseObject getSectorList() throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<SectorEntity> list = new ArrayList<SectorEntity>();
		list=sectorrepo.getSectorList();
		rsobj.setObject(list);
		rsobj.setStatus(true);
		 
		 return rsobj;
	}


}
