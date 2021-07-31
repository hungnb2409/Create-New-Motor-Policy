package com.dxc.dao.impl;

import java.util.List;

import com.dxc.dao.IMotorDAO;
import com.dxc.mapper.MotorMapper;
import com.dxc.model.MotorModel;

public class MotorDAO extends AbstractDAO<MotorModel> implements IMotorDAO {

	@Override
	public List<MotorModel> findByClientNumber(String clientNumber) {
		String sql = "SELECT * FROM motor WHERE clientNumber = ?";
		return query(sql, new MotorMapper(), clientNumber);
	}

	@Override
	public Long save(MotorModel motorModel) {
		String sql = "INSERT INTO motor ()";
		return null;
	}

	@Override
	public MotorModel findOne(Long id) {
		String sql = "SELECT * FROM motor WHERE id=?";
		List<MotorModel> motors = query(sql, new MotorMapper(), id);
		return motors.isEmpty() ? null : motors.get(0);
	}

	@Override
	public void update(MotorModel updateMotor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MotorModel> finAll() {
		String sql = "SELECT * FROM motor";
		return query(sql, new MotorMapper());
	}
}
