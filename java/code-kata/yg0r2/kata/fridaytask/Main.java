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
package yg0r2.kata.fridaytask;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import yg0r2.core.util.Pair;
import yg0r2.core.util.SpringUtils;
import yg0r2.kata.fridaytask.dao.impl.Airport;
import yg0r2.kata.fridaytask.dao.impl.City;
import yg0r2.kata.fridaytask.dao.impl.Country;
import yg0r2.kata.fridaytask.jdbctemplate.AirportJDBCTemplate;
import yg0r2.kata.fridaytask.jdbctemplate.CityJDBCTemplate;
import yg0r2.kata.fridaytask.jdbctemplate.CountryJDBCTemplate;
import yg0r2.kata.fridaytask.mapper.AirportMapper;
import yg0r2.kata.fridaytask.util.SerializeUtil;
import yg0r2.kata.fridaytask.util.TimeZoneInfo;

/**
 * @author Yg0R2
 */
public class Main {

	private static Logger _logger = LoggerFactory.getLogger(Main.class);
	private static String _baseFolder = new File("").getAbsolutePath();

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws Exception {
		String resourcesFolder = _baseFolder + "/code-kata/yg0r2/kata/fridaytask/resources/";

		String dataFileName = resourcesFolder + "airports.dat";
		String timeZoneFileName = resourcesFolder + "timezoneinfo.json";
		String outputFileName = _baseFolder + "/target/outputFile.json";
		Main instance = new Main();

		instance.init(dataFileName, timeZoneFileName);

		instance.serializeAirportJSON(outputFileName);

		instance.task9A();

		instance.task9B();

		instance.task9C();

		instance.task9D();
	}

	private AirportJDBCTemplate _airportJDBCTemplate;
	private CityJDBCTemplate _cityJDBCTemplate;
	private CountryJDBCTemplate _countryJDBCTemplate;
	private TimeZoneInfo _timeZoneInfo;

	protected void init(String dataFileName, String timeZoneFileName) throws SQLException, IOException {
		ApplicationContext context = SpringUtils.getApplicationContext(Main.class);

		_airportJDBCTemplate = SpringUtils.getBean(AirportJDBCTemplate.class, context, "airportJDBCTemplate");

		_cityJDBCTemplate = SpringUtils.getBean(CityJDBCTemplate.class, context, "CityJDBCTemplate");

		_countryJDBCTemplate = SpringUtils.getBean(CountryJDBCTemplate.class, context, "countryJDBCTemplate");

		_countryJDBCTemplate.createTable();
		_cityJDBCTemplate.createTable();
		_airportJDBCTemplate.createTable();

		if (_airportJDBCTemplate.isTableEmpty() || _cityJDBCTemplate.isTableEmpty()
			|| _countryJDBCTemplate.isTableEmpty()) {

			SerializeUtil.deserializeDAT(dataFileName, _airportJDBCTemplate, _cityJDBCTemplate, _countryJDBCTemplate);
		}

		// Initialize timeZoneMap
		_timeZoneInfo = new TimeZoneInfo(timeZoneFileName);

		_logger.info("DB is ready to use.");
	}

	protected void serializeAirportJSON(String outputFileName) throws IOException {
		SerializeUtil.serializeJSON(outputFileName, _airportJDBCTemplate, _cityJDBCTemplate, _countryJDBCTemplate,
			_timeZoneInfo);
	}

	protected void task9A() {
		_logger.info(
			"List all the countries by name in an ascending order, and display the number of airports they have.");

		List<Country> countries = _countryJDBCTemplate.getListOrderBy("name", OrderByOperator.ASC);

		for (Country country : countries) {
			List<City> cities = _cityJDBCTemplate.getListWhere("country_id", country.getId());

			int airportCount = 0;
			for (City city : cities) {
				List<Airport> airports = _airportJDBCTemplate.getListWhere("city_id", city.getId());

				airportCount += airports.size();
			}

			_logger.info(country.getName() + ": " + airportCount);
		}

		_logger.info("---- Finished ----");
	}

	@SuppressWarnings("unchecked")
	protected void task9B() {
		_logger.info(
			"Find the city which has got the most airports. If there are more than one cities with the same amount, display all of them.");

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT city.name, t2.airportsOfCity FROM city INNER JOIN ");
		sql.append("(SELECT airport.city_id, COUNT(city_id) AS airportsOfCity FROM airport GROUP BY city_id) t2 ");
		sql.append("ON city.id = t2.city_id ");
		sql.append("ORDER BY t2.airportsOfCity DESC;");

		List<?> pairList = _cityJDBCTemplate.get(sql.toString(), new RowMapper<Pair<String, Integer>>() {

			@Override
			public Pair<String, Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Pair<String, Integer>(rs.getString("name"), rs.getInt("airportsOfCity"));
			}
		});

		List<Pair<String, Integer>> pairs = (List<Pair<String, Integer>>) pairList;

		int maxCountOfAirports = 0;
		for (Pair<String, Integer> pair : pairs) {
			if (maxCountOfAirports > pair.getValue()) {
				break;
			}

			maxCountOfAirports = pair.getValue();

			_logger.info(pair.getKey() + ": " + pair.getValue());
		}

		_logger.info("---- Finished ----");
	}

	@SuppressWarnings("unchecked")
	protected void task9C() {
		_logger.info(
			"Find out which airport is at the following GPS coordinate, and display its Name and City: 35.764722, 140.386389, 141");

		double longitude = 35.764722;
		double latitude = 140.386389;
		double altitude = 141;

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * FROM airport WHERE longitude = ? AND latitude = ? AND altitude = ?;");

		List<?> airportList = _airportJDBCTemplate.get(sql.toString(), new Object[] { longitude, latitude, altitude },
			new AirportMapper());

		Airport airport = ((List<Airport>) airportList).get(0);

		City city = _cityJDBCTemplate.getById(airport.getCityId());

		_logger.info("Airport name: " + airport.getName());
		_logger.info("City: " + city.getName());

		_logger.info("---- Finished ----");
	}

	protected void task9D() throws IOException {
		_logger.info(
			"Let the user enter an IATA code (validate that the string entered is correct) and display the following information about the given airport: Name, City, Country, the local time and current GMT offset.");

		Airport airport = null;

		String iataCode = "";

		while ((airport = _airportJDBCTemplate.fetchByIATACode(iataCode)) == null) {
			if (!iataCode.equals("")) {
				_logger.info("The given '" + iataCode + "' IATA code is not exist.");

				iataCode = "";
			}

			while (!iataCode.matches("[A-Z]{3}")) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter IATA code:");
				iataCode = br.readLine();
			}
		}

		City city = _cityJDBCTemplate.getById(airport.getCityId());
		Country country = _countryJDBCTemplate.getById(city.getCountryId());

		StringBuilder result = new StringBuilder();

		result.append(airport.getName());
		result.append(" - ");
		result.append(city.getName());
		result.append(", ");
		result.append(country.getName());
		result.append(" - Local time: ");
		result.append(LocalTime.now(_timeZoneInfo.getZoneId(airport.getId())));

		_logger.info(result.toString());

		_logger.info("---- Finished ----");
	}

}
