package com.dxc.dao;

import java.util.List;

import com.dxc.model.MotorModel;

public interface IMotorDAO extends GenericDAO<MotorModel> {
	MotorModel findOne(Long id);
	List<MotorModel> findByClientNumber(String clientNumber);
	Long save(MotorModel motorModel);
	void update(MotorModel updateMotor);
	void delete(Long id);
	List<MotorModel> finAll();
}
