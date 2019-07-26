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
import com.sampark.digitalCrm.entity.CommercialEntity;
import com.sampark.digitalCrm.entity.ResidentialEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.CommercialRepository;
import com.sampark.digitalCrm.service.CommercialService;

@Service
public class CommercialServiceImpl implements CommercialService {
	
	@Autowired
	CommercialRepository commercialrepo;


	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public ResponseObject saveCommercial(CommercialEntity commercial) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		if(commercialrepo.saveCommercial(commercial))
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
	public ResponseObject getCommercialList(Integer dealerId, Integer employeeid,Integer pageid,Integer total) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<CommercialEntity> list = new ArrayList<CommercialEntity>();
		Query query=null;
		if(employeeid!=null)
		{
			if(employeeid==0)
			{
				String sqlQuery = "select ID from tbl_commercial where dealer_id=:dealerId";
				query = getEntityManager().createNativeQuery(sqlQuery);
				query.setParameter("dealerId", dealerId);
				list = (List<CommercialEntity>) query.getResultList();
				
			}
			else
			{
				String sqlQuery = "select ID from tbl_commercial where dealer_id=:dealerId and employee_id=:employeeid";
				query = getEntityManager().createNativeQuery(sqlQuery);
				query.setParameter("dealerId", dealerId);
				query.setParameter("employeeid", employeeid);
				list = (List<CommercialEntity>) query.getResultList();
			}
		}
		
		Integer count=list.size();
		list=commercialrepo.getCommercial(dealerId, employeeid,pageid,total);
		
		Iterator<CommercialEntity> it=list.iterator();
		CommercialEntity commercial=null;
		while (it.hasNext()) {
			commercial=new CommercialEntity();
			commercial=it.next();
			commercial.setImgUrl(commercial.getImage());
			commercial.setImage(digitalCrmConstant.server_url+"images?image="+commercial.getImage()+"&folder=commercial");	
		}	
		rsobj.setObject(list);
		rsobj.setCount(count);
		rsobj.setStatus(true);
		return rsobj;
	}

	@Override
	public ResponseObject searchCommercialList(Integer dealerId,Integer employeeid,String pricemin,String pricemax,String pricein,String areamin,String areamax,String areain,String locality,String wantto,List<String> propertytype) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<List<CommercialEntity>> list1 = new ArrayList<List<CommercialEntity>>();
		
		List<CommercialEntity> list = new ArrayList<CommercialEntity>();
		list1=commercialrepo.searchCommercialList(dealerId,employeeid,pricemin,pricemax,pricein,areamin,areamax,areain,locality,wantto,propertytype);
		
		Iterator<List<CommercialEntity>> it=list1.iterator();
		List<CommercialEntity> Commercial=null;
		while (it.hasNext()) {
			Commercial=new ArrayList<CommercialEntity>();
			Commercial=it.next();
			
			Iterator<CommercialEntity> it1=Commercial.iterator();
			while (it1.hasNext()) {
				CommercialEntity CommercialEntity = (CommercialEntity) it1.next();
				CommercialEntity.setImgUrl(CommercialEntity.getImage());
				CommercialEntity.setImage(digitalCrmConstant.server_url+"images?image="+CommercialEntity.getImage()+"&folder=commercial");
				
			}
	     	}	
		rsobj.setObject(list1);
		rsobj.setStatus(true);
		return rsobj;
	}

	@Override
	public ResponseObject getAllCommercial(Integer dealerId) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<CommercialEntity> list = new ArrayList<CommercialEntity>();
		list=commercialrepo.getAllCommercial(dealerId);
		rsobj.setObject(list);
		rsobj.setStatus(true);
		return rsobj;
	}

	@Override
	public ResponseObject deleteCommercial(CommercialEntity commercialEntity) {
		
		ResponseObject rsObject=new ResponseObject();
		commercialEntity.setEnabled(digitalCrmConstant.STATUS_DEACTIVE);
		if(commercialrepo.deleteCommercial(commercialEntity))
		{
			rsObject.setStatus(true);
		}
		else
		{
			rsObject.setStatus(false);
		}
		
		return rsObject;
	}

	@Override
	public ResponseObject soldCommercial(CommercialEntity commercialEntity) {
		ResponseObject rsObject=new ResponseObject();
		commercialEntity.setSoldStatus(digitalCrmConstant.sold);
		if(commercialrepo.soldCommercial(commercialEntity))
		{
			rsObject.setStatus(true);
		}
		else
		{
			rsObject.setStatus(false);
		}
		
		return rsObject;
	}

}
