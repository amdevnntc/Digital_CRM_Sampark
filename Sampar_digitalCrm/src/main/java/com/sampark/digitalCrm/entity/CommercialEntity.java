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
@Table(name="tbl_commercial")
public class CommercialEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="wantto")
	private String wantto;
	
	@Column(name="propertytype")
	private String propertytype;
	
	@Column(name="projectname")
	private String projectname;
	
	@Column(name="city")
	private String city;
	
	@Column(name="locality")
	private String locality;
	
	
	@Column(name="maintenance")
	private String maintenance;
	
	@Column(name="maintenance_type")
	private String maintenancetype;
	
	@Column(name="washroom")
	private String washroom;
	
	
	@Column(name="image")
	private String image;
	
	@Column(name="employee_id")
	private Integer employeeid;
	
	@Column(name="dealer_id")
	private Integer dealerid;
	
	
	@Column(name="owner_Name")
	private String ownerName;
	
	@Column(name="owner_Mobile")
	private String ownerMobile;
	
	
	@Column(name="owner_Email")
	private String ownerEmail;
	
	@Column(name="owner_Type")
	private String ownertype;
	
	@Column(name="ownership")
	private String ownership;
	
	@Column(name="doa")
	private String doa;
	
	@Column(name="description",length=1000)
	private String description;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="pricein")
	private String pricein;
	
	@Column(name="price_Type")
	private String priceType;
	
	@Column(name="parking")
	private String parking;
	
	@Column(name="area")
	private Integer area;
	
	@Column(name="areatype")
	private String areatype;
	
	@Column(name="floors")
	private String floors;
	
	@Column(name="lift")
	private String lift;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="modified_on")
	private Date modifiedon;
	
	@Column(name="enabled")
	private Integer enabled;
	
	
	@Column(name="sold_Status")
	private Integer soldStatus;
	
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

	@Transient
	private String imgUrl;
	
	

	public Integer getSoldStatus() {
		return soldStatus;
	}

	public void setSoldStatus(Integer soldStatus) {
		this.soldStatus = soldStatus;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWantto() {
		return wantto;
	}

	public void setWantto(String wantto) {
		this.wantto = wantto;
	}

	public String getPropertytype() {
		return propertytype;
	}

	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}

	public String getMaintenancetype() {
		return maintenancetype;
	}

	public void setMaintenancetype(String maintenancetype) {
		this.maintenancetype = maintenancetype;
	}

	public String getWashroom() {
		return washroom;
	}

	public void setWashroom(String washroom) {
		this.washroom = washroom;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerMobile() {
		return ownerMobile;
	}

	public void setOwnerMobile(String ownerMobile) {
		this.ownerMobile = ownerMobile;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getOwnertype() {
		return ownertype;
	}

	public void setOwnertype(String ownertype) {
		this.ownertype = ownertype;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getDoa() {
		return doa;
	}

	public void setDoa(String doa) {
		this.doa = doa;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getAreatype() {
		return areatype;
	}

	public void setAreatype(String areatype) {
		this.areatype = areatype;
	}

	public String getFloors() {
		return floors;
	}

	public void setFloors(String floors) {
		this.floors = floors;
	}

	public String getLift() {
		return lift;
	}

	public void setLift(String lift) {
		this.lift = lift;
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

	@Override
	public String toString() {
		return "CommercialEntity [id=" + id + ", wantto=" + wantto + ", propertytype=" + propertytype + ", projectname="
				+ projectname + ", city=" + city + ", locality=" + locality + ", maintenance=" + maintenance
				+ ", maintenancetype=" + maintenancetype + ", washroom=" + washroom + ", image=" + image
				+ ", employeeid=" + employeeid + ", dealerid=" + dealerid + ", ownerName=" + ownerName
				+ ", ownerMobile=" + ownerMobile + ", ownerEmail=" + ownerEmail + ", ownertype=" + ownertype
				+ ", ownership=" + ownership + ", doa=" + doa + ", description=" + description + ", price=" + price
				+ ", pricein=" + pricein + ", priceType=" + priceType + ", parking=" + parking + ", area=" + area
				+ ", areatype=" + areatype + ", floors=" + floors + ", lift=" + lift + ", createdOn=" + createdOn
				+ ", modifiedon=" + modifiedon + ", enabled=" + enabled + ", soldStatus=" + soldStatus + ", societyId="
				+ societyId + ", societyEntity=" + societyEntity + ", imgUrl=" + imgUrl + "]";
	}

	

	
	
}
