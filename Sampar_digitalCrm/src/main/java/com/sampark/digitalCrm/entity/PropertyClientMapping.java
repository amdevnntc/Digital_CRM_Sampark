package com.sampark.digitalCrm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tbl_client_property")
public class PropertyClientMapping {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="product_Id")
	private Integer productId;
	
	
	@Column(name="client_Id")
	private Integer clientId;
	
	
	@Column(name="created_On")
	private Date createdOn;
	
	@Column(name="modified_On")
	private Date modifiedOn;
	
	@Column(name="type")
	private String type;
	
	@Column(name="status")
	private Integer status;
   
	@Column(name="employee_id")
	private Integer employeeid;
	
	@Column(name="dealer_id")
	private Integer dealerid;
	
	@Column(name="product_type")
	private String productType;
	
	@Column(name="enquiry_For")
	private String enquiryFor;
	
	
	@Transient
	private List<String> residentProductid;

	@Transient
	private List<String> clientid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Integer getDealerid() {
		return dealerid;
	}

	public void setDealerid(Integer dealerid) {
		this.dealerid = dealerid;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getEnquiryFor() {
		return enquiryFor;
	}

	public void setEnquiryFor(String enquiryFor) {
		this.enquiryFor = enquiryFor;
	}

	public List<String> getResidentProductid() {
		return residentProductid;
	}

	public void setResidentProductid(List<String> residentProductid) {
		this.residentProductid = residentProductid;
	}

	public List<String> getClientid() {
		return clientid;
	}

	public void setClientid(List<String> clientid) {
		this.clientid = clientid;
	}

	@Override
	public String toString() {
		return "PropertyClientMapping [id=" + id + ", productId=" + productId + ", clientId=" + clientId
				+ ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + ", type=" + type + ", status=" + status
				+ ", employeeid=" + employeeid + ", dealerid=" + dealerid + ", productType=" + productType
				+ ", enquiryFor=" + enquiryFor + ", residentProductid=" + residentProductid + ", clientid=" + clientid
				+ "]";
	}

	

}
