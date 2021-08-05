package com.dxc.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.service.IClientService;
import com.dxc.service.IMotorService;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{

	/**
	 * 
	 */
	@Inject
	private IClientService clientService;
	
	@Inject
	private IMotorService motorService;
	
	private static final long serialVersionUID = -9126282549983249659L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/home.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
