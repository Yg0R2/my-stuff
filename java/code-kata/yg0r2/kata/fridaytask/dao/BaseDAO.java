/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package yg0r2.kata.fridaytask.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;

import yg0r2.kata.fridaytask.OrderByOperator;

/**
 * @author Yg0R2
 */
public interface BaseDAO<T> {

	public void create(T object);

	public void createTable();

	public T fetchById(int id);

	public T fetchByName(String name);

	public List<?> get(String sql, RowMapper<?> rowMapper);

	public List<?> get(String sql, Object[] objects, RowMapper<?> rowMapper);

	public T getById(int id);

	public T getByName(String name);

	public List<T> getList();

	public List<T> getListWhere(String columnName, Object whereValue);

	public List<T> getListOrderBy(String columnName, OrderByOperator orderByOperator);

	public boolean isTableEmpty() throws SQLException;

	public void setDataSource(DataSource dataSource);

}
