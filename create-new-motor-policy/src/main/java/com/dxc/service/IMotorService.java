package com.dxc.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.dxc.model.MotorModel;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public interface IMotorService {

	/**
	 * Find motor by id
	 * 
	 * @param motorId
	 * @return
	 */
	MotorModel findOne(Long id);
	
	/**
	 * Find list motor by client number
	 * 
	 * @param clientNumber
	 * @return
	 */
	List<MotorModel> findByClientNumber(String clientNumber);
	
	/**
	 * Save new motor
	 * 
	 * @param data
	 * @return
	 * @throws JsonSyntaxException
	 * @throws JsonIOException
	 * @throws IOException
	 */
	MotorModel save(JsonObject data)  throws JsonSyntaxException, JsonIOException, IOException;
	
	/**
	 * Update new motor
	 * 
	 * @param data
	 * @return
	 * @throws JsonSyntaxException
	 * @throws JsonIOException
	 * @throws IOException
	 */
	MotorModel update(JsonObject data) throws JsonSyntaxException, JsonIOException, IOException;
	
	/**
	 * Delete motor by id
	 * 
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * Get all motor
	 * 
	 * @return
	 */
	
	MotorModel update(MotorModel updateMotor);
	
	List<MotorModel> findAll();
	
	/**
	 * Check unique engineNo
	 * 
	 * @param engineNo
	 * @return
	 * @throws JsonSyntaxException
	 * @throws JsonIOException
	 * @throws IOException
	 * @throws SQLException 
	 */
	boolean checkUniqueEngineNo(String engineNo)  throws JsonSyntaxException, JsonIOException, IOException, SQLException;
	
	boolean checkUniqueChassisNo(String chassisNo)  throws JsonSyntaxException, JsonIOException, IOException, SQLException;

	




}
