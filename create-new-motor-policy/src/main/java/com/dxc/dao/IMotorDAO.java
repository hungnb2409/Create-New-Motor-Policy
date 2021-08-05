package com.dxc.dao;

import java.sql.SQLException;
import java.util.List;

import com.dxc.model.MotorModel;

public interface IMotorDAO extends GenericDAO<MotorModel> {
	MotorModel findOne(Long id);
	
	List<MotorModel> findByClientNumber(String clientNumber);
	
	Long save(MotorModel motorModel);
	
	void delete(Long id);
	
	List<MotorModel> findAll();
	
	void update(MotorModel updateMotor);
	
	boolean checkUniqueEngineNo(String engineNo) throws SQLException;
	
	boolean checkUniqueChassisNo(String chassisNo) throws SQLException;

}
