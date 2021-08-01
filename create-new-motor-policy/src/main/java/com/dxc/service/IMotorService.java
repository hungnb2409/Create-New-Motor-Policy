package com.dxc.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dxc.model.MotorModel;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public interface IMotorService {

	MotorModel findOne(Long id);
	List<MotorModel> findByClientNumber(String clientNumber);
	MotorModel save(HttpServletRequest request)  throws JsonSyntaxException, JsonIOException, IOException;
	MotorModel update(MotorModel updateMotor);
	void delete(Long id);
	List<MotorModel> findAll();
}
