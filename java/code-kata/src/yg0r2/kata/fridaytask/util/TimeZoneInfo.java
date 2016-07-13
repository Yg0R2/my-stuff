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
import java.nio.file.Paths;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Yg0R2
 */
public class TimeZoneInfo {

	private static Map<Integer, String> _airportTimeZoneMap = new HashMap<>();
	private static final Map<String, String> _TIMEZONE_MAPPINGS;

	static {
		_TIMEZONE_MAPPINGS = new HashMap<>(175);

		//
		// Windows Mappings
		//
		_TIMEZONE_MAPPINGS.put("Romance", "Europe/Paris");
		_TIMEZONE_MAPPINGS.put("Romance Standard Time", "Europe/Paris");
		_TIMEZONE_MAPPINGS.put("Warsaw", "Europe/Warsaw");
		_TIMEZONE_MAPPINGS.put("Central Europe", "Europe/Prague");
		_TIMEZONE_MAPPINGS.put("Central Europe Standard Time", "Europe/Prague");
		_TIMEZONE_MAPPINGS.put("Prague Bratislava", "Europe/Prague");
		_TIMEZONE_MAPPINGS.put("W. Central Africa Standard Time", "Africa/Luanda");
		_TIMEZONE_MAPPINGS.put("FLE", "Europe/Helsinki");
		_TIMEZONE_MAPPINGS.put("FLE Standard Time", "Europe/Helsinki");
		_TIMEZONE_MAPPINGS.put("GFT", "Europe/Athens");
		_TIMEZONE_MAPPINGS.put("GFT Standard Time", "Europe/Athens");
		_TIMEZONE_MAPPINGS.put("GTB", "Europe/Athens");
		_TIMEZONE_MAPPINGS.put("GTB Standard Time", "Europe/Athens");
		_TIMEZONE_MAPPINGS.put("Israel", "Asia/Jerusalem");
		_TIMEZONE_MAPPINGS.put("Israel Standard Time", "Asia/Jerusalem");
		_TIMEZONE_MAPPINGS.put("Arab", "Asia/Riyadh");
		_TIMEZONE_MAPPINGS.put("Arab Standard Time", "Asia/Riyadh");
		_TIMEZONE_MAPPINGS.put("Arabic Standard Time", "Asia/Baghdad");
		_TIMEZONE_MAPPINGS.put("E. Africa", "Africa/Nairobi");
		_TIMEZONE_MAPPINGS.put("E. Africa Standard Time", "Africa/Nairobi");
		_TIMEZONE_MAPPINGS.put("Saudi Arabia", "Asia/Riyadh");
		_TIMEZONE_MAPPINGS.put("Saudi Arabia Standard Time", "Asia/Riyadh");
		_TIMEZONE_MAPPINGS.put("Iran", "Asia/Tehran");
		_TIMEZONE_MAPPINGS.put("Iran Standard Time", "Asia/Tehran");
		_TIMEZONE_MAPPINGS.put("Afghanistan", "Asia/Kabul");
		_TIMEZONE_MAPPINGS.put("Afghanistan Standard Time", "Asia/Kabul");
		_TIMEZONE_MAPPINGS.put("India", "Asia/Calcutta");
		_TIMEZONE_MAPPINGS.put("India Standard Time", "Asia/Calcutta");
		_TIMEZONE_MAPPINGS.put("Myanmar Standard Time", "Asia/Rangoon");
		_TIMEZONE_MAPPINGS.put("Nepal Standard Time", "Asia/Katmandu");
		_TIMEZONE_MAPPINGS.put("Sri Lanka", "Asia/Colombo");
		_TIMEZONE_MAPPINGS.put("Sri Lanka Standard Time", "Asia/Colombo");
		_TIMEZONE_MAPPINGS.put("Beijing", "Asia/Shanghai");
		_TIMEZONE_MAPPINGS.put("China", "Asia/Shanghai");
		_TIMEZONE_MAPPINGS.put("China Standard Time", "Asia/Shanghai");
		_TIMEZONE_MAPPINGS.put("AUS Central", "Australia/Darwin");
		_TIMEZONE_MAPPINGS.put("AUS Central Standard Time", "Australia/Darwin");
		_TIMEZONE_MAPPINGS.put("Cen. Australia", "Australia/Adelaide");
		_TIMEZONE_MAPPINGS.put("Cen. Australia Standard Time", "Australia/Adelaide");
		_TIMEZONE_MAPPINGS.put("Vladivostok", "Asia/Vladivostok");
		_TIMEZONE_MAPPINGS.put("Vladivostok Standard Time", "Asia/Vladivostok");
		_TIMEZONE_MAPPINGS.put("West Pacific", "Pacific/Guam");
		_TIMEZONE_MAPPINGS.put("West Pacific Standard Time", "Pacific/Guam");
		_TIMEZONE_MAPPINGS.put("E. South America", "America/Sao_Paulo");
		_TIMEZONE_MAPPINGS.put("E. South America Standard Time", "America/Sao_Paulo");
		_TIMEZONE_MAPPINGS.put("Greenland Standard Time", "America/Godthab");
		_TIMEZONE_MAPPINGS.put("Newfoundland", "America/St_Johns");
		_TIMEZONE_MAPPINGS.put("Newfoundland Standard Time", "America/St_Johns");
		_TIMEZONE_MAPPINGS.put("Pacific SA", "America/Caracas");
		_TIMEZONE_MAPPINGS.put("Pacific SA Standard Time", "America/Caracas");
		_TIMEZONE_MAPPINGS.put("SA Western", "America/Caracas");
		_TIMEZONE_MAPPINGS.put("SA Western Standard Time", "America/Caracas");
		_TIMEZONE_MAPPINGS.put("SA Pacific", "America/Bogota");
		_TIMEZONE_MAPPINGS.put("SA Pacific Standard Time", "America/Bogota");
		_TIMEZONE_MAPPINGS.put("US Eastern", "America/Indianapolis");
		_TIMEZONE_MAPPINGS.put("US Eastern Standard Time", "America/Indianapolis");
		_TIMEZONE_MAPPINGS.put("Central America Standard Time", "America/Regina");
		_TIMEZONE_MAPPINGS.put("Mexico", "America/Mexico_City");
		_TIMEZONE_MAPPINGS.put("Mexico Standard Time", "America/Mexico_City");
		_TIMEZONE_MAPPINGS.put("Canada Central", "America/Regina");
		_TIMEZONE_MAPPINGS.put("Canada Central Standard Time", "America/Regina");
		_TIMEZONE_MAPPINGS.put("US Mountain", "America/Phoenix");
		_TIMEZONE_MAPPINGS.put("US Mountain Standard Time", "America/Phoenix");
		_TIMEZONE_MAPPINGS.put("GMT", "Europe/London");
		_TIMEZONE_MAPPINGS.put("GMT Standard Time", "Europe/London");
		_TIMEZONE_MAPPINGS.put("Ekaterinburg", "Asia/Yekaterinburg");
		_TIMEZONE_MAPPINGS.put("Ekaterinburg Standard Time", "Asia/Yekaterinburg");
		_TIMEZONE_MAPPINGS.put("West Asia", "Asia/Karachi");
		_TIMEZONE_MAPPINGS.put("West Asia Standard Time", "Asia/Karachi");
		_TIMEZONE_MAPPINGS.put("Central Asia", "Asia/Dhaka");
		_TIMEZONE_MAPPINGS.put("Central Asia Standard Time", "Asia/Dhaka");
		_TIMEZONE_MAPPINGS.put("N. Central Asia Standard Time", "Asia/Novosibirsk");
		_TIMEZONE_MAPPINGS.put("Bangkok", "Asia/Bangkok");
		_TIMEZONE_MAPPINGS.put("Bangkok Standard Time", "Asia/Bangkok");
		_TIMEZONE_MAPPINGS.put("North Asia Standard Time", "Asia/Krasnoyarsk");
		_TIMEZONE_MAPPINGS.put("SE Asia", "Asia/Bangkok");
		_TIMEZONE_MAPPINGS.put("SE Asia Standard Time", "Asia/Bangkok");
		_TIMEZONE_MAPPINGS.put("North Asia East Standard Time", "Asia/Ulaanbaatar");
		_TIMEZONE_MAPPINGS.put("Singapore", "Asia/Singapore");
		_TIMEZONE_MAPPINGS.put("Singapore Standard Time", "Asia/Singapore");
		_TIMEZONE_MAPPINGS.put("Taipei", "Asia/Taipei");
		_TIMEZONE_MAPPINGS.put("Taipei Standard Time", "Asia/Taipei");
		_TIMEZONE_MAPPINGS.put("W. Australia", "Australia/Perth");
		_TIMEZONE_MAPPINGS.put("W. Australia Standard Time", "Australia/Perth");
		_TIMEZONE_MAPPINGS.put("Korea", "Asia/Seoul");
		_TIMEZONE_MAPPINGS.put("Korea Standard Time", "Asia/Seoul");
		_TIMEZONE_MAPPINGS.put("Tokyo", "Asia/Tokyo");
		_TIMEZONE_MAPPINGS.put("Tokyo Standard Time", "Asia/Tokyo");
		_TIMEZONE_MAPPINGS.put("Yakutsk", "Asia/Yakutsk");
		_TIMEZONE_MAPPINGS.put("Yakutsk Standard Time", "Asia/Yakutsk");
		_TIMEZONE_MAPPINGS.put("Central European", "Europe/Belgrade");
		_TIMEZONE_MAPPINGS.put("Central European Standard Time", "Europe/Belgrade");
		_TIMEZONE_MAPPINGS.put("W. Europe", "Europe/Berlin");
		_TIMEZONE_MAPPINGS.put("W. Europe Standard Time", "Europe/Berlin");
		_TIMEZONE_MAPPINGS.put("Tasmania", "Australia/Hobart");
		_TIMEZONE_MAPPINGS.put("Tasmania Standard Time", "Australia/Hobart");
		_TIMEZONE_MAPPINGS.put("AUS Eastern", "Australia/Sydney");
		_TIMEZONE_MAPPINGS.put("AUS Eastern Standard Time", "Australia/Sydney");
		_TIMEZONE_MAPPINGS.put("E. Australia", "Australia/Brisbane");
		_TIMEZONE_MAPPINGS.put("E. Australia Standard Time", "Australia/Brisbane");
		_TIMEZONE_MAPPINGS.put("Sydney Standard Time", "Australia/Sydney");
		_TIMEZONE_MAPPINGS.put("Central Pacific", "Pacific/Guadalcanal");
		_TIMEZONE_MAPPINGS.put("Central Pacific Standard Time", "Pacific/Guadalcanal");
		_TIMEZONE_MAPPINGS.put("Dateline", "Pacific/Majuro");
		_TIMEZONE_MAPPINGS.put("Dateline Standard Time", "Pacific/Majuro");
		_TIMEZONE_MAPPINGS.put("Fiji", "Pacific/Fiji");
		_TIMEZONE_MAPPINGS.put("Fiji Standard Time", "Pacific/Fiji");
		_TIMEZONE_MAPPINGS.put("Samoa", "Pacific/Apia");
		_TIMEZONE_MAPPINGS.put("Samoa Standard Time", "Pacific/Apia");
		_TIMEZONE_MAPPINGS.put("Hawaiian", "Pacific/Honolulu");
		_TIMEZONE_MAPPINGS.put("Hawaiian Standard Time", "Pacific/Honolulu");
		_TIMEZONE_MAPPINGS.put("Alaskan", "America/Anchorage");
		_TIMEZONE_MAPPINGS.put("Alaskan Standard Time", "America/Anchorage");
		_TIMEZONE_MAPPINGS.put("Pacific", "America/Los_Angeles");
		_TIMEZONE_MAPPINGS.put("Pacific Standard Time", "America/Los_Angeles");
		_TIMEZONE_MAPPINGS.put("Mexico Standard Time 2", "America/Chihuahua");
		_TIMEZONE_MAPPINGS.put("Mountain", "America/Denver");
		_TIMEZONE_MAPPINGS.put("Mountain Standard Time", "America/Denver");
		_TIMEZONE_MAPPINGS.put("Central", "America/Chicago");
		_TIMEZONE_MAPPINGS.put("Central Standard Time", "America/Chicago");
		_TIMEZONE_MAPPINGS.put("Eastern", "America/New_York");
		_TIMEZONE_MAPPINGS.put("Eastern Standard Time", "America/New_York");
		_TIMEZONE_MAPPINGS.put("E. Europe", "Europe/Bucharest");
		_TIMEZONE_MAPPINGS.put("E. Europe Standard Time", "Europe/Bucharest");
		_TIMEZONE_MAPPINGS.put("Egypt", "Africa/Cairo");
		_TIMEZONE_MAPPINGS.put("Egypt Standard Time", "Africa/Cairo");
		_TIMEZONE_MAPPINGS.put("South Africa", "Africa/Harare");
		_TIMEZONE_MAPPINGS.put("South Africa Standard Time", "Africa/Harare");
		_TIMEZONE_MAPPINGS.put("Atlantic", "America/Halifax");
		_TIMEZONE_MAPPINGS.put("Atlantic Standard Time", "America/Halifax");
		_TIMEZONE_MAPPINGS.put("SA Eastern", "America/Buenos_Aires");
		_TIMEZONE_MAPPINGS.put("SA Eastern Standard Time", "America/Buenos_Aires");
		_TIMEZONE_MAPPINGS.put("Mid-Atlantic", "Atlantic/South_Georgia");
		_TIMEZONE_MAPPINGS.put("Mid-Atlantic Standard Time", "Atlantic/South_Georgia");
		_TIMEZONE_MAPPINGS.put("Azores", "Atlantic/Azores");
		_TIMEZONE_MAPPINGS.put("Azores Standard Time", "Atlantic/Azores");
		_TIMEZONE_MAPPINGS.put("Cape Verde Standard Time", "Atlantic/Cape_Verde");
		_TIMEZONE_MAPPINGS.put("Russian", "Europe/Moscow");
		_TIMEZONE_MAPPINGS.put("Russian Standard Time", "Europe/Moscow");
		_TIMEZONE_MAPPINGS.put("New Zealand", "Pacific/Auckland");
		_TIMEZONE_MAPPINGS.put("New Zealand Standard Time", "Pacific/Auckland");
		_TIMEZONE_MAPPINGS.put("Tonga Standard Time", "Pacific/Tongatapu");
		_TIMEZONE_MAPPINGS.put("Arabian", "Asia/Muscat");
		_TIMEZONE_MAPPINGS.put("Arabian Standard Time", "Asia/Muscat");
		_TIMEZONE_MAPPINGS.put("Caucasus", "Asia/Tbilisi");
		_TIMEZONE_MAPPINGS.put("Caucasus Standard Time", "Asia/Tbilisi");
		_TIMEZONE_MAPPINGS.put("GMT Standard Time", "GMT");
		_TIMEZONE_MAPPINGS.put("Greenwich", "GMT");
		_TIMEZONE_MAPPINGS.put("Greenwich Standard Time", "GMT");
	}

	public TimeZoneInfo(String fileName) throws IOException {
		if (!_airportTimeZoneMap.isEmpty()) {
			return;
		}

		byte[] bytes = Files.readAllBytes(Paths.get(fileName));

		String content = new String(bytes);

		Pattern pattern = Pattern.compile("\\{\"AirportId\":([0-9]+),\"TimeZoneInfoId\":\"(.*?)\"\\}");
		Matcher matcher = pattern.matcher(content);

		while (matcher.find()) {
			int airportId = Integer.valueOf(matcher.group(1));
			String timeZoneInfoId = matcher.group(2);

			_airportTimeZoneMap.put(airportId, timeZoneInfoId);
		}
	}

	/**
	 *
	 * @param airportId
	 * @return with the deserialized value from the given 'timezoneinfo.json' file.
	 */
	public String getTimeZoneInfoId(int airportId) {
		return _airportTimeZoneMap.get(airportId);
	}

	/**
	 * Have to 'hack' this a little bit, because Java use a different version of Time/TimeZone than .Net
	 *
	 * @param airportId
	 * @return with the java.time.ZoneId value of the deserialized value.
	 */
	public ZoneId getZoneId(int airportId) {
		String timeZoneName = getTimeZoneInfoId(airportId);

		return TimeZone.getTimeZone(_TIMEZONE_MAPPINGS.get(timeZoneName)).toZoneId();
	}

}
