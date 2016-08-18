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
package yg0r2.designpattern.servicelocator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yg0R2
 */
public class Cache {

	private Map<String, Service> _services;

	public Cache() {
		_services = new HashMap<>();
	}

	public void addService(Service newService) {
		String serviceName = newService.getName().toUpperCase();

		if (!_services.containsKey(serviceName)) {
			_services.put(serviceName, newService);
		}
	}

	public Service getService(String serviceName) {
		serviceName = serviceName.toUpperCase();

		if (_services.containsKey(serviceName)) {
			System.out.println("Returning cached " + serviceName + " object.");

			return _services.get(serviceName);
		}

		return null;
	}

}
