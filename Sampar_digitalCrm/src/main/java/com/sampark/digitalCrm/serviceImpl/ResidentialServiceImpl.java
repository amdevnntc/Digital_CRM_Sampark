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
import com.sampark.digitalCrm.entity.PropertyClientMapping;
import com.sampark.digitalCrm.entity.ResidentialEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.ResidentialRepository;
import com.sampark.digitalCrm.service.ResidentialService;
@Service
public class ResidentialServiceImpl  implements ResidentialService{

	@Autowired
	ResidentialRepository residentialRepo;
	
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public ResponseObject saveResidential(ResidentialEntity residential) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		if(residentialRepo.saveResidential(residential))
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
	public ResponseObject getResidentialList(Integer dealerId, Integer employeeid, Integer pageid,Integer total) throws Exception {
		
		Query query=null;
		ResponseObject rsobj=new ResponseObject();
		List<ResidentialEntity> list = new ArrayList<ResidentialEntity>();
		
		if(employeeid==0)
		{
			String sqlQuery = "select ID from tbl_residential where dealer_id=:dealerId";
			query = getEntityManager().createNativeQuery(sqlQuery);
			query.setParameter("dealerId", dealerId);
			list = (List<ResidentialEntity>) query.getResultList();
		}
		else
		{
			String sqlQuery = "select ID from tbl_residential where dealer_id=:dealerId and employee_id=:employeeid";
			query = getEntityManager().createNativeQuery(sqlQuery);
			query.setParameter("dealerId", dealerId);
			query.setParameter("employeeid", employeeid);
			list = (List<ResidentialEntity>) query.getResultList();
		}
		
		Integer count=list.size();
		
		list=residentialRepo.getResidential(dealerId, employeeid,pageid,total);
		
		Iterator<ResidentialEntity> it=list.iterator();
		ResidentialEntity residential=null;
		while (it.hasNext()) {
			residential=new ResidentialEntity();
			residential=it.next();
			
			residential.setImageUrl(digitalCrmConstant.server_url+"images?image="+residential.getImage()+"&folder=residential");	
		}	
		rsobj.setObject(list);
		rsobj.setStatus(true);
		rsobj.setCount(count);
		return rsobj;
	}

	@Override
	public ResponseObject searchResidentialList(Integer dealerId, Integer employeeid, String saletype,String locality,List<String> propertytype,String pricein,String pricemax,String bedroom) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<List<ResidentialEntity>> list = new ArrayList<List<ResidentialEntity>>();
		list=residentialRepo.searchResidentialList(dealerId, employeeid,saletype,locality,propertytype,pricein,pricemax,bedroom);
		
		Iterator<List<ResidentialEntity>> it=list.iterator();
		List<ResidentialEntity> residential=null;
		while (it.hasNext()) {
			residential=new ArrayList<ResidentialEntity>();
			residential=it.next();
			
			Iterator<ResidentialEntity> it1=residential.iterator();
			while (it1.hasNext()) {
				ResidentialEntity residentialEntity = (ResidentialEntity) it1.next();
               residentialEntity.setImageUrl(digitalCrmConstant.server_url+"images?image="+residentialEntity.getImage()+"&folder=residential");
		 	}
	     	}	
		rsobj.setObject(list);
		rsobj.setStatus(true);
		return rsobj;
	}

	@Override
	public ResponseObject getAllResidential(Integer dealerid) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<ResidentialEntity> list = new ArrayList<ResidentialEntity>();
		list=residentialRepo.getAllResidential(dealerid);
		rsobj.setObject(list);
		rsobj.setStatus(true);
		return rsobj;
	}

	@Override
	public ResponseObject saveClientPropertyNotification(PropertyClientMapping propertyClientMapping) {
		
		ResponseObject rsobj=new ResponseObject();
		if(residentialRepo.saveClientPropertyNotification(propertyClientMapping,"new"))
		{
			rsobj.setStatus(true);
			
		}
		else
		{
			rsobj.setStatus(false);
			
		}
		return rsobj;
		
		
	}

	@Override
	public ResponseObject deleteResidential(ResidentialEntity residentialEntity) {
		ResponseObject rsobj=new ResponseObject();
		residentialEntity.setEnabled(digitalCrmConstant.STATUS_DEACTIVE);
		if(residentialRepo.deleteResidential(residentialEntity))
		{
			rsobj.setStatus(true);
		}
		else
		{
			rsobj.setStatus(false);	
		}
		
		
		return rsobj;
	}

	@Override
	public ResponseObject soldResidential(ResidentialEntity residentialEntity) {
		ResponseObject rsobj=new ResponseObject();
		
		residentialEntity.setSoldStatus(digitalCrmConstant.sold);
		if(residentialRepo.deleteResidential(residentialEntity))
		{
			rsobj.setStatus(true);
		}
		else
		{
			rsobj.setStatus(false);	
		}
		return rsobj;
	}

}
