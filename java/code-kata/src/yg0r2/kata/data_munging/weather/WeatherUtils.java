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
package yg0r2.kata.data_munging.weather;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Yg0R2
 */
public class WeatherUtils {

	public static List<Weather> deserialize(Path filePath) throws IOException {
		List<Weather> list = new ArrayList<>();

		Files.lines(filePath).forEach(line -> {
			String[] colums = line.split("\\s+");

			if ((colums.length > 1) && colums[1].matches("^[0-9]+")) {
				Weather weather = new Weather();

				weather.setDay(Integer.valueOf(colums[1]));
				weather.setMinTemperature(Float.valueOf(colums[2].replace("*", "")));
				weather.setMaxTemperature(Float.valueOf(colums[3].replace("*", "")));

				list.add(weather);
			}
		});

		return list;
	}

	public static Weather getMaxTemperatureSpread(List<Weather> weathers) {
		Optional<Weather> maxTemperatureSpread =
			weathers.stream().max((w1, w2) -> Float.compare(w1.getTemperatureSpread(), w2.getTemperatureSpread()));

		return maxTemperatureSpread.get();
	}

	public static Weather getMinTemperatureSpread(List<Weather> weathers) {
		Optional<Weather> minTemperatureSpread =
			weathers.stream().min((w1, w2) -> Float.compare(w1.getTemperatureSpread(), w2.getTemperatureSpread()));

		return minTemperatureSpread.get();
	}

}
