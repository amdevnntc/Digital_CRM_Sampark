package com.sampark.digitalCrm.repositoryImpl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.entity.MeetingEntity;
import com.sampark.digitalCrm.entity.PropertyEntity;
import com.sampark.digitalCrm.repository.PropertyRepository;
@Repository
public class PropertyRepositoryImpl  implements PropertyRepository{

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	@Transactional
	public Boolean saveProperty(PropertyEntity property) throws Exception {
		Boolean flag=null;
	
		if(property.getId()!=null)
		{
			entityManager.merge(property);
			flag=true;
		}
		else
		{
			entityManager.persist(property);
			if (property.getId() > 0) {
				flag=true;
			} else {
				flag=false;
			}
		}
		return flag;
	}

	@Override
	public List<PropertyEntity> getPropertyList(Integer dealerId, Integer employeeid,Integer pageid,Integer total) throws Exception {
		List<PropertyEntity> list = new ArrayList<PropertyEntity>();
		
		if(employeeid!=null)
		{
			if(employeeid==0)
			{
				String sqlQuery = "select * from tbl_property where dealer_id=:dealerId  limit "+(pageid-1)+","+total;
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, PropertyEntity.class);
				query.setParameter("dealerId", dealerId);
				list = (List<PropertyEntity>) query.getResultList();
				
			}
			else
			{
				String sqlQuery = "select * from tbl_property where dealer_id=:dealerId and employee_id=:employeeid limit "+(pageid-1)+","+total;
				Query query = null;
				query = getEntityManager().createNativeQuery(sqlQuery, PropertyEntity.class);
				query.setParameter("dealerId", dealerId);
				query.setParameter("employeeid", employeeid);
				list = (List<PropertyEntity>) query.getResultList();
			}
		}
		return list;
	}

	@Override
	public List<PropertyEntity> searchPropertyList(Integer dealerId, Integer employeeid, String by, String fors)
			throws Exception {
		List<PropertyEntity> list = new ArrayList<PropertyEntity>();
		
		if(employeeid!=null)
		{
			if(employeeid==0)
			{
				
				if(by.equals("Residential") ||by.equals("Commercial"))
				{
					String sqlQuery = "select * from tbl_property where dealer_id=:dealerId and project_type=:by and property_type=:fors";
					Query query = null;
					query = getEntityManager().createNativeQuery(sqlQuery, PropertyEntity.class);
					query.setParameter("dealerId",dealerId);
					query.setParameter("by",by);
					query.setParameter("fors",fors);
					list = (List<PropertyEntity>) query.getResultList();
				}
				
				else
				{
					String sqlQuery = "select * from tbl_property where dealer_id=:dealerId and bhk=:bhk";
					Query query = null;
					query = getEntityManager().createNativeQuery(sqlQuery, PropertyEntity.class);
					query.setParameter("dealerId", dealerId);
					query.setParameter("bhk",fors);
					list = (List<PropertyEntity>) query.getResultList();
				}
				
				
				
			
				
			}
			else
			{
				
				if(by.equals("residential") ||by.equals("commercial"))
				{
					String sqlQuery = "select * from tbl_property where dealer_id=:dealerId and project_type=:by and property_type=:fors";
					Query query = null;
					query = getEntityManager().createNativeQuery(sqlQuery, PropertyEntity.class);
					query.setParameter("dealerId",dealerId);
					query.setParameter("by",by);
					query.setParameter("fors",fors);
					list = (List<PropertyEntity>) query.getResultList();
				}
				else
				{
					String sqlQuery = "select * from tbl_property where dealer_id=:dealerId and bhk=:bhk";
					Query query = null;
					query = getEntityManager().createNativeQuery(sqlQuery, PropertyEntity.class);
					query.setParameter("dealerId", dealerId);
					query.setParameter("bhk",fors);
					list = (List<PropertyEntity>) query.getResultList();
				}	
			}
		}
		return list;
	}

}
