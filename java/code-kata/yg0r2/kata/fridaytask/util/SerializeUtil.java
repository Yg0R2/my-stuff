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
package yg0r2.kata.fridaytask.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import yg0r2.kata.fridaytask.dao.impl.Airport;
import yg0r2.kata.fridaytask.dao.impl.City;
import yg0r2.kata.fridaytask.dao.impl.Country;
import yg0r2.kata.fridaytask.jdbctemplate.AirportJDBCTemplate;
import yg0r2.kata.fridaytask.jdbctemplate.CityJDBCTemplate;
import yg0r2.kata.fridaytask.jdbctemplate.CountryJDBCTemplate;

/**
 * @author Yg0R2
 */
public class SerializeUtil {

	private static Logger _logger = LoggerFactory.getLogger(SerializeUtil.class);

	public static void deserializeDAT(String fileName, AirportJDBCTemplate airportJDBCTemplate,
		CityJDBCTemplate cityJDBCTemplate, CountryJDBCTemplate countryJDBCTemplate) throws IOException {

		int invalidRowCount = 0;

		Stream<String> linesStream = Files.lines(Paths.get(fileName));

		String[] linesArray = linesStream.toArray(size -> new String[size]);

		linesStream.close();

		_logger.info("Start deserializing file: " + fileName);

		for (String line : linesArray) {
			try {
				_deserializeDATRow(line, airportJDBCTemplate, cityJDBCTemplate, countryJDBCTemplate);
			}
			catch (IllegalArgumentException e) {
				_logger.warn("Invalid data: " + line);

				invalidRowCount++;
			}
		}

		_logger.info("Deerialization finished.");

		_logger.info("There was " + invalidRowCount + " invalid data rows in the file: " + fileName);
	}

	public static void serializeJSON(String outputFileName, AirportJDBCTemplate airportJDBCTemplate,
		CityJDBCTemplate cityJDBCTemplate, CountryJDBCTemplate countryJDBCTemplate, TimeZoneInfo timeZoneInfo)
		throws IOException {

		_logger.info("Start serializing Airport JSON.");

		List<Airport> airports = airportJDBCTemplate.getList();

		StringBuilder contentSB = new StringBuilder(airports.size() * 2);

		for (Airport airport : airports) {
			City city = cityJDBCTemplate.getById(airport.getCityId());

			Country country = countryJDBCTemplate.getById(city.getCountryId());

			contentSB.append(_serializeJSONObject(airport, city, country, timeZoneInfo));
			contentSB.append(",");
		}

		contentSB.deleteCharAt(contentSB.length() - 1);

		Path outputFilePath = Paths.get(outputFileName);

		if (Files.exists(outputFilePath)) {
			Files.delete(outputFilePath);
		}

		Files.createFile(outputFilePath);

		Files.write(outputFilePath, contentSB.toString().getBytes(), StandardOpenOption.APPEND);

		_logger.info("Airport JSON serialization finished.");
		_logger.info("Serialized file location: " + outputFilePath.toString());
	}

	private static StringBuilder _serializeJSONObject(Airport airport, City city, Country country,
		TimeZoneInfo timeZoneInfo) {

		StringBuilder sb = new StringBuilder();

		sb.append("{");
		sb.append("\"id\":");
		sb.append(airport.getId());
		sb.append(",\"iataCode\":\"");
		sb.append(airport.getIataCode());
		sb.append("\",\"icaoCode\":\"");
		sb.append(airport.getIcaoCode());
		sb.append("\",\"name\":\"");
		sb.append(airport.getName());
		sb.append("\",\"fullName\":\"");
		sb.append(airport.getFullName());
		sb.append("\",\"cityId\":");
		sb.append(city.getId());
		sb.append(",\"countryId\":");
		sb.append(country.getId());
		sb.append(",\"timeZoneName\":\"");
		sb.append(timeZoneInfo.getTimeZoneInfoId(airport.getId()));
		sb.append("\",\"location\":{\"longitude\":");
		sb.append(airport.getLongitude());
		sb.append(",\"latitude\":");
		sb.append(airport.getLatitude());
		sb.append(",\"altitude\":");
		sb.append(airport.getAltitude());
		sb.append("}}");

		return sb;
	}

	private static void _deserializeDATRow(String line, AirportJDBCTemplate airportJDBCTemplate,
		CityJDBCTemplate cityJDBCTemplate, CountryJDBCTemplate countryJDBCTemplate) throws IllegalArgumentException {

		List<String> data = new ArrayList<String>(11);

		// Pattern pattern = Pattern.compile("((\".*?\")|[0-9\\.\\-]+|\\\\[A-Z])"); // Allow \N ICAO code
		// Pattern pattern = Pattern.compile("((\".*?\")|[0-9\\.\\-]+)"); // Allow empty IATA code
		Pattern pattern = Pattern.compile("((\".+?\")|[0-9\\.\\-]+)"); // Doesn't allow any not valid lines
		Matcher matcher = pattern.matcher(line);

		while (matcher.find()) {
			String match = matcher.group();

			int start = 0;
			int end = match.length();

			if (match.startsWith("\"")) {
				start++;
			}

			if (match.endsWith("\"")) {
				end--;
			}

			match = match.substring(start, end);

			data.add(match);
		}

		if (data.size() != 11) {
			throw new IllegalArgumentException("Invalid data row.");
		}

		int airportId = Integer.valueOf(data.get(0));
		String airportName = data.get(1);
		String cityName = data.get(2);
		String countryName = data.get(3);
		String iataCode = data.get(4);
		String icaoCode = data.get(5);
		Double longitude = Double.valueOf(data.get(6));
		Double latitude = Double.valueOf(data.get(7));
		Double altitude = Double.valueOf(data.get(8));
		Double nd1 = Double.valueOf(data.get(9));
		String nd2 = data.get(10);

		if (countryJDBCTemplate.fetchByName(countryName) == null) {
			countryJDBCTemplate.create(countryName);
		}

		Country country = countryJDBCTemplate.getByName(countryName);

		if (cityJDBCTemplate.fetchByNameAndCountryId(cityName, country.getId()) == null) {
			cityJDBCTemplate.create(cityName, country.getId());
		}

		City city = cityJDBCTemplate.getByNameAndCountryId(cityName, country.getId());

		if (airportJDBCTemplate.fetchById(airportId) != null) {
			throw new RuntimeException("Airport already exists with this key: " + airportId);
		}

		Airport airport = new Airport();

		airport.setId(airportId);
		airport.setName(airportName);
		airport.setCityId(city.getId());
		airport.setIataCode(iataCode);
		airport.setIcaoCode(icaoCode);

		airport.setLongitude(longitude);
		airport.setLatitude(latitude);
		airport.setAltitude(altitude);

		airport.setNd1(nd1);
		airport.setNd2(nd2);

		airportJDBCTemplate.create(airport);
	}

}
