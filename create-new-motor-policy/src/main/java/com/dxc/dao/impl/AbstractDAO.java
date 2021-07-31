package com.dxc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.dxc.dao.GenericDAO;
import com.dxc.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

	public Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters)
	  { 
		try { 
			for (int i = 0; i < parameters.length; i++) { 
				Object parameter = parameters[i]; 
				int index = i + 1; 
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter); 
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter); 
				} else if (parameter instanceof Date) { 
					statement.setDate(index, (Date) parameter);
				} else if (parameter instanceof Integer) { 
					statement.setInt(index, (Integer) parameter);
					} 
				} 
			}catch (SQLException e) {
				e.printStackTrace();  
	}

	}
}
