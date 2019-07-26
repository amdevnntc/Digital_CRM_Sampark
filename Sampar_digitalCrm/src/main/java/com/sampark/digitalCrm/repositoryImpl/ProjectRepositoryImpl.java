package com.sampark.digitalCrm.repositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.sampark.digitalCrm.entity.ProjectEntity;
import com.sampark.digitalCrm.repository.ProjectRepository;
@Repository
public class ProjectRepositoryImpl  implements ProjectRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	@Transactional
	public Boolean saveProject(ProjectEntity projectEntity) throws Exception {
		Boolean flag=null;
	
		if(projectEntity.getId()!=null)
		{
			projectEntity.setModifiedon(new Date());
			entityManager.merge(projectEntity);
			flag=true;
		}
		else
		{
			projectEntity.setModifiedon(new Date());
			entityManager.persist(projectEntity);
			if (projectEntity.getId() > 0) {
				flag=true;
			} else {
				flag=false;
			}
		}
		return flag;
	}

	@Override
	public List<ProjectEntity> getProject(Integer dealerId, Integer employeeid,Integer pageid,Integer total) throws Exception {
		List<ProjectEntity> list = new ArrayList<ProjectEntity>();
		Query query = null;
	
		if(employeeid!=null)
		{
			if(employeeid==0)
			{
				String sqlQuery = "select * from tbl_project where dealer_id =:dealerId   ORDER BY ID DESC limit "+(pageid-1)+","+total;
			
				query = getEntityManager().createNativeQuery(sqlQuery, ProjectEntity.class);
				query.setParameter("dealerId", dealerId);
				list = (List<ProjectEntity>) query.getResultList();
			}
			else
			{
				String sqlQuery = "select * from tbl_project where dealer_id=:dealerId and employee_id=:employeeid   ORDER BY ID DESC  limit "+(pageid-1)+","+total;
			
				query = getEntityManager().createNativeQuery(sqlQuery, ProjectEntity.class);
				query.setParameter("dealerId", dealerId);
				query.setParameter("employeeid", employeeid);
				list = (List<ProjectEntity>) query.getResultList();
			}
		}
		return list;
	}
	@Override
	public List<ProjectEntity> searchProjectList(Integer dealerId,Integer employeeid,String saleType,String locality,String projectType,String pricemin,String pricemax,String pricein) throws Exception {
		List<ProjectEntity> list = new ArrayList<ProjectEntity>();
		Query query = null;
		
		if(employeeid!=null)
		{
			if(employeeid==0)
			{
				String sqlQuery = "select * from tbl_project where dealer_id=:dealerId and bookingtype =:bookingtype and locality Like:locality and project_type=:projectType and price between :pricemin and :pricemax and price_In=:pricein ORDER BY ID DESC";
				query = getEntityManager().createNativeQuery(sqlQuery, ProjectEntity.class);
				query.setParameter("dealerId", dealerId);
				query.setParameter("bookingtype", saleType);
				query.setParameter("locality","%"+locality+"%");
				query.setParameter("projectType", projectType);
				query.setParameter("pricemin", pricemin);
				query.setParameter("pricemax", pricemax);
				query.setParameter("pricein", pricein);
				list = (List<ProjectEntity>) query.getResultList();
			}
			else
			{
				String sqlQuery = "select * from tbl_project where dealer_id=:dealerId and employee_id=:employeeid and bookingtype =:bookingtype and locality Like:locality and project_type=:projectType and price between :pricemin and :pricemax and price_In=:pricein ORDER BY ID DESC";
				query = getEntityManager().createNativeQuery(sqlQuery, ProjectEntity.class);
				query.setParameter("dealerId", dealerId);
				query.setParameter("employeeid", employeeid);
				query.setParameter("bookingtype", saleType);
				query.setParameter("locality","%"+locality+"%");
				query.setParameter("projectType", projectType);
				query.setParameter("pricemin", pricemin);
				query.setParameter("pricemax", pricemax);
				query.setParameter("pricein", pricein);
				list = (List<ProjectEntity>) query.getResultList();
			}
		}
		return list;
	}

}
