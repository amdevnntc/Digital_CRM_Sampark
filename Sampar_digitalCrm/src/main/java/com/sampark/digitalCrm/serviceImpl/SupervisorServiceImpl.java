package com.sampark.digitalCrm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.digitalCrm.entity.ClientEntity;
import com.sampark.digitalCrm.repository.SupervisorRepository;
import com.sampark.digitalCrm.service.SupervisorService;


@Service
public class SupervisorServiceImpl implements SupervisorService {

	@Autowired
	SupervisorRepository supervisorRepo;
	
	@Override
	public ClientEntity getSupervisorById(String supervisorId) {
		
		return supervisorRepo.getSupervisorById(supervisorId);
	}

	@Override
	public List<ClientEntity> searchSupervisorName(String name) {
		
		return supervisorRepo.searchSupervisorName(name);
	}

	@Override
	public Boolean addSupervisor(ClientEntity bean) {
		
		return supervisorRepo.addSupervisor(bean);
	}

	@Override
	public Boolean updateSupervisor(ClientEntity bean) {
		
		return supervisorRepo.updateSupervisor(bean);
	}

	@Override
	public List<ClientEntity> getAll() throws Exception {
		
		
		return supervisorRepo.getAll();
	}

}
