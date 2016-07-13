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
package yg0r2.kata.fridaytask.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import yg0r2.kata.fridaytask.dao.impl.Country;

/**
 * @author Yg0R2
 */
public class CountryMapper implements RowMapper<Country> {

	@Override
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
		Country country = new Country();

		country.setId(rs.getInt("id"));
		country.setName(rs.getString("name"));

		return country;
	}

}
