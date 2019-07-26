package com.sampark.digitalCrm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.digitalCrmConstant;
import com.sampark.digitalCrm.entity.LoginEntity;
import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.entity.EmployeeNotes;
import com.sampark.digitalCrm.object.ResponseObject;
import com.sampark.digitalCrm.repository.ClientRepository;
import com.sampark.digitalCrm.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientrepo;

	@Override
	public ResponseObject saveClient(ClientEntity register) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		
		if(register.getId()!=null)
		{
			clientrepo.saveClient(register);
			rsobj.setStatus(true);
			rsobj.setMessage("Data Updated Successfully");
		}
		else
		{
			if(clientrepo.isUserExist(register.getMobile()))
			{
				rsobj.setStatus(false);
				rsobj.setMessage("user Already Exist");
			}
			else
			{
				clientrepo.saveClient(register);
				rsobj.setStatus(true);
				rsobj.setMessage(digitalCrmConstant.success);
			}
			
		}
		
		
		
		return rsobj;
	}

	@Override
	public LoginEntity getCurrentUserid(String username) {
		// TODO Auto-generated method stub
		return clientrepo.getCurrentUserid(username);
	}

	@Override
	public ResponseObject getClientList(Integer dealerId, Integer employeeid) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		List<ClientEntity> list = new ArrayList<ClientEntity>();
		list=clientrepo.getClientList(dealerId,employeeid);
		rsobj.setObject(list);
		rsobj.setStatus(true);
		 
		 return rsobj;
	}

	@Override
	public ResponseObject saveClientBulk(List<ClientEntity> clientEntity) throws Exception {
		// TODO Auto-generated method stub
		return clientrepo.saveClientBulk(clientEntity);
	}

	@Override
	public ResponseObject saveNotes(EmployeeNotes clientNotes) throws Exception {
		
		ResponseObject rsobj=new ResponseObject();
		if(clientrepo.saveNotes(clientNotes))
		{
			rsobj.setStatus(true);
			rsobj.setMessage(digitalCrmConstant.success);
		}
		else
		{
			rsobj.setStatus(false);
			rsobj.setMessage(digitalCrmConstant.fail);
		}
		return rsobj;
	}

	@Override
	public ResponseObject notesList(Integer clientid,Integer dealerId,Integer employeeid) {
		
		ResponseObject rsobj=new ResponseObject();
		List<EmployeeNotes> list = new ArrayList<EmployeeNotes>();
		list=clientrepo.notesList(clientid,dealerId,employeeid);
		rsobj.setObject(list);
		rsobj.setStatus(true);
		 return rsobj;
	}

	@Override
	public ResponseObject getUserProfile(Integer dealerId, Integer employeeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseObject clientListByType(Integer dealerId, Integer employeeid, String type) {
		
		ResponseObject rsobj=new ResponseObject();
		List<ClientEntity> list = new ArrayList<ClientEntity>();
		list=clientrepo.clientListByType(dealerId,employeeid,type);
		rsobj.setObject(list);
		rsobj.setStatus(true);
		 
		 return rsobj;
	}
	
	
	

}
