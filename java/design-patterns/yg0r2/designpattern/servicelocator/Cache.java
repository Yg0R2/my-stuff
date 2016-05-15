/**
 * 
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