package com.sampark.digitalCrm.repositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sampark.digitalCrm.entity.PropertyClientMapping;
import com.sampark.digitalCrm.entity.ResidentialEntity;
import com.sampark.digitalCrm.repository.ResidentialRepository;

@Repository
public class ResidentialRepositoryImpl implements ResidentialRepository {

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	@Transactional
	public Boolean saveResidential(ResidentialEntity residential) throws Exception {
		Boolean flag = null;

		if (residential.getId() != null) {
			entityManager.merge(residential);
			flag = true;
		} else {
			entityManager.persist(residential);
			if (residential.getId() > 0) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResidentialEntity> getResidential(Integer dealerId, Integer employeeid, Integer pageid, Integer total)
			throws Exception {
		List<ResidentialEntity> list = new ArrayList<ResidentialEntity>();
		Query query = null;
		if (employeeid != null) {
			if (employeeid == 0) {
				String sqlQuery = "select * from tbl_residential where dealer_id=:dealerId and enabled='1' and sold_Status='1'  ORDER BY ID DESC  limit "
						+ (pageid - 1) + "," + total;

				query = getEntityManager().createNativeQuery(sqlQuery, ResidentialEntity.class);
				query.setParameter("dealerId", dealerId);
				list = (List<ResidentialEntity>) query.getResultList();

			} else {
				String sqlQuery = "select * from tbl_residential where dealer_id=:dealerId and employee_id=:employeeid and enabled='1' and sold_Status='1' ORDER BY ID DESC  limit "
						+ (pageid - 1) + "," + total;

				query = getEntityManager().createNativeQuery(sqlQuery, ResidentialEntity.class);
				query.setParameter("dealerId", dealerId);
				query.setParameter("employeeid", employeeid);
				list = (List<ResidentialEntity>) query.getResultList();
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<List<ResidentialEntity>> searchResidentialList(Integer dealerId, Integer employeeid, String saletype,
			String locality, List<String> propertytype, String pricein, String pricemax, String bedroom)
			throws Exception {
		List<List<ResidentialEntity>> list = new ArrayList<List<ResidentialEntity>>();
		List<ResidentialEntity> list1 = new ArrayList<ResidentialEntity>();
		String[] price = pricemax.split(",");
		if (employeeid != null) {
			Iterator<String> it = propertytype.iterator();
			while (it.hasNext()) {
				String property = (String) it.next();
				if (employeeid == 0) {
					String sqlQuery = "select * from tbl_residential where dealer_id=:dealerId and saletype=:saletype and locality Like:locality and property_type=:property and price between :pricemin and :pricemax and price_in=:pricein and bedroom=:bedroom and enabled='1' and sold_Status='1'";
					Query query = null;
					query = getEntityManager().createNativeQuery(sqlQuery, ResidentialEntity.class);
					query.setParameter("dealerId", dealerId);
					query.setParameter("saletype", saletype);
					query.setParameter("locality", "%" + locality + "%");
					query.setParameter("property", property);
					query.setParameter("pricemin", price[0].trim());
					query.setParameter("pricemax", price[1].trim());
					query.setParameter("pricein", pricein);
					query.setParameter("bedroom", bedroom);

					try {
						list1 = (List<ResidentialEntity>) query.getResultList();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

					System.out.println(list1);
					list.add(list1);
				} else {
					String sqlQuery = "select * from tbl_residential where dealer_id=:dealerId and employee_id=:employeeid and saletype=:saletype and locality Like:locality and property_type=:property and price between :pricemin and :pricemax and price_in=:pricein and bedroom=:bedroom and enabled='1' and sold_Status='1'";
					Query query = null;
					query = getEntityManager().createNativeQuery(sqlQuery, ResidentialEntity.class);
					query.setParameter("dealerId", dealerId);
					query.setParameter("employeeid", employeeid);
					query.setParameter("saletype", saletype);
					query.setParameter("locality", "%" + locality + "%");
					query.setParameter("property", property);
					query.setParameter("pricemin", price[0].trim());
					query.setParameter("pricemax", price[1].trim());
					query.setParameter("pricein", pricein);
					query.setParameter("bedroom", bedroom);
					list1 = (List<ResidentialEntity>) query.getResultList();
					list.add(list1);
				}

			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResidentialEntity> getAllResidential(Integer dealerId) throws Exception {
		List<ResidentialEntity> list = new ArrayList<ResidentialEntity>();
		Query query = null;
		String sqlQuery = "select property_type from tbl_residential where dealer_id=:dealerid and enabled='1' and sold_Status='1'";

		query = getEntityManager().createNativeQuery(sqlQuery);
		query.setParameter("dealerid", dealerId);
		list = (List<ResidentialEntity>) query.getResultList();

		return list;
	}

	@Override
	@Transactional
	public Boolean saveClientPropertyNotification(PropertyClientMapping propertyClientMapping, String type) {

		PropertyClientMapping clientMapping = null;

		if (type.equalsIgnoreCase("new")) {
			Iterator<String> it = propertyClientMapping.getClientid().iterator();
			while (it.hasNext()) {
				String clientid = (String) it.next();

				Iterator<String> it1 = propertyClientMapping.getResidentProductid().iterator();
				while (it1.hasNext()) {
					clientMapping = new PropertyClientMapping();
					String residentproprtyid = (String) it1.next();
					clientMapping.setClientId(Integer.valueOf(clientid));
					clientMapping.setProductId(Integer.valueOf(residentproprtyid));
					clientMapping.setStatus(0);
					clientMapping.setModifiedOn(new Date());
					clientMapping.setCreatedOn(new Date());
					clientMapping.setDealerid(propertyClientMapping.getDealerid());
					clientMapping.setEmployeeid(propertyClientMapping.getEmployeeid());
					clientMapping.setType(propertyClientMapping.getType());
					clientMapping.setProductType(propertyClientMapping.getProductType());
					clientMapping.setEnquiryFor(propertyClientMapping.getEnquiryFor());
					entityManager.persist(clientMapping);

				}
			}

			if (clientMapping.getId() > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			entityManager.merge(propertyClientMapping);

			if (propertyClientMapping.getId() > 0) {
				return true;
			} else {
				return false;
			}
		}

	}

	@Override
	public ResidentialEntity getDetails(Integer residentialProductId) {
		ResidentialEntity residentialEntity = new ResidentialEntity();
		Query query = null;
		String sqlQuery = "select * from tbl_residential where ID=:id and enabled='1' and sold_Status='1'";
		query = getEntityManager().createNativeQuery(sqlQuery, ResidentialEntity.class);
		query.setParameter("id", residentialProductId);
		residentialEntity = (ResidentialEntity) query.getSingleResult();

		return residentialEntity;
	}

	@Override
	public List<PropertyClientMapping> getClientPropertyNotification() {
		List<PropertyClientMapping> list = new ArrayList<PropertyClientMapping>();
		Query query = null;
		String sqlQuery = "select * from tbl_client_property where status='0' ";
		query = getEntityManager().createNativeQuery(sqlQuery, PropertyClientMapping.class);
		list = (List<PropertyClientMapping>) query.getResultList();

		return list;
	}

	@Override
	@Transactional
	public Boolean deleteResidential(ResidentialEntity residentialEntity) {
		entityManager.merge(residentialEntity);
		return true;
	}

	@Override
	@Transactional
	public Boolean soldResidential(ResidentialEntity residentialEntity) {
		entityManager.merge(residentialEntity);
		return true;
	}

}
