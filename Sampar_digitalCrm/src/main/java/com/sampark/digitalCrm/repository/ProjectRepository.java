package com.sampark.digitalCrm.repository;

import java.util.List;

import com.sampark.digitalCrm.entity.ProjectEntity;


public interface ProjectRepository {
	
	public Boolean saveProject(ProjectEntity project) throws Exception;
	public List<ProjectEntity> getProject(Integer dealerId,Integer employeeid,Integer pageid,Integer total) throws Exception;
	
	public List<ProjectEntity> searchProjectList(Integer dealerId,Integer employeeid,String saleType,String locality,String projectType,String pricemin,String pricemax,String pricein) throws Exception;
	
}
