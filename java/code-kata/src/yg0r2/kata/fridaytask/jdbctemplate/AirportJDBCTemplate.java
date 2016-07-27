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
import yg0r2.kata.fridaytask.dao.AirportDAO;
import yg0r2.kata.fridaytask.dao.impl.Airport;
import yg0r2.kata.fridaytask.mapper.AirportMapper;

/**
 * @author Yg0R2
 */
public class AirportJDBCTemplate extends BaseJDBCTemplate<Airport> implements AirportDAO {

	public AirportJDBCTemplate() {
		super("airport", new AirportMapper());
	}

	@Override
	public void create(Airport airport) {
		List<Pair<String, Object>> pairs = new ArrayList<>();

		pairs.add(new Pair<>("id", airport.getId()));
		pairs.add(new Pair<>("name", airport.getName()));
		pairs.add(new Pair<>("iata_code", airport.getIataCode()));
		pairs.add(new Pair<>("icao_code", airport.getIcaoCode()));
		pairs.add(new Pair<>("city_id", airport.getCityId()));
		pairs.add(new Pair<>("country_id", airport.getCountryId()));
		pairs.add(new Pair<>("longitude", airport.getLongitude()));
		pairs.add(new Pair<>("latitude", airport.getLatitude()));
		pairs.add(new Pair<>("altitude", airport.getAltitude()));
		pairs.add(new Pair<>("nd1", airport.getNd1()));
		pairs.add(new Pair<>("nd2", airport.getNd2()));

		create(pairs);
	}

	@Override
	public void create(String airportName, String iataCode, String icaoCode, int cityId, int countryId,
		double longitude, double latitude, double altitude, double nd1, String nd2) {

		List<Pair<String, Object>> pairs = new ArrayList<>();

		pairs.add(new Pair<>("id", IdUtil.getNewId()));
		pairs.add(new Pair<>("name", airportName));
		pairs.add(new Pair<>("iata_code", iataCode));
		pairs.add(new Pair<>("icao_code", icaoCode));
		pairs.add(new Pair<>("city_id", cityId));
		pairs.add(new Pair<>("country_id", countryId));
		pairs.add(new Pair<>("longitude", longitude));
		pairs.add(new Pair<>("latitude", latitude));
		pairs.add(new Pair<>("altitude", altitude));
		pairs.add(new Pair<>("nd1", nd1));
		pairs.add(new Pair<>("nd2", nd2));

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
		sql.append(" name VARCHAR(100) NOT NULL,");
		sql.append(" iata_code VARCHAR(3),");
		sql.append(" icao_code VARCHAR(4) NOT NULL,");
		// HSQL syntax
		sql.append(" city_id INT, FOREIGN KEY (city_id) REFERENCES city(id),");
		sql.append(" country_id INT, FOREIGN KEY (country_id) REFERENCES country(id),");
		sql.append(" longitude DOUBLE NOT NULL,");
		sql.append(" latitude DOUBLE NOT NULL,");
		sql.append(" altitude DOUBLE NOT NULL,");
		sql.append(" nd1 DOUBLE NOT NULL,");
		sql.append(" nd2 VARCHAR(1) NOT NULL");
		sql.append(");");

		createTable(sql.toString());
	}

	public Airport fetchByIATACode(String iataCode) {
		try {
			return getByIATACode(iataCode);
		}
		catch (DataAccessException e) {
			return null;
		}
	}

	public Airport getByIATACode(String iataCode) {
		String sql = "SELECT * FROM " + tableName + " WHERE iata_code = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { iataCode }, rowMapper);
	}

}
