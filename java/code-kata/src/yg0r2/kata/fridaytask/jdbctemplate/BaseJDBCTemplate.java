/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package yg0r2.kata.fridaytask.jdbctemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import yg0r2.core.util.Pair;
import yg0r2.kata.fridaytask.OrderByOperator;
import yg0r2.kata.fridaytask.dao.BaseDAO;

/**
 * @author Yg0R2
 */
public abstract class BaseJDBCTemplate<T> implements BaseDAO<T> {

	private static Logger _logger = LoggerFactory.getLogger(BaseJDBCTemplate.class);

	protected JdbcTemplate jdbcTemplate;
	protected RowMapper<T> rowMapper;
	protected String tableName;

	public BaseJDBCTemplate(String tableName, RowMapper<T> rowMapper) {
		this.tableName = tableName;
		this.rowMapper = rowMapper;
	}

	@Override
	public T fetchById(int id) {
		try {
			return getById(id);
		}
		catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public T fetchByName(String name) {
		try {
			return getByName(name);
		}
		catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public List<?> get(String sql, RowMapper<?> rowMapper) {
		return jdbcTemplate.query(sql, new Object[0], rowMapper);
	}

	@Override
	public List<?> get(String sql, Object[] objects, RowMapper<?> rowMapper) {
		return jdbcTemplate.query(sql, objects, rowMapper);
	}

	@Override
	public T getById(int id) {
		String sql = "SELECT * FROM " + tableName + " WHERE id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { id }, rowMapper);
	}

	@Override
	public T getByName(String name) {
		String sql = "SELECT * FROM " + tableName + " WHERE name = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { name }, rowMapper);
	}

	@Override
	public List<T> getList() {
		String sql = "SELECT * FROM " + tableName;

		return jdbcTemplate.query(sql, new Object[0], rowMapper);
	}

	@Override
	public List<T> getListOrderBy(String columnName, OrderByOperator orderByOperator) {
		String sql = "SELECT * FROM " + tableName + " ORDER BY " + columnName + " " + orderByOperator;

		return jdbcTemplate.query(sql, new Object[0], rowMapper);
	}

	@Override
	public List<T> getListWhere(String columnName, Object whereValue) {
		String sql = "SELECT * FROM " + tableName + " WHERE " + columnName + " = ?";

		return jdbcTemplate.query(sql, new Object[] { whereValue }, rowMapper);
	}

	/* (non-Javadoc)
	 * @see yg0r2.kata.fridaytask.db.BaseDAO#isTableEmpty()
	 */
	@Override
	public boolean isTableEmpty() throws SQLException {
		/*Connection connection = jdbcTemplate.getDataSource().getConnection();
		DatabaseMetaData metadata = connection.getMetaData();
		
		ResultSet resultSet = metadata.getColumns(null, null, tableNamePattern.toUpperCase(), "id");
		
		return !resultSet.first();*/

		String sql = "SELECT count(id) FROM " + tableName;

		int result = jdbcTemplate.queryForObject(sql, Integer.class);

		return result < 1;
	}

	/* (non-Javadoc)
	 * @see yg0r2.kata.fridaytask.db.BaseDAO#setDataSource(javax.sql.DataSource)
	 */
	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional
	protected void create(List<Pair<String, Object>> pairs) {
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO ");
		sql.append(tableName);
		sql.append(" (");

		for (Pair<String, Object> pair : pairs) {
			sql.append(pair.getKey());
			sql.append(", ");
		}

		sql.delete(sql.length() - 2, sql.length() - 1);

		List<Object> values = new ArrayList<Object>();

		sql.append(") VALUES (");
		for (Pair<String, Object> pair : pairs) {
			values.add(pair.getValue());

			sql.append("?, ");
		}

		sql.delete(sql.length() - 2, sql.length() - 1);

		sql.append(");");

		if (_logger.isDebugEnabled()) {
			_logger.debug(sql.toString());
		}

		jdbcTemplate.update(sql.toString(), values.toArray());
	}

	protected void createTable(String sql) {
		_logger.debug("Create '" + tableName + "' table.");

		jdbcTemplate.execute(sql);
	}

}
