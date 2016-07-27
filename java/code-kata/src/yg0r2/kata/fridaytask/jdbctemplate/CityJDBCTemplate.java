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

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import yg0r2.core.Pair;
import yg0r2.core.util.IdUtil;
import yg0r2.kata.fridaytask.dao.CityDAO;
import yg0r2.kata.fridaytask.dao.impl.City;
import yg0r2.kata.fridaytask.mapper.CityMapper;

/**
 * @author Yg0R2
 */
public class CityJDBCTemplate extends BaseJDBCTemplate<City> implements CityDAO {

	public CityJDBCTemplate() {
		super("city", new CityMapper());
	}

	@Override
	public void create(City city) {
		List<Pair<String, Object>> pairs = new ArrayList<>();

		pairs.add(new Pair<>("id", city.getId()));
		pairs.add(new Pair<>("name", city.getName()));
		pairs.add(new Pair<>("country_id", city.getCountryId()));

		create(pairs);
	}

	@Override
	public void create(String name, int countryId) {
		List<Pair<String, Object>> pairs = new ArrayList<>();

		pairs.add(new Pair<>("id", IdUtil.getNewId()));
		pairs.add(new Pair<>("name", name));
		pairs.add(new Pair<>("country_id", countryId));

		create(pairs);
	}

	/* (non-Javadoc)
	 * @see yg0r2.kata.fridaytask.db.BaseDAO#createTable()
	 */
	@Override
	public void createTable() {
		StringBuilder sql = new StringBuilder();

		sql.append("CREATE CACHED TABLE IF NOT EXISTS ");
		sql.append(tableName);
		sql.append("(");
		sql.append(" id INT IDENTITY PRIMARY KEY,");
		sql.append(" name VARCHAR(50) NOT NULL,");
		// HSQL syntax
		sql.append(" country_id INT, FOREIGN KEY (country_id) REFERENCES country(id)");
		sql.append(");");

		createTable(sql.toString());
	}

	@Override
	public City fetchByName(String name) {
		throw new UnsupportedOperationException("This is not supported, use fetchByNameAndCountryId()");
	}

	public City fetchByNameAndCountryId(String name, int countryId) {
		try {
			return getByNameAndCountryId(name, countryId);
		}
		catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public City getByName(String name) {
		throw new UnsupportedOperationException("This is not supported, use getByNameAndCountryId()");
	}

	public City getByNameAndCountryId(String name, int countryId) {
		String sql = "SELECT * FROM " + tableName + " WHERE name = ? AND country_id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { name, countryId }, rowMapper);
	}

}
