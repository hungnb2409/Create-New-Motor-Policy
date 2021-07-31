package com.dxc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dxc.model.MotorModel;

public class MotorMapper implements RowMapper<MotorModel>{

	@Override
	public MotorModel mapRow(ResultSet resultSet) {
		MotorModel motor = new MotorModel();
		try {
			motor.setId(resultSet.getLong("id"));
			motor.setPolicyNo(resultSet.getString("policyNo"));
			motor.setInceptionDate(resultSet.getDate("inceptionDate"));
			motor.setExpiryDate(resultSet.getDate("expiryDate"));
			motor.setPolicyOwner(resultSet.getString("policyOwner"));
			motor.setEngineNo(resultSet.getString("engineNo"));
			motor.setChassisNo(resultSet.getString("chassisNo"));
			motor.setVehicleRegistrationNo(resultSet.getString("vehicleRegistrationNo"));
			motor.setBillingCurrency(resultSet.getString("billingCurrency"));
			motor.setSumInsured(resultSet.getDouble("sumInsured"));
			motor.setRate(resultSet.getDouble("rate"));
			motor.setAnnualPremium(resultSet.getDouble("annualPremium"));
			motor.setPostedPremium(resultSet.getDouble("postedPremium"));
			return motor;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
