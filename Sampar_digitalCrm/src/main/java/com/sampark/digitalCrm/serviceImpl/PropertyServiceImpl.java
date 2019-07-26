package com.sampark.digitalCrm.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.entity.MeetingEntity;
import com.sampark.digitalCrm.entity.ProjectEntity;
import com.sampark.digitalCrm.entity.PropertyEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.EmployeeRepository;
import com.sampark.digitalCrm.repository.PropertyRepository;
import com.sampark.digitalCrm.service.PropertyService;
@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	PropertyRepository propertyrepo;
	
	@Autowired
	EmployeeRepository employeerepo;

	
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	
	@Override
	public ResponseObject saveProperty(PropertyEntity property) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		if(propertyrepo.saveProperty(property))
		{
			rsobj.setStatus(true);
			rsobj.setMessage(digitalCrmConstant.success);
		}
		else
		{
			rsobj.setStatus(false);
			rsobj.setMessage(digitalCrmConstant.fail);
		}
		return rsobj;
	}

	@Override
	public ResponseObject getPropertyList(Integer dealerId, Integer employeeid,Integer pageid,Integer total) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<PropertyEntity> list = new ArrayList<PropertyEntity>();
		Query query=null;
		query = getEntityManager().createNativeQuery("select  id  from tbl_property where dealer_id =:dealerId");
		query.setParameter("dealerId", dealerId);
		list = (List<PropertyEntity>) query.getResultList();
		Integer count=list.size();
		System.out.println("count"+count);
		list=propertyrepo.getPropertyList(dealerId, employeeid,pageid,total);
		rsobj.setObject(list);
		rsobj.setStatus(true);
		rsobj.setCount(count);
		return rsobj;
	}

	@Override
	public ResponseObject searchPropertyList(Integer dealerId, Integer employeeid, String by, String fors)
			throws Exception {
		ResponseObject rsobj=new ResponseObject();
		List<PropertyEntity> list = new ArrayList<PropertyEntity>();
		list=propertyrepo.searchPropertyList(dealerId, employeeid,by,fors);
		
		
		rsobj.setObject(list);
		rsobj.setStatus(true);
		return rsobj;
	}

}
