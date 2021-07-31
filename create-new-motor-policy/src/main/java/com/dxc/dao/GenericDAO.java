package com.dxc.dao;

import java.util.List;

import com.dxc.mapper.RowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
}
