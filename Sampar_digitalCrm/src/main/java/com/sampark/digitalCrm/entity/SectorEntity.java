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
@Table(name="sector")
public class SectorEntity {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sectorid;
	
	@NotNull
    @NotBlank(message = "Name is mandatory")
	@Column(name="sectorname")
	private String sectorname;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="created_On")
	@CreationTimestamp
	private Date createdOn;
	
	

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

	public Integer getSectorid() {
		return sectorid;
	}

	public void setSectorid(Integer sectorid) {
		this.sectorid = sectorid;
	}

	public String getSectorname() {
		return sectorname;
	}

	public void setSectorname(String sectorname) {
		this.sectorname = sectorname;
	}

	@Override
	public String toString() {
		return "SectorEntity [sectorid=" + sectorid + ", sectorname=" + sectorname + ", status=" + status
				+ ", createdOn=" + createdOn + "]";
	}
	
	
	
}