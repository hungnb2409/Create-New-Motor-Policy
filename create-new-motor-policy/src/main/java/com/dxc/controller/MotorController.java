package com.dxc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dxc.constant.SystemConstant;
import com.dxc.model.MotorModel;
import com.dxc.service.IMotorService;
import com.dxc.utils.MessageUtil;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

@WebServlet(urlPatterns = { "/motor-list" })
public class MotorController extends HttpServlet {

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
		if (typeParameter.equals(SystemConstant.LIST)) {
			model.setListResult(motorService.findAll());
			request.setAttribute(SystemConstant.MODEL, model);
			RequestDispatcher rd = request.getRequestDispatcher("/views/list.jsp");
			rd.forward(request, response);
		}if (typeParameter.equals(SystemConstant.EDIT)) {
			if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
				Long id = Long.parseLong(request.getParameter("id"));
				model = motorService.findOne(id);
				request.setAttribute(SystemConstant.MODEL, model);
				RequestDispatcher rd = request.getRequestDispatcher("/views/edit.jsp");
				rd.forward(request, response);
			}else {
				MessageUtil.showMessage(request);
				request.setAttribute(SystemConstant.MODEL, model);
				RequestDispatcher rd = request.getRequestDispatcher("/views/edit.jsp");
				rd.forward(request, response);
			}
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
			JSONObject content = new JSONObject();	
			MotorModel model = motorService.update(data);
			if(model == null) {
				content.put("id", "");
				content.put("message", "update_error");
				content.put("iSuccess", false);
			}else {
				content.put("id", "");
				content.put("message", "update_success");
				content.put("iSuccess", true);
			}
			response.setContentType("application/json");
			response.getWriter().write(content.toString());
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
			JSONObject content = new JSONObject();
			if (motorService.checkUniqueEngineNo(data.get("engineNo").getAsString())) {
				MessageUtil.showMessage(request);
				content.put("message", "Duplicate_EngineNo");
				content.put("iSuccess", false);
			}
			else if (motorService.checkUniqueChassisNo(data.get("chassisNo").getAsString())) {
				MessageUtil.showMessage(request);
				content.put("message", "Duplicate_ChassisNo");
				content.put("iSuccess", false);
			} else {
				MotorModel model = motorService.save(data);
				content.put("message", "insert_success");
				content.put("iSuccess", true);
			}
			
			response.setContentType("application/json");
			response.getWriter().write(content.toString());
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}