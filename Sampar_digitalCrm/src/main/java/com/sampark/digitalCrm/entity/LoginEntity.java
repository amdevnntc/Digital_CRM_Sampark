package com.sampark.digitalCrm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class LoginEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "ROLE_ID")
	private Integer roleid;

	@Column(name = "dealer_id")
	private Integer dealerIid;

	@Column(name = "employee_id")
	private Integer employeeid;

	@Column(name = "CREATED_ON")
	private Date createdOn;

	@Column(name = "MODIFIED_ON")
	private Date modifiedon;

	@Column(name = "ENABLED")
	private Integer enabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getDealerIid() {
		return dealerIid;
	}

	public void setDealerIid(Integer dealerIid) {
		this.dealerIid = dealerIid;
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

	@Override
	public String toString() {
		return "LoginEntity [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", roleid=" + roleid + ", dealerIid=" + dealerIid + ", employeeid=" + employeeid + ", createdOn="
				+ createdOn + ", modifiedon=" + modifiedon + ", enabled=" + enabled + "]";
	}

}
