package com.sampark.digitalCrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="device_token")
public class TokenBean {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="token")
	private String token;
	
	@Column(name="dealer_id")
	private Integer dealerid;
	
	@Column(name="employee_id")
	private Integer employeeid;
	
	
	@Column(name="device_Type")
	private String deviceType;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
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


	public String getDeviceType() {
		return deviceType;
	}


	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}


	@Override
	public String toString() {
		return "TokenBean [id=" + id + ", token=" + token + ", dealerid=" + dealerid + ", employeeid=" + employeeid
				+ ", deviceType=" + deviceType + "]";
	}


}

