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
@Table(name="tbl_residential")
public class ResidentialEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/*@Column(name="addfor")
	private String addfor;
	*/
	@Column(name="saletype")
	private String saletype;
	
	
	@Column(name="property_type")
	private String propertytype;
	
	@Column(name="availability")
	private String availability;
	
	@Column(name="property_name")
	private String propertyname;
	
	@Column(name="locality")
	private String locality;
	
	@Column(name="city")
	private String city;
	
	
	@Column(name="flat_no")
	private String flatNo;
	
	@Column(name="floors")
	private String floors;
	
	
	@Column(name="furnished_Type")
	private String furnishedType;
	
	@Column(name="bedroom")
	private String bedroom;
	
	@Column(name="bathroom")
	private String bathroom;
	
	@Column(name="balcony")
	private String balcony;
	
	@Column(name="area")
	private String area;
	
	
	@Column(name="area_Type")
	private String areatype;
	
	@Column(name="parking")
	private String parking;
	
	@Column(name="doa")
	private Date doa;
	
    @Column(name="description")
    private String description;
	
	@Column(name="ownership")
	private String ownership;
	
	@Column(name="ownerName")
	private String ownerName;
	
	@Column(name="owner_type")
	private String ownerType;
	
	@Column(name="owner_email")
	private String ownerEmail;
	
	@Column(name="owner_mobile")
	private String ownerMobile;
	
	@Column(name="image")
	private String image;
	
	
	@Transient
	private String imageUrl;
	
	@Column(name="employee_id")
	private Integer employeeid;
	
	@Column(name="dealer_id")
	private Integer dealerid;
	
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="modified_on")
	private Date modifiedon;
	
	@Column(name="enabled")
	private Integer enabled;
	
	@Column(name="price")
    private Integer price;
	
	@Column(name="price_in")
    private String pricein;

	@Column(name="price_Type")
	private String priceType;
	
	
	@Column(name="sector")
	private String sector;
	
	
	@Column(name="sold_Status")
	private Integer  soldStatus;
	
	@Column(name="society_Id")
	private Integer societyId;
	
	@Column(name="sector_Id")
	private Integer sectorId;
	
	public Integer getSectorId() {
		return sectorId;
	}


	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}


	@ManyToOne(optional=false)
	@JoinColumn(name="society_Id",referencedColumnName="ID",insertable=false,updatable=false)
	private SocietyEntity societyEntity;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getSaletype() {
		return saletype;
	}


	public void setSaletype(String saletype) {
		this.saletype = saletype;
	}


	public String getPropertytype() {
		return propertytype;
	}


	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}


	public String getAvailability() {
		return availability;
	}


	public void setAvailability(String availability) {
		this.availability = availability;
	}


	public String getPropertyname() {
		return propertyname;
	}


	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
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


	public String getFlatNo() {
		return flatNo;
	}


	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}


	public String getFloors() {
		return floors;
	}


	public void setFloors(String floors) {
		this.floors = floors;
	}


	public String getFurnishedType() {
		return furnishedType;
	}


	public void setFurnishedType(String furnishedType) {
		this.furnishedType = furnishedType;
	}


	public String getBedroom() {
		return bedroom;
	}


	public void setBedroom(String bedroom) {
		this.bedroom = bedroom;
	}


	public String getBathroom() {
		return bathroom;
	}


	public void setBathroom(String bathroom) {
		this.bathroom = bathroom;
	}


	public String getBalcony() {
		return balcony;
	}


	public void setBalcony(String balcony) {
		this.balcony = balcony;
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


	public String getParking() {
		return parking;
	}


	public void setParking(String parking) {
		this.parking = parking;
	}


	public Date getDoa() {
		return doa;
	}


	public void setDoa(Date doa) {
		this.doa = doa;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getOwnership() {
		return ownership;
	}


	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public String getOwnerType() {
		return ownerType;
	}


	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}


	public String getOwnerEmail() {
		return ownerEmail;
	}


	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}


	public String getOwnerMobile() {
		return ownerMobile;
	}


	public void setOwnerMobile(String ownerMobile) {
		this.ownerMobile = ownerMobile;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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


	public String getSector() {
		return sector;
	}


	public void setSector(String sector) {
		this.sector = sector;
	}


	public Integer getSoldStatus() {
		return soldStatus;
	}


	public void setSoldStatus(Integer soldStatus) {
		this.soldStatus = soldStatus;
	}


	public Integer getSocietyId() {
		return societyId;
	}


	public void setSocietyId(Integer societyId) {
		this.societyId = societyId;
	}


	public SocietyEntity getSocietyEntity() {
		return societyEntity;
	}


	public void setSocietyEntity(SocietyEntity societyEntity) {
		this.societyEntity = societyEntity;
	}


	@Override
	public String toString() {
		return "ResidentialEntity [id=" + id + ", saletype=" + saletype + ", propertytype=" + propertytype
				+ ", availability=" + availability + ", propertyname=" + propertyname + ", locality=" + locality
				+ ", city=" + city + ", flatNo=" + flatNo + ", floors=" + floors + ", furnishedType=" + furnishedType
				+ ", bedroom=" + bedroom + ", bathroom=" + bathroom + ", balcony=" + balcony + ", area=" + area
				+ ", areatype=" + areatype + ", parking=" + parking + ", doa=" + doa + ", description=" + description
				+ ", ownership=" + ownership + ", ownerName=" + ownerName + ", ownerType=" + ownerType + ", ownerEmail="
				+ ownerEmail + ", ownerMobile=" + ownerMobile + ", image=" + image + ", imageUrl=" + imageUrl
				+ ", employeeid=" + employeeid + ", dealerid=" + dealerid + ", createdOn=" + createdOn + ", modifiedon="
				+ modifiedon + ", enabled=" + enabled + ", price=" + price + ", pricein=" + pricein + ", priceType="
				+ priceType + ", sector=" + sector + ", soldStatus=" + soldStatus + ", societyId=" + societyId
				+ ", sectorId=" + sectorId + ", societyEntity=" + societyEntity + "]";
	}
	
	
	

}


