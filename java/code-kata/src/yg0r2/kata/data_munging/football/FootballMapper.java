/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package yg0r2.kata.data_munging.football;

import yg0r2.kata.data_munging.Mapper;


/**
 * @author Yg0R2
 */
public class FootballMapper implements Mapper<Football> {

	@Override
	public Football map(String line) {
		String[] colums = line.split("\\s+");

		if ((colums.length < 2) || !colums[1].matches("^[0-9]+\\.")) {
			return null;
		}

		Football football = new Football();

		football.setTeamName(colums[2]);
		football.setFrom(Integer.valueOf(colums[7]));
		football.setAgainst(Integer.valueOf(colums[9]));

		return football;
	}

}
