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
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import yg0r2.core.util.Validator;

/**
 * @author Yg0R2
 */
public class Utils {

	/**
	 * Deserialize the given file on the <code>filePath</code>, based on the given <code>mapper</code>.
	 *
	 * @param filePath Path of the file which will be deserialized.
	 * @param mapper A mapper which will be used during the deserialization process.
	 * @return With a <code>T</code> type instance.
	 * @throws IOException
	 */
	public static <T> List<T> deserialize(Path filePath, Mapper<T> mapper) throws IOException {
		List<T> list = new ArrayList<T>();

		Files.lines(filePath).forEach(line -> {
			T instance = mapper.map(line);

			if (Validator.isNotNull(instance)) {
				list.add(instance);
			}
		});

		return list;
	}

	/**
	 * @param list A list of a <code>T</code> type objects.
	 * @param comparator The comparator which will compare the elements of the list.
	 * @return With the max element of the list.
	 */
	public static <T> T getMax(List<T> list, Comparator<T> comparator) {
		Optional<T> optional = list.stream().max(comparator);

		return optional.get();
	}

	/**
	 * @param list A list of a <code>T</code> type objects.
	 * @param comparator The comparator which will compare the elements of the list.
	 * @return With the min element of the list.
	 */
	public static <T> T getMin(List<T> list, Comparator<T> comparator) {
		Optional<T> optional = list.stream().min(comparator);

		return optional.get();
	}

}
