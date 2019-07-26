package com.sampark.digitalCrm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.entity.EmployeeNotes;
import com.sampark.digitalCrm.object.ResponseObject;


public interface ClientService {
	
	public ResponseObject saveClient(ClientEntity register) throws Exception;
	public ResponseObject saveClientBulk(List<ClientEntity> clientEntity) throws Exception;
	public ResponseObject getClientList(Integer dealerId,Integer employeeid) throws Exception;
	public LoginEntity getCurrentUserid(String username);
	
	public ResponseObject saveNotes(EmployeeNotes clientNotes) throws Exception;
	
	
	public ResponseObject notesList(Integer clientid,Integer dealerId,Integer employeeid);
	
	public ResponseObject getUserProfile(Integer dealerId,Integer employeeid);
	
	public ResponseObject clientListByType(Integer dealerId,Integer employeeid,String type);

}
