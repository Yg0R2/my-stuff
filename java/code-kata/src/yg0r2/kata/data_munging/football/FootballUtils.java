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
package yg0r2.kata.data_munging.football;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Yg0R2
 */
public class FootballUtils {

	public static List<Football> deserialize(Path filePath) throws IOException {
		List<Football> list = new ArrayList<>();

		Files.lines(filePath).forEach(line -> {
			String[] colums = line.split("\\s+");

			if (colums.length > 9) {
				Football football = new Football();

				football.setTeamName(colums[2]);
				football.setFrom(Integer.valueOf(colums[7]));
				football.setAgainst(Integer.valueOf(colums[9]));

				list.add(football);
			}
		});

		return list;
	}

	public static Football getWithSBiggestDifferentsAgainstAndFrom(List<Football> footballs) {
		Optional<Football> optional =
			footballs.stream().max((f1, f2) -> Integer.compare(f1.getDiffAgainstAndFrom(), f2.getDiffAgainstAndFrom()));

		return optional.get();
	}

	public static Football getWithSmallestDifferentsAgainstAndFrom(List<Football> footballs) {
		Optional<Football> optional =
			footballs.stream().min((f1, f2) -> Integer.compare(f1.getDiffAgainstAndFrom(), f2.getDiffAgainstAndFrom()));

		return optional.get();
	}

}
