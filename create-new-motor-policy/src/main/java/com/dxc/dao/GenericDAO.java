package com.dxc.dao;

import java.sql.SQLException;
import java.util.List;

import com.dxc.mapper.RowMapper;

public interface GenericDAO<T> {
	/**
	 * 
	 * @param <T>
	 * @param sql
	 * @param rowMapper
	 * @param parameters
	 * @return
	 */
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);

	/**
	 * Insert new record
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	Long insert(String sql, Object... parameters);

	/**
	 * Check unique engineNo
	 * 
	 * @param engineNo
	 * @return
	 * @throws SQLException
	 */
	boolean checkUniqueEngineNoAbs(String engineNo) throws SQLException;
	
	/**
	 * Check unique chassisNo
	 * 
	 * @param engineNo
	 * @return
	 * @throws chassisNo
	 */
	boolean checkUniqueChassisNoAbs(String chassisNo) throws SQLException;

	
	/**
	 * update 
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	void update(String sql, Object[] parameters);
}
