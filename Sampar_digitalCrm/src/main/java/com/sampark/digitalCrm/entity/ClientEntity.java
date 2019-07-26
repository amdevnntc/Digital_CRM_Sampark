package com.sampark.digitalCrm.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="clientdetails")
public class ClientEntity {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
    @NotBlank(message = "Name is mandatory")
	@Column(name="name")
	private String name;
	
	@NotNull
    @NotBlank(message = "Name is mandatory")
	@Column(name="dob")
	private Date dob;
	
	@NotNull
    @NotBlank(message = "Name is mandatory")
	@Column(name="mobile")
	private String mobile;
	
	@NotNull
    @NotBlank(message = "Name is mandatory")
	@Column(name="anniversary")
	private Date anniversary;
	
	@NotNull
    @NotBlank(message = "Name is mandatory")
	@Column(name="occupation")
	private String occupation;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotNull
    
	@Column(name="homeaddress")
	private String homeaddress;
	
	@NotNull
    
	@Column(name="dealer_id")
	private Integer dealerid;
	
	@NotNull
    
	@Column(name="employee_id")
	private Integer employeeid;
	
	@NotNull
    
	@Column(name="officeaddress")
	private String officeaddress;
	
	
	@NotNull
	@Column(name="created_on")
	private Date createdOn;
	
	@NotNull
	@Column(name="MODIFIED_ON")
	private Date modifiedon;
	
	@NotNull
	@Column(name="ENABLED")
	private Integer enabled;
	
	@NotNull
	@Column(name="client_Type")
    private String clientType;
	
	@NotNull
	@Column(name="subClient_Type")
	private String subClientType;
	
	@NotNull
	@Column(name="company_Name")
	private String companyName;
	
	
	
	

	public String getSubClientType() {
		return subClientType;
	}

	public void setSubClientType(String subClientType) {
		this.subClientType = subClientType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getAnniversary() {
		return anniversary;
	}

	public void setAnniversary(Date anniversary) {
		this.anniversary = anniversary;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
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

	public String getOfficeaddress() {
		return officeaddress;
	}

	public void setOfficeaddress(String officeaddress) {
		this.officeaddress = officeaddress;
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

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	@Override
	public String toString() {
		return "ClientEntity [id=" + id + ", name=" + name + ", dob=" + dob + ", mobile=" + mobile + ", anniversary="
				+ anniversary + ", occupation=" + occupation + ", email=" + email + ", homeaddress=" + homeaddress
				+ ", dealerid=" + dealerid + ", employeeid=" + employeeid + ", officeaddress=" + officeaddress
				+ ", createdOn=" + createdOn + ", modifiedon=" + modifiedon + ", enabled=" + enabled + ", clientType="
				+ clientType + ", subClientType=" + subClientType + ", companyName=" + companyName + "]";
	}


	
	
}
