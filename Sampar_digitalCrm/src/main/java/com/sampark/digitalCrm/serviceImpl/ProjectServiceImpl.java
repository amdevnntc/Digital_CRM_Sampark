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
import com.sampark.digitalCrm.entity.ProjectEntity;
import com.sampark.digitalCrm.entity.PropertyEntity;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.ProjectRepository;
import com.sampark.digitalCrm.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectRepository projectRepo;
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public ResponseObject saveProject(ProjectEntity project) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		if(projectRepo.saveProject(project))
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
	public ResponseObject getProjectList(Integer dealerId, Integer employeeid,Integer pageid,Integer total) throws Exception {
		List<ProjectEntity> list = new ArrayList<ProjectEntity>();
		Query query=null;
		ResponseObject rsobj=new ResponseObject();	
		
		if(employeeid!=null)
		{
			if(employeeid==0)
			{
				String sqlQuery = "select ID from tbl_project where dealer_id =:dealerId";
			
				query = getEntityManager().createNativeQuery(sqlQuery);
				query.setParameter("dealerId", dealerId);
				list = (List<ProjectEntity>) query.getResultList();
			}
			else
			{
				String sqlQuery = "select ID from tbl_project where dealer_id=:dealerId and employee_id=:employeeid";
			
				query = getEntityManager().createNativeQuery(sqlQuery);
				query.setParameter("dealerId", dealerId);
				query.setParameter("employeeid", employeeid);
				list = (List<ProjectEntity>) query.getResultList();
			}
		}
		
		Integer count=list.size();
		list=projectRepo.getProject(dealerId,employeeid,pageid,total);
		Iterator<ProjectEntity> it=list.iterator();
		ProjectEntity project=null;
		while (it.hasNext()) {
			project=new ProjectEntity();
			project=it.next();
			project.setImageUrl(digitalCrmConstant.server_url+"images?image="+project.getImagename()+"&folder=project");	
		}	
		rsobj.setObject(list);
		rsobj.setStatus(true);
		rsobj.setCount(count);
		return rsobj;
	}

	@Override
	public ResponseObject searchProjectList(Integer dealerId,Integer employeeid,String saleType,String locality,String projectType,String pricemin,String pricemax,String pricein)
			throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<ProjectEntity> list = new ArrayList<ProjectEntity>();
		list=projectRepo.searchProjectList(dealerId, employeeid,saleType,locality,projectType,pricemin,pricemax,pricein);
		
		Iterator<ProjectEntity> it=list.iterator();
		ProjectEntity project=null;
		while (it.hasNext()) {
			project=new ProjectEntity();
			project=it.next();
			project.setImageUrl(digitalCrmConstant.server_url+"images?image="+project.getImagename()+"&folder=project");	
		}	
		rsobj.setObject(list);
		rsobj.setStatus(true);
		return rsobj;
	}

}
