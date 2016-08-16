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

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yg0R2
 */
public class ResourcePackBean extends BaseBeanImpl implements BaseBean {

	private static Map<String, String> _context = new HashMap<>(5);

	public ResourcePackBean(String fileName, String URL) {
		this(null, fileName, null, null, URL);
	}

	public ResourcePackBean(String resolution, String fileName, String version, String URL) {
		this(resolution, fileName, null, version, URL);
	}

	public ResourcePackBean(String resolution, String fileName, String minecraftVersion, String version, String URL) {
		super(_context);

		_context.put("fileName", fileName);
		_context.put("minecraftVersion", minecraftVersion);
		_context.put("resolution", resolution);
		_context.put("URL", URL);
		_context.put("version", version);
	}

}
