package com.sampark.digitalCrm.service;

import java.util.List;

import com.sampark.digitalCrm.entity.ClientEntity;

public interface SupervisorService {
	
	public ClientEntity getSupervisorById(String supervisorId);
	public List<ClientEntity> searchSupervisorName(String name);
	public Boolean addSupervisor(ClientEntity bean);
	public Boolean updateSupervisor(ClientEntity bean);

	public List<ClientEntity> getAll()throws Exception;
}
