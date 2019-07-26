package com.sampark.digitalCrm.service;

import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.entity.ProjectEntity;
import com.sampark.digitalCrm.object.ResponseObject;

@Service
public interface ProjectService {
	
	public ResponseObject saveProject(ProjectEntity project) throws Exception;
	public ResponseObject getProjectList(Integer dealerId,Integer employeeid,Integer pageid,Integer total) throws Exception;
	
	public ResponseObject searchProjectList(Integer dealerId,Integer employeeid,String saleType,String locality,String projectType,String pricemin,String pricemax,String pricein) throws Exception;
	

}
