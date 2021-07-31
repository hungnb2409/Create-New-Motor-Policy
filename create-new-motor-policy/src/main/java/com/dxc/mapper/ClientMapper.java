package com.dxc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dxc.model.ClientModel;

public class ClientMapper implements RowMapper<ClientModel> {

	@Override
	public ClientModel mapRow(ResultSet resultSet) {
		try {
			ClientModel client = new ClientModel();
			client.setId(resultSet.getLong("id"));
			client.setClientNumber(resultSet.getString("clientNumber"));
			client.setFirstName(resultSet.getString("firstName"));
			client.setLastName(resultSet.getString("lastName"));
			client.setGender(resultSet.getString("gender"));
			client.setDateOfBirth(resultSet.getDate("dateOfBirth"));
			client.setIdentityNumber(resultSet.getString("identityNumber"));
			client.setMaritalStatus(resultSet.getString("maritalStatus"));
			client.setAddress(resultSet.getString("address"));
			return client;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
