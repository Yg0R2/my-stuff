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
package yg0r2.kata.data_munging;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import yg0r2.core.util.FileUtils;
import yg0r2.kata.data_munging.football.Football;
import yg0r2.kata.data_munging.football.FootballUtils;
import yg0r2.kata.data_munging.weather.Weather;
import yg0r2.kata.data_munging.weather.WeatherUtils;

/**
 * @author Yg0R2
 * @See http://codekata.com/kata/kata04-data-munging/
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		Main instance = new Main();

		instance.partOne_Weather(FileUtils.getResourcePath(Main.class, "weather.dat"));

		System.out.println("-----------------------------");

		instance.partTwo_SoocerLeagueTable(FileUtils.getResourcePath(Main.class, "football.dat"));
	}

	protected void partOne_Weather(Path filePath) throws IOException {
		List<Weather> weathers = WeatherUtils.deserialize(filePath);

		Weather max = WeatherUtils.getMaxTemperatureSpread(weathers);

		System.out.println("Maximum temperature spread day is " + max.getDay() + ", with " + max.getTemperatureSpread()
			+ " temperature spread.");

		Weather min = WeatherUtils.getMinTemperatureSpread(weathers);

		System.out.println("Minimum temperature spread day is " + min.getDay() + ", with " + min.getTemperatureSpread()
			+ " temperature spread.");
	}

	protected void partTwo_SoocerLeagueTable(Path filePath) throws IOException {
		List<Football> footballs = FootballUtils.deserialize(filePath);

		Football max = FootballUtils.getWithSBiggestDifferentsAgainstAndFrom(footballs);

		System.out.println(
			"Biggest diff between from and againts: " + max.getTeamName() + ", " + max.getDiffAgainstAndFrom());

		Football min = FootballUtils.getWithSmallestDifferentsAgainstAndFrom(footballs);

		System.out.println(
			"Smallest diff between from and againts: " + min.getTeamName() + ", " + min.getDiffAgainstAndFrom());

	}


}
