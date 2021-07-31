package com.dxc.model;

import java.sql.Date;

public class MotorModel extends AbstractModel<MotorModel>{
	
	private String policyNo;
	private Date inceptionDate;
	private Date expiryDate;
	private String policyOwner;
	private String engineNo;
	private String chassisNo;
	private String vehicleRegistrationNo;
	private String billingCurrency;
	private double sumInsured;
	private double rate;
	private double annualPremium;
	private double postedPremium;
	
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public Date getInceptionDate() {
		return inceptionDate;
	}
	public void setInceptionDate(Date inceptionDate) {
		this.inceptionDate = inceptionDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getPolicyOwner() {
		return policyOwner;
	}
	public void setPolicyOwner(String policyOwner) {
		this.policyOwner = policyOwner;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getChassisNo() {
		return chassisNo;
	}
	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}
	public String getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}
	public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}
	public String getBillingCurrency() {
		return billingCurrency;
	}
	public void setBillingCurrency(String billingCurrency) {
		this.billingCurrency = billingCurrency;
	}
	public double getSumInsured() {
		return sumInsured;
	}
	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getAnnualPremium() {
		return annualPremium;
	}
	public void setAnnualPremium(double annualPremium) {
		this.annualPremium = annualPremium;
	}
	public double getPostedPremium() {
		return postedPremium;
	}
	public void setPostedPremium(double postedPremium) {
		this.postedPremium = postedPremium;
	}
	
	
}
