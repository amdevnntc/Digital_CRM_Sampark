package com.sampark.digitalCrm.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.entity.BadgeEntity;
import com.sampark.digitalCrm.entity.TokenBean;
import com.sampark.digitalCrm.repository.TokenRepository;


@Repository
public class TokenRepositoryImpl implements TokenRepository {

	

	@PersistenceContext
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	@Transactional
	public String saveToken(TokenBean tokenBean) throws Exception {
		BadgeEntity badgeEntity=new BadgeEntity();
		String msg=null;
		if(tokenBean.getId()!=null)
		{
			entityManager.merge(tokenBean);
			
			if(tokenBean.getDeviceType().equalsIgnoreCase("IOS"))
			{
				badgeEntity=badgeDetails(tokenBean.getDealerid(),tokenBean.getEmployeeid());
				updateBadge(badgeEntity);
			}
		
			msg="success";
		}
		else
		{
			entityManager.persist(tokenBean);
			
			if(tokenBean.getDeviceType().equalsIgnoreCase("IOS"))
			{
				badgeEntity=badgeDetails(tokenBean.getDealerid(),tokenBean.getEmployeeid());
				if(badgeEntity!=null)
				{
					updateBadge(badgeEntity);
				}
				else
				{
					BadgeEntity badgeEntity2=new BadgeEntity();
					badgeEntity2.setDealerId(tokenBean.getDealerid());
					badgeEntity2.setEmployeeId(tokenBean.getEmployeeid());
					badgeEntity2.setBadgeCount(0);
					saveBadge(badgeEntity2);
				}
				
			}
		
			if(tokenBean.getId()>0)
			{
				msg="success";
				
			}
			else
			{
				msg="fail";
			}
		}
		return msg;
		
	}
	
	@Transactional
	private void updateBadge(BadgeEntity badgeEntity)
	{
		badgeEntity.setBadgeCount(0);
		entityManager.merge(badgeEntity);
	}

	@Override
	public TokenBean getToken(TokenBean tokenBean) throws Exception {
		
		TokenBean  tokenBean1 = new TokenBean();
			
			Query query = null;
			
			
		
			
			
			try {
				if(tokenBean.getEmployeeid()==0)
				{
					
					query = getEntityManager().createNativeQuery("Select * from device_token where dealer_id=:dealerid and employee_id=:employeeId and  device_Type=:devicetype",TokenBean.class);
					query.setParameter("dealerid", tokenBean.getDealerid());
					query.setParameter("devicetype", tokenBean.getDeviceType());
					query.setParameter("employeeId", tokenBean.getEmployeeid());
					tokenBean1 = (TokenBean)query.getSingleResult();
					System.out.println(tokenBean1);
					return tokenBean1;
				
				}
				else
				{
					query = getEntityManager().createNativeQuery("Select * from device_token where dealer_id=:dealerid and employee_id=:employeeId and  device_Type=:devicetype",TokenBean.class);
					query.setParameter("dealerid", tokenBean.getDealerid());
					query.setParameter("devicetype", tokenBean.getDeviceType());
					query.setParameter("employeeId", tokenBean.getEmployeeid());
					tokenBean1 = (TokenBean)query.getSingleResult();
					System.out.println(tokenBean1);
					return tokenBean1;
				}
				
			} catch (NoResultException e) {
				
				e.printStackTrace();
				return null;
				
			}
			
	}
	@Override
	public List<TokenBean> getTokenByEmployeeid(Integer employeeid) throws Exception {
		List<TokenBean>  tokenBean = new ArrayList<TokenBean>();
			Query query = null;
			query = getEntityManager().createNativeQuery("Select * from device_token where employee_id=:employeeid",TokenBean.class);
			query.setParameter("employeeid",employeeid);
			tokenBean = (List<TokenBean>)query.getResultList();
			return tokenBean;
	}

	@Override
	public List<TokenBean> getTokenByDealrid(Integer dealerId) throws Exception {
		List<TokenBean>  tokenBean = new ArrayList<TokenBean>();
		Query query = null;
		query = getEntityManager().createNativeQuery("Select * from device_token where dealer_id=:dealerid and employee_id='0'",TokenBean.class);
		query.setParameter("dealerid",dealerId);
		tokenBean = (List<TokenBean>)query.getResultList();
		return tokenBean;
}

	@Override
	@Transactional
	public Boolean saveBadge(BadgeEntity badgeEntity) {
		if(badgeEntity.getId()!=null)
		{
			entityManager.merge(badgeEntity);
		}
		else
		{
			entityManager.persist(badgeEntity);
		}
		return true;
	}

	@Override
	public BadgeEntity badgeDetails(Integer dealerId, Integer employeeId) {
		BadgeEntity badgeEntity=new BadgeEntity();
		Query query = null;
		
		
		try {
			if(employeeId==0)
			{
				query = getEntityManager().createNativeQuery("Select * from tbl_badge where dealer_Id=:dealerid and employee_id='0'",BadgeEntity.class);
				query.setParameter("dealerid",dealerId);
				badgeEntity = (BadgeEntity)query.getSingleResult();
			}
			else
			{
				query = getEntityManager().createNativeQuery("Select * from tbl_badge where dealer_Id=:dealerid and employee_id=:employeeId",BadgeEntity.class);
				query.setParameter("dealerid",dealerId);
				query.setParameter("employeeId",employeeId);
				badgeEntity = (BadgeEntity)query.getSingleResult();
			}
			return badgeEntity;
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		
}

}
