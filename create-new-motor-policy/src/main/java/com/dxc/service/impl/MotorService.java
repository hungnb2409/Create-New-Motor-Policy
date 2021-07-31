package com.dxc.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.management.Query;

import com.dxc.dao.IMotorDAO;
import com.dxc.mapper.MotorMapper;
import com.dxc.model.MotorModel;
import com.dxc.service.IMotorService;

public class MotorService implements IMotorService {

	@Inject
	private IMotorDAO motorDAO;

	@Override
	public List<MotorModel> findByClientNumber(String clientNumber) {
		return motorDAO.findByClientNumber(clientNumber);
	}

	@Override
	public MotorModel save(MotorModel motorModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MotorModel update(MotorModel updateMotor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MotorModel> findAll() {
		return motorDAO.finAll();
	}

	@Override
	public MotorModel findOne(Long id) {
		return motorDAO.findOne(id);
	}




	
	

}
