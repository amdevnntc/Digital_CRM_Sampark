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

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "locality")
public class LocalityEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer localityid;

	@NotNull
	@NotBlank(message = "Name is mandatory")
	@Column(name = "localityname")
	private String localityname;

	@Column(name = "status")
	private Integer status;

	@Column(name = "created_On")
	@CreationTimestamp
	private Date createdOn;

	@Column(name = "cityid")
	private Integer cityid;

	public Integer getLocalityid() {
		return localityid;
	}

	public void setLocalityid(Integer localityid) {
		this.localityid = localityid;
	}

	public String getLocalityname() {
		return localityname;
	}

	public void setLocalityname(String localityname) {
		this.localityname = localityname;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	@Override
	public String toString() {
		return "LocalityEntity [localityid=" + localityid + ", localityname=" + localityname + ", status=" + status
				+ ", createdOn=" + createdOn + ", cityid=" + cityid + "]";
	}

}