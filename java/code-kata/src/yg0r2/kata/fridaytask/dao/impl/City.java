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
public class City {

	private int _countryId;
	private int _id = IdUtil.getNewId();
	private String _name;

	/**
	 * @return the countryId
	 */
	public int getCountryId() {
		return _countryId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return _id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(int countryId) {
		_countryId = countryId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		_id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		_name = name;
	}

	public StringBuilder toJSON(TimeZoneInfo timeZoneInfo) {
		StringBuilder sb = new StringBuilder();

		sb.append("{");
		sb.append("\"id\":");
		sb.append(getId());
		sb.append(",\"name\":\"");
		sb.append(getName());
		sb.append("\",\"countryId\":");
		sb.append(getCountryId());
		sb.append(",\"timeZoneName\":,\"");
		sb.append(timeZoneInfo.getTimeZoneInfoId(getId()));
		sb.append("\"}");

		return sb;
	}

}
