package com.sampark.digitalCrm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tbl_property")
public class PropertyEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="property_name")
	private String propertyname;
	
	@Column(name="project_type")
	private String projectype;
	
	
	@Column(name="property_type")
	private String propertytype;
	
	
	@Column(name="area")
	private String area;
	
	@Column(name="bhk")
	private String bhk;
	
	
	@Column(name="price")
	private String price;
	
	
	@Column(name="location")
	private String location;
	
	@Column(name="client_id")
	private Integer clientid;
	
	@Column(name="description")
	private String description;
	
	@Column(name="construction_status")
	private String constructionstatus;
	
	@Column(name="employee_id")
	private Integer employeeid;
	
	@Column(name="dealer_id")
	private Integer dealerid;
	
	@Column(name="bookingtype")
	private String bookingtype;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="MODIFIED_ON")
	private Date modifiedon;
	
	@Column(name="ENABLED")
	private Integer enabled;
	
	
	@Transient
	EmployeeEntity employeeentity;
	
	@Transient
	DealerEntity dealerEntity;
	
	
	@ManyToOne
	@JoinColumn(name="client_id",referencedColumnName="ID",insertable=false,updatable=false)
	private ClientEntity client;
	
	
	@Column(name="posted_by")
	private String postedby;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPropertyname() {
		return propertyname;
	}


	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}


	public String getProjectype() {
		return projectype;
	}


	public void setProjectype(String projectype) {
		this.projectype = projectype;
	}


	public String getPropertytype() {
		return propertytype;
	}


	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getBhk() {
		return bhk;
	}


	public void setBhk(String bhk) {
		this.bhk = bhk;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Integer getClientid() {
		return clientid;
	}


	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getConstructionstatus() {
		return constructionstatus;
	}


	public void setConstructionstatus(String constructionstatus) {
		this.constructionstatus = constructionstatus;
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


	public String getBookingtype() {
		return bookingtype;
	}


	public void setBookingtype(String bookingtype) {
		this.bookingtype = bookingtype;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public Date getModifiedon() {
		return modifiedon;
	}


	public void setModifiedon(Date modifiedon) {
		this.modifiedon = modifiedon;
	}


	public Integer getEnabled() {
		return enabled;
	}


	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}


	public EmployeeEntity getEmployeeentity() {
		return employeeentity;
	}


	public void setEmployeeentity(EmployeeEntity employeeentity) {
		this.employeeentity = employeeentity;
	}


	public DealerEntity getDealerEntity() {
		return dealerEntity;
	}


	public void setDealerEntity(DealerEntity dealerEntity) {
		this.dealerEntity = dealerEntity;
	}


	public ClientEntity getClient() {
		return client;
	}


	public void setClient(ClientEntity client) {
		this.client = client;
	}


	public String getPostedby() {
		return postedby;
	}


	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}


	@Override
	public String toString() {
		return "PropertyEntity [id=" + id + ", propertyname=" + propertyname + ", projectype=" + projectype
				+ ", propertytype=" + propertytype + ", area=" + area + ", bhk=" + bhk + ", price=" + price
				+ ", location=" + location + ", clientid=" + clientid + ", description=" + description
				+ ", constructionstatus=" + constructionstatus + ", employeeid=" + employeeid + ", dealerid=" + dealerid
				+ ", bookingtype=" + bookingtype + ", createdOn=" + createdOn + ", modifiedon=" + modifiedon
				+ ", enabled=" + enabled + ", employeeentity=" + employeeentity + ", dealerEntity=" + dealerEntity
				+ ", client=" + client + ", postedby=" + postedby + "]";
	}


	

}
