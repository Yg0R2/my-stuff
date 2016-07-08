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
package yg0r2.kata.fridaytask.dao.impl;

import yg0r2.core.util.IdUtil;
import yg0r2.kata.fridaytask.util.TimeZoneInfo;

/**
 * @author Yg0R2
 */
public class Airport {

	private Double _altitude;
	private int _cityId;
	private int _countryId;
	private String _iataCode;
	private String _icaoCode;
	private int _id = IdUtil.getNewId();
	private Double _latitude;
	private Double _longitude;
	private String _name;
	private Double _nd1;
	private String _nd2;

	/**
	 * @return the altitude
	 */
	public Double getAltitude() {
		return _altitude;
	}

	/**
	 * @return the cityId
	 */
	public int getCityId() {
		return _cityId;
	}

	/**
	 * @return the countryId
	 */
	public int getCountryId() {
		return _countryId;
	}

	/**
	 * @return the full name of the airport
	 */
	public String getFullName() {
		return getName() + " Airport";
	}

	/**
	 * @return the iataCode
	 */
	public String getIataCode() {
		return _iataCode;
	}

	/**
	 * @return the icaoCode
	 */
	public String getIcaoCode() {
		return _icaoCode;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return _id;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return _latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return _longitude;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @return the nd1
	 */
	public Double getNd1() {
		return _nd1;
	}

	/**
	 * @return the nd2
	 */
	public String getNd2() {
		return _nd2;
	}

	/**
	 * @param altitude the altitude to set
	 */
	public void setAltitude(Double altitude) {
		_altitude = altitude;
	}

	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(int cityId) {
		_cityId = cityId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(int countryId) {
		_countryId = countryId;
	}

	/**
	 * @param iataCode the iataCode to set
	 */
	public void setIataCode(String iataCode) {
		_iataCode = iataCode;
	}

	/**
	 * @param icaoCode the icaoCode to set
	 */
	public void setIcaoCode(String icaoCode) {
		_icaoCode = icaoCode;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		_id = id;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		_latitude = latitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		_longitude = longitude;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		_name = name;
	}

	/**
	 * @param nd1 the nd1 to set
	 */
	public void setNd1(Double nd1) {
		_nd1 = nd1;
	}

	/**
	 * @param nd2 the nd2 to set
	 */
	public void setNd2(String nd2) {
		_nd2 = nd2;
	}

	public StringBuilder toJSON(TimeZoneInfo timeZoneInfo) {
		StringBuilder sb = new StringBuilder(24);

		sb.append("{");
		sb.append("\"id\":");
		sb.append(getId());
		sb.append(",\"iataCode\":\"");
		sb.append(getIataCode());
		sb.append("\",\"icaoCode\":\"");
		sb.append(getIcaoCode());
		sb.append("\",\"name\":\"");
		sb.append(getName());
		sb.append("\",\"fullName\":\"");
		sb.append(getFullName());
		sb.append("\",\"cityId\":");
		sb.append(getCityId());
		sb.append(",\"countryId\":");
		sb.append(getCountryId());
		sb.append(",\"timeZoneName\":\"");
		sb.append(timeZoneInfo.getTimeZoneInfoId(getId()));
		sb.append("\",\"location\":{\"longitude\":");
		sb.append(getLongitude());
		sb.append(",\"latitude\":");
		sb.append(getLatitude());
		sb.append(",\"altitude\":");
		sb.append(getAltitude());
		sb.append("}}");

		return sb;
	}

}
