package com.dxc.utils;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	public static void showMessage(HttpServletRequest request) {
		if (request.getParameter("message") != null) {
			String messageResponse = "";
			String alert = "";
			String message = request.getParameter("message");
			String contentMessage = request.getParameter("contentMessage");
			if (message.equals("insert_success")) {
				messageResponse = contentMessage;
				alert = "success";
			} else if (message.equals("insert_error")) {
				messageResponse = contentMessage;
				alert = "danger";
			}else if (message.equals("update_error")) {
				messageResponse = contentMessage;
				alert = "danger";
				}
			else if (message.equals("update_success")) {
				messageResponse = contentMessage;
				alert = "success";
			} else if (message.equals("error_system")) {
				messageResponse = "Error system";
				alert = "danger";
			} else if (message.equals("Duplicate_EngineNo")) {
				messageResponse = contentMessage;
				alert = "danger";
			} else if (message.equals("Duplicate_ChassisNo")) {
				messageResponse = contentMessage;
				alert = "danger";
			}
			request.setAttribute("messageResponse", messageResponse);
			request.setAttribute("alert", alert);
		}
	}
}
