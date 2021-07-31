package com.dxc.service;

import java.util.List;

import com.dxc.model.MotorModel;

public interface IMotorService {

	MotorModel findOne(Long id);
	List<MotorModel> findByClientNumber(String clientNumber);
	MotorModel save(MotorModel motorModel);
	MotorModel update(MotorModel updateMotor);
	void delete(Long id);
	List<MotorModel> findAll();
}
