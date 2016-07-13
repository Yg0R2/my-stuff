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

import yg0r2.kata.fridaytask.dao.impl.Airport;

/**
 * @author Yg0R2
 */
public class AirportMapper implements RowMapper<Airport> {

	@Override
	public Airport mapRow(ResultSet rs, int rowNum) throws SQLException {
		Airport airport = new Airport();

		airport.setId(rs.getInt("id"));
		airport.setName(rs.getString("name"));
		airport.setIataCode(rs.getString("iata_code"));
		airport.setIcaoCode(rs.getString("icao_code"));
		airport.setCityId(rs.getInt("city_id"));
		//airport.setLocationId(rs.getInt("location_id"));
		airport.setLongitude(rs.getDouble("longitude"));
		airport.setLatitude(rs.getDouble("latitude"));
		airport.setAltitude(rs.getDouble("altitude"));
		airport.setNd1(rs.getDouble("nd1"));
		airport.setNd2(rs.getString("nd2"));

		return airport;
	}

}
