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

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import yg0r2.core.util.IdUtil;

/**
 * @author Yg0R2
 */
public class Country {

	private int _id = IdUtil.getNewId();
	private String _name;

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

	public StringBuilder toJSON() {
		List<String> countryCodes = Arrays.asList(Locale.getISOCountries());

		// The result will be only 1 element
		String isoCode2Character = countryCodes.stream()
			.filter(countryCode -> getName().equals(new Locale("", countryCode).getDisplayCountry())).limit(1)
			.collect(Collectors.joining());

		// The same structure with Java 7 syntax
		/*for (String countryCode : countryCodes) {
			Locale locale = new Locale("", countryCode);

			if (locale.getDisplayCountry().equals(getName())) {
				isoCode = locale.getCountry();

				break;
			}
		}*/

		String isoCode3Character = new Locale("", isoCode2Character).getISO3Country();

		StringBuilder sb = new StringBuilder();

		sb.append("{");
		sb.append("\"id\":");
		sb.append(getId());
		sb.append(",\"name\":\"");
		sb.append(getName());
		sb.append("\",\"twoLetterISOCode\":\"");
		sb.append(isoCode2Character);
		sb.append("\",\"threeLetterISOCode\":\"");
		sb.append(isoCode3Character);
		sb.append("\"}");

		return sb;
	}

}
