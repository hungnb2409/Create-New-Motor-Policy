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
		StringBuffer sql = new StringBuffer("INSERT INTO Motor (inceptionDate, expiryDate,");
		sql.append("policyOwner, engineNo, chassisNo, vehicleRegistrationNo, billingCurrency,");
		sql.append("sumInsured, rate, annualPremium, postedPremium, status)");
		sql.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
		System.out.print(motorModel.getSumInsured());
		System.out.print(motorModel.getRate());
		return insert(sql.toString(), motorModel.getInceptionDate(), motorModel.getExpiryDate(),
				motorModel.getPolicyOwner(), motorModel.getEngineNo(), motorModel.getChassisNo(),
				motorModel.getVehicleRegistrationNo(), motorModel.getBillingCurrency(),
				motorModel.getSumInsured(), motorModel.getRate(), motorModel.getAnnualPremium(), 
				motorModel.getPostedPremium(), motorModel.getStatus());
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
		String sql = "SELECT * FROM motor order by id";
		return query(sql, new MotorMapper());
	}
}
