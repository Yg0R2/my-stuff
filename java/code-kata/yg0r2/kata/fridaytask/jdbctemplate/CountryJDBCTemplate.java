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

import yg0r2.core.util.IdUtil;
import yg0r2.core.util.Pair;
import yg0r2.kata.fridaytask.dao.CountryDAO;
import yg0r2.kata.fridaytask.dao.impl.Country;
import yg0r2.kata.fridaytask.mapper.CountryMapper;

/**
 * @author Yg0R2
 */
public class CountryJDBCTemplate extends BaseJDBCTemplate<Country> implements CountryDAO {

	public CountryJDBCTemplate() {
		super("country", new CountryMapper());
	}

	@Override
	public void create(Country country) {
		List<Pair<String, Object>> pairs = new ArrayList<>();

		pairs.add(new Pair<>("id", country.getId()));
		pairs.add(new Pair<>("name", country.getName()));

		create(pairs);
	}

	@Override
	public void create(String name) {
		List<Pair<String, Object>> pairs = new ArrayList<>();

		pairs.add(new Pair<>("id", IdUtil.getNewId()));
		pairs.add(new Pair<>("name", name));

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
		sql.append(" name VARCHAR(50) NOT NULL");
		sql.append(");");

		createTable(sql.toString());
	}

}
