package com.dxc.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.constant.SystemConstant;
import com.dxc.model.MotorModel;
import com.dxc.service.IMotorService;
import com.dxc.utils.MessageUtil;

@WebServlet(urlPatterns = {"/motor-list"})
public class MotorController extends HttpServlet{
	
	@Inject
	private IMotorService motorService;

	/**
	 * 
	 */
	private static final long serialVersionUID = -9126282549983249659L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		MotorModel model = new MotorModel();
		String typeParameter = request.getParameter("type");

		if( typeParameter.equals(SystemConstant.LIST)) {
			model.setListResult(motorService.findAll());
			request.setAttribute(SystemConstant.MODEL, model);
			RequestDispatcher rd = request.getRequestDispatcher("/views/list.jsp");
			rd.forward(request, response);
		} else if(typeParameter.equals(SystemConstant.EDIT)) {
			if(model.getId() != null) {
				model = motorService.findOne(model.getId());
			}
			MessageUtil.showMessage(request);
			request.setAttribute(SystemConstant.MODEL, model);
			RequestDispatcher rd = request.getRequestDispatcher("/views/edit.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		MotorModel model = motorService.save(request);
		
	}
	
	
}