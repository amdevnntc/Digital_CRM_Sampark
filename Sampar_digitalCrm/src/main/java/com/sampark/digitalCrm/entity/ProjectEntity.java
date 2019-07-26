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
@Table(name="tbl_project")
public class ProjectEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="project_name")
	private String projectname;
	
	@Column(name="project_image")
	private String imagename;
	
	@Column(name="project_status")
	private String projecstatus;
	
	@Column(name="area")
	private String area;
	
	@Column(name="area_Type")
	private String areatype;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="price_In")
	private String pricein;
	
	@Column(name="locality")
	private String locality;
	
	@Column(name="city")
	private String city;
	
	@Column(name="contact_Name")
	private String personName;
	
	@Column(name="contact_Mobile")
	private String personMobile;
	
	@Column(name="description")
	private String description;
	
	
	@Column(name="employee_id")
	private Integer employeeid;
	
	@Column(name="dealer_id")
	private Integer dealerid;
	
	@Column(name="bookingtype")
	private String bookingtype;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="modified_on")
	private Date modifiedon;
	
	@Column(name="enabled")
	private Integer enabled;
	
	@Column(name="possession_Date")
	private String possessionDate;
	
	@Column(name="project_type")
	private String projecttype;
	
	@Transient
	private Integer count;
	
	@Transient
	private String imageUrl;
	
	@Column(name="society_Id")
	private Integer societyId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="society_Id",referencedColumnName="ID",insertable=false,updatable=false)
	private SocietyEntity societyEntity;

	public SocietyEntity getSocietyEntity() {
		return societyEntity;
	}

	public void setSocietyEntity(SocietyEntity societyEntity) {
		this.societyEntity = societyEntity;
	}

	public Integer getSocietyId() {
		return societyId;
	}

	public void setSocietyId(Integer societyId) {
		this.societyId = societyId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public String getProjecstatus() {
		return projecstatus;
	}

	public void setProjecstatus(String projecstatus) {
		this.projecstatus = projecstatus;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAreatype() {
		return areatype;
	}

	public void setAreatype(String areatype) {
		this.areatype = areatype;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPricein() {
		return pricein;
	}

	public void setPricein(String pricein) {
		this.pricein = pricein;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonMobile() {
		return personMobile;
	}

	public void setPersonMobile(String personMobile) {
		this.personMobile = personMobile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getPossessionDate() {
		return possessionDate;
	}

	public void setPossessionDate(String possessionDate) {
		this.possessionDate = possessionDate;
	}

	public String getProjecttype() {
		return projecttype;
	}

	public void setProjecttype(String projecttype) {
		this.projecttype = projecttype;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "ProjectEntity [id=" + id + ", projectname=" + projectname + ", imagename=" + imagename
				+ ", projecstatus=" + projecstatus + ", area=" + area + ", areatype=" + areatype + ", price=" + price
				+ ", pricein=" + pricein + ", locality=" + locality + ", city=" + city + ", personName=" + personName
				+ ", personMobile=" + personMobile + ", description=" + description + ", employeeid=" + employeeid
				+ ", dealerid=" + dealerid + ", bookingtype=" + bookingtype + ", createdOn=" + createdOn
				+ ", modifiedon=" + modifiedon + ", enabled=" + enabled + ", possessionDate=" + possessionDate
				+ ", projecttype=" + projecttype + ", count=" + count + ", imageUrl=" + imageUrl + ", societyId="
				+ societyId + ", societyEntity=" + societyEntity + "]";
	}
	
}
