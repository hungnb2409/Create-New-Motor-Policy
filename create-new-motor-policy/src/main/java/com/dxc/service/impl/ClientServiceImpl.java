package com.dxc.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.dxc.dao.IClientDAO;
import com.dxc.model.ClientModel;
import com.dxc.service.IClientService;

public class ClientServiceImpl implements IClientService{

	@Inject
	private IClientDAO clientDAO;
	
	/*
	 * @Override public List<ClientModel> findAll() { return clientDAO.findAll(); }
	 */

}
