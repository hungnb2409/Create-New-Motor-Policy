package com.dxc.dao.impl;

import java.sql.SQLException;
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
		return insert(sql.toString(), motorModel.getInceptionDate(), motorModel.getExpiryDate(),
				motorModel.getPolicyOwner(), motorModel.getEngineNo(), motorModel.getChassisNo(),
				motorModel.getVehicleRegistrationNo(), motorModel.getBillingCurrency(),
				motorModel.getSumInsured(), motorModel.getRate(), motorModel.getAnnualPremium(), 
				motorModel.getPostedPremium(), motorModel.getStatus());
	}
	
	@Override
	public void update(MotorModel updateMotor) {
		StringBuilder sql = new StringBuilder("UPDATE dbo.motor SET inceptionDate = ?, expiryDate = ?,");
		sql.append(" policyOwner = ?, engineNo = ?, chassisNo = ?, vehicleRegistrationNo =?,");
		sql.append(" billingCurrency = ?, sumInsured = ?, rate = ?, annualPremium = ?,");
		sql.append("postedPremium = ?, status = ? WHERE id = ?");
		update(sql.toString(), updateMotor.getInceptionDate(), updateMotor.getExpiryDate(), 
				updateMotor.getPolicyOwner(), updateMotor.getEngineNo(), updateMotor.getChassisNo(),
				updateMotor.getVehicleRegistrationNo(), updateMotor.getBillingCurrency(), 
				updateMotor.getSumInsured(), updateMotor.getRate(), updateMotor.getAnnualPremium(),
				updateMotor.getPostedPremium(),updateMotor.getStatus(), updateMotor.getId());
	}

	@Override
	public MotorModel findOne(Long id) {
		String sql = "SELECT * FROM motor WHERE id=?";
		List<MotorModel> motors = query(sql, new MotorMapper(), id);
		return motors.isEmpty() ? null : motors.get(0);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MotorModel> findAll() {
		String sql = "SELECT * FROM motor order by id";
		return query(sql, new MotorMapper());
	}

	@Override
	public boolean checkUniqueEngineNo(String engineNo) throws SQLException {
		return checkUniqueEngineNoAbs(engineNo);
	}

	@Override
	public boolean checkUniqueChassisNo(String chassisNo) throws SQLException {
		return checkUniqueChassisNoAbs(chassisNo);
	}

}
