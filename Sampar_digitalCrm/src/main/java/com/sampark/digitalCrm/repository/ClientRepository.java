package com.sampark.digitalCrm.repository;

import java.util.List;

import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.entity.EmployeeNotes;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.object.ResponseObject;


public interface ClientRepository {
	
	
	public Boolean saveClient(ClientEntity register) throws Exception;
	
	public ResponseObject saveClientBulk(List<ClientEntity> clientEntity) throws Exception;
	
	public List<ClientEntity> getClientList(Integer dealerId,Integer employeeid) throws Exception;
	public Boolean isUserExist(String mobile) throws Exception;
	
	public LoginEntity getCurrentUserid(String username);
	
	public ClientEntity getDetails(Integer clientid);
	
	public Boolean saveNotes(EmployeeNotes clientNotes);
	
	public List<EmployeeNotes> notesList(Integer clientid,Integer dealerId,Integer employeeid);
	
	public List<ClientEntity> clientListByType(Integer dealerId,Integer employeeid,String type);
	
	
	

}
