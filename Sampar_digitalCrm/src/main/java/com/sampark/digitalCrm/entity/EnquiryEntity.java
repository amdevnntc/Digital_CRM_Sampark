package com.sampark.digitalCrm.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_enquiry")
public class EnquiryEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="want_To")
	private String wantTo;
	
	@Column(name="enquiry_id")
	private String enquiryid;
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="contact")
	private String contact;
	
	
	@Column(name="alternate_contact")
	private String alternateContact;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="location")
	private String location;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="enquiry_For")
	private String enquiryFor;
	
	@Column(name="property_type")
	private String propertytype;
	
	@Column(name="dealer_id")
	private Integer dealerid;
	
	@Column(name="employee_id")
	private Integer employeeid;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="modified_on")
	private Date modifiedon;
	
	@Column(name="enable")
	private Integer enabled;
	
	
	@Column(name="price_Min")
    private String priceMin;
	
	
	@Column(name="price_Max")
	private String priceMax;
	
	
	@Column(name="area_Min")
    private String areaMin;
	
	
	@Column(name="area_Max")
	private String areaMax;
	
	@Column(name="areain")
    private String areain;
	
	@Column(name="pricein")
	private String pricein;
	
	
	@Column(name="meeting_Status")
	private Integer meetingStatus;
	

	public Integer getMeetingStatus() {
		return meetingStatus;
	}

	public void setMeetingStatus(Integer meetingStatus) {
		this.meetingStatus = meetingStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWantTo() {
		return wantTo;
	}

	public void setWantTo(String wantTo) {
		this.wantTo = wantTo;
	}

	public String getEnquiryid() {
		return enquiryid;
	}

	public void setEnquiryid(String enquiryid) {
		this.enquiryid = enquiryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAlternateContact() {
		return alternateContact;
	}

	public void setAlternateContact(String alternateContact) {
		this.alternateContact = alternateContact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEnquiryFor() {
		return enquiryFor;
	}

	public void setEnquiryFor(String enquiryFor) {
		this.enquiryFor = enquiryFor;
	}

	public String getPropertytype() {
		return propertytype;
	}

	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}

	public Integer getDealerid() {
		return dealerid;
	}

	public void setDealerid(Integer dealerid) {
		this.dealerid = dealerid;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
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

	public String getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(String priceMin) {
		this.priceMin = priceMin;
	}

	public String getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(String priceMax) {
		this.priceMax = priceMax;
	}

	public String getAreaMin() {
		return areaMin;
	}

	public void setAreaMin(String areaMin) {
		this.areaMin = areaMin;
	}

	public String getAreaMax() {
		return areaMax;
	}

	public void setAreaMax(String areaMax) {
		this.areaMax = areaMax;
	}

	public String getAreain() {
		return areain;
	}

	public void setAreain(String areain) {
		this.areain = areain;
	}

	public String getPricein() {
		return pricein;
	}

	public void setPricein(String pricein) {
		this.pricein = pricein;
	}

	@Override
	public String toString() {
		return "EnquiryEntity [id=" + id + ", wantTo=" + wantTo + ", enquiryid=" + enquiryid + ", name=" + name
				+ ", contact=" + contact + ", alternateContact=" + alternateContact + ", email=" + email + ", address="
				+ address + ", location=" + location + ", pincode=" + pincode + ", enquiryFor=" + enquiryFor
				+ ", propertytype=" + propertytype + ", dealerid=" + dealerid + ", employeeid=" + employeeid
				+ ", createdOn=" + createdOn + ", modifiedon=" + modifiedon + ", enabled=" + enabled + ", priceMin="
				+ priceMin + ", priceMax=" + priceMax + ", areaMin=" + areaMin + ", areaMax=" + areaMax + ", areain="
				+ areain + ", pricein=" + pricein + ", meetingStatus=" + meetingStatus + "]";
	}


}
