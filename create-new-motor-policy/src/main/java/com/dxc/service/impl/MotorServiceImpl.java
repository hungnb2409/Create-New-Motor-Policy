package com.dxc.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.dxc.dao.IMotorDAO;
import com.dxc.model.MotorModel;
import com.dxc.service.IMotorService;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class MotorServiceImpl implements IMotorService {

	@Inject
	private IMotorDAO motorDAO;

	@Override
	public List<MotorModel> findByClientNumber(String clientNumber) {
		return motorDAO.findByClientNumber(clientNumber);
	}

	@Override
	public MotorModel save(JsonObject data) throws JsonSyntaxException, JsonIOException, IOException {
		MotorModel model = new MotorModel();
		Long newId = 0L;
		try {
			Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(data.get("expiryDate").getAsString());
			Date inceptionDate = new SimpleDateFormat("yyyy-MM-dd").parse(data.get("inceptionDate").getAsString());
			String policyOwner = data.get("policyOwner").getAsString();
			String engineNo = data.get("engineNo").getAsString();
			String chassisNo = data.get("chassisNo").getAsString();
			String vehicleRegistrationNo = data.get("vehicleRegistrationNo").getAsString();
			String billingCurrency = data.get("billingCurrency").getAsString();
			Double sumInsured = data.get("sumInsured").getAsDouble();
			Double rate = data.get("rate").getAsDouble();
			Double annualPremium = data.get("annualPremium").getAsDouble();
			Double postedPremium = data.get("postedPremium").getAsDouble();
						
			model.setInceptionDate(inceptionDate);
			model.setExpiryDate(expiryDate);
			model.setPolicyOwner(policyOwner);
			model.setEngineNo(engineNo);
			model.setChassisNo(chassisNo);
			model.setVehicleRegistrationNo(vehicleRegistrationNo);
			model.setBillingCurrency(billingCurrency);
			model.setSumInsured(sumInsured);
			model.setRate(rate);
			model.setAnnualPremium(annualPremium);
			model.setPostedPremium(postedPremium);
			model.setStatus(data.get("status").getAsString());
			
			newId = motorDAO.save(model);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 		return motorDAO.findOne(newId);
	}
	
	@Override
	public MotorModel update(JsonObject data) throws JsonSyntaxException, JsonIOException, IOException {
		MotorModel model = new MotorModel();
		try {
			Long id = Long.parseLong(data.get("id").getAsString());
			Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(data.get("expiryDate").getAsString());
			Date inceptionDate = new SimpleDateFormat("yyyy-MM-dd").parse(data.get("inceptionDate").getAsString());
			String policyOwner = data.get("policyOwner").getAsString();
			String engineNo = data.get("engineNo").getAsString();
			String chassisNo = data.get("chassisNo").getAsString();
			String vehicleRegistrationNo = data.get("vehicleRegistrationNo").getAsString();
			String billingCurrency = data.get("billingCurrency").getAsString();
			Double sumInsured = data.get("sumInsured").getAsDouble();
			Double rate = data.get("rate").getAsDouble();
			Double annualPremium = data.get("annualPremium").getAsDouble();
			Double postedPremium = data.get("postedPremium").getAsDouble();
			
			model.setId(id);
			model.setInceptionDate(inceptionDate);
			model.setExpiryDate(expiryDate);
			model.setPolicyOwner(policyOwner);
			model.setEngineNo(engineNo);
			model.setChassisNo(chassisNo);
			model.setVehicleRegistrationNo(vehicleRegistrationNo);
			model.setBillingCurrency(billingCurrency);
			model.setSumInsured(sumInsured);
			model.setRate(rate);
			model.setAnnualPremium(annualPremium);
			model.setPostedPremium(postedPremium);
			model.setStatus(data.get("status").getAsString());
			motorDAO.update(model);
			return motorDAO.findOne(id);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new MotorModel();
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MotorModel> findAll() {
		return motorDAO.findAll();
	}

	@Override
	public MotorModel findOne(Long id) {
		return motorDAO.findOne(id);
	}

	@Override
	public boolean checkUniqueEngineNo(String engineNo) 
			throws JsonSyntaxException, JsonIOException, IOException, SQLException {
		return motorDAO.checkUniqueEngineNo(engineNo);
	}

	@Override
	public boolean checkUniqueChassisNo(String chassisNo)
			throws JsonSyntaxException, JsonIOException, IOException, SQLException {
		return motorDAO.checkUniqueChassisNo(chassisNo);
	}

	@Override
	public MotorModel update(MotorModel updateMotor) {
		MotorModel motor = motorDAO.findOne(updateMotor.getId());
		motorDAO.update(updateMotor);
		return motorDAO.findOne(updateMotor.getId());
		
	}

}
