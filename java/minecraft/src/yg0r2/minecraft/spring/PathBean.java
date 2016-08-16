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
package yg0r2.minecraft.spring;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import jodd.util.StringTemplateParser;
import yg0r2.core.MapMacroResolver;

/**
 * @author Yg0R2
 */
public class PathBean {

	private String _locationTemplate;

	public PathBean(String locationTemplate) {
		_locationTemplate = locationTemplate;
	}

	/**
	 * @return the location
	 */
	public Path getLocation() {
		Map<String, String> context = new HashMap<>(1);
		context.put("userHome", System.getProperty("user.home"));

		StringTemplateParser stringTemplateParser = new StringTemplateParser();

		String location = stringTemplateParser.parse(_locationTemplate, new MapMacroResolver(context));

		return Paths.get(location);
	}

}
