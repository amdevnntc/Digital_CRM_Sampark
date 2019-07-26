package com.sampark.digitalCrm.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.entity.CommercialEntity;
import com.sampark.digitalCrm.repository.CommercialRepository;

@Repository
public class CommercialRepositoryImpl implements CommercialRepository {

	

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	@Transactional
	public Boolean saveCommercial(CommercialEntity commercial) throws Exception {
		Boolean flag=null;
	
		if(commercial.getId()!=null)
		{
			entityManager.merge(commercial);
			flag=true;
		}
		else
		{
			commercial.setId(null);
			entityManager.persist(commercial);
			if (commercial.getId() > 0) {
				flag=true;
				
				
			} else {
				flag=false;
			}
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommercialEntity> getCommercial(Integer dealerId, Integer employeeid,Integer pageid,Integer total) throws Exception {
		List<CommercialEntity> list = new ArrayList<CommercialEntity>();
		Query query = null;
		if(employeeid!=null)
		{
			if(employeeid==0)
			{
				String sqlQuery = "select * from tbl_commercial where dealer_id=:dealerId and sold_Status='1' and enabled='1' ORDER BY ID DESC limit "+(pageid-1)+","+total;
				query = getEntityManager().createNativeQuery(sqlQuery, CommercialEntity.class);
				query.setParameter("dealerId", dealerId);
				list = (List<CommercialEntity>) query.getResultList();
				
			}
			else
			{
				String sqlQuery = "select * from tbl_commercial where dealer_id=:dealerId and employee_id=:employeeid and sold_Status='1' and enabled='1' ORDER BY ID DESC limit "+(pageid-1)+","+total;
				query = getEntityManager().createNativeQuery(sqlQuery, CommercialEntity.class);
				query.setParameter("dealerId", dealerId);
				query.setParameter("employeeid", employeeid);
				list = (List<CommercialEntity>) query.getResultList();
			}
		}
		return list;
	}

	@Override
	public List<List<CommercialEntity>> searchCommercialList(Integer dealerId,Integer employeeid,String pricemin,String pricemax,String pricein,String areamin,String areamax,String areain,String locality,String wantto,List<String> propertytype) throws Exception {
		
		List<List<CommercialEntity>> list1 = new ArrayList<List<CommercialEntity>>();
		List<CommercialEntity> list = new ArrayList<CommercialEntity>();
		Query query = null;
		if(employeeid!=null)
		{
			for (String property : propertytype)
			{
				
				if(employeeid==0)
				{
					String sqlQuery = "select * from tbl_commercial where dealer_id=:dealerId  and propertytype=:propertytype and locality Like:locality and wantto=:wantto and areatype=:areatype  and pricein=:pricein  and price between :pricemin and :pricemax and area between :areamin and :areamax and sold_Status='1' and enabled='1'";
					query = getEntityManager().createNativeQuery(sqlQuery, CommercialEntity.class);
					query.setParameter("dealerId", dealerId);
					query.setParameter("locality","%"+locality+"%");
					query.setParameter("wantto", wantto);
					query.setParameter("areatype", areain);
					query.setParameter("pricein", pricein);
					query.setParameter("pricemin", pricemin);
					query.setParameter("pricemax", pricemax);
					query.setParameter("areamin", areamin);
					query.setParameter("areamax", areamax);
					query.setParameter("propertytype", property);
					list = (List<CommercialEntity>) query.getResultList();
					list1.add(list);
				}
				else
				{
					String sqlQuery = "select * from tbl_commercial where dealer_id=:dealerId and employee_id=:employeeid and propertytype=:propertytype and locality Like:locality and wantto=:wantto and areatype=:areatype  and pricein=:pricein and price between :pricemin and :pricemax and area between :areamin and :areamax and sold_Status='1' and enabled='1'";
					query = getEntityManager().createNativeQuery(sqlQuery, CommercialEntity.class);
					query.setParameter("dealerId", dealerId);
					query.setParameter("employeeid", employeeid);
					query.setParameter("locality","%"+locality+"%");
					query.setParameter("wantto", wantto);
					query.setParameter("areatype", areain);
					query.setParameter("pricein", pricein);
					query.setParameter("pricemin", pricemin);
					query.setParameter("pricemax", pricemax);
					query.setParameter("areamin", areamin);
					query.setParameter("areamax", areamax);
					query.setParameter("propertytype",property);
					list = (List<CommercialEntity>) query.getResultList();
					list1.add(list);
				}
				
				
			}
			
			
			
			
			
			System.out.println(list);
		}
		return list1;
	}
	@Override
	public List<CommercialEntity> getAllCommercial(Integer dealerId) throws Exception {
		List<CommercialEntity> list = new ArrayList<CommercialEntity>();
		Query query = null;
			String sqlQuery = "select propertytype from tbl_commercial where dealer_id=:dealerid and sold_Status='1' and enabled='1'";
			
				query = getEntityManager().createNativeQuery(sqlQuery);
				query.setParameter("dealerid", dealerId);
				list = (List<CommercialEntity>) query.getResultList();
			
		return list;
	}

	@Override
	public CommercialEntity getDetails(Integer id) {
		CommercialEntity commercialEntity = new CommercialEntity();
		Query query = null;
			String sqlQuery = "select * from tbl_commercial where ID=:id and sold_Status='1' and enabled='1'";
				query = getEntityManager().createNativeQuery(sqlQuery,CommercialEntity.class);
				query.setParameter("id", id);
				commercialEntity = (CommercialEntity) query.getSingleResult();
		return commercialEntity;
	}

	@Override
	@Transactional
	public Boolean deleteCommercial(CommercialEntity commercialEntity) {
		commercialEntity.setImage(commercialEntity.getImgUrl().trim());
		entityManager.merge(commercialEntity);
		return true;
	}

	@Override
	@Transactional
	public Boolean soldCommercial(CommercialEntity commercialEntity) {
		commercialEntity.setImage(commercialEntity.getImgUrl().trim());
		entityManager.merge(commercialEntity);
		return true;
	}

}
