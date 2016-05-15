/**
 * 
 */
package yg0r2.designpattern.servicelocator;

import yg0r2.core.util.Validator;

/**
 * @author Yg0R2
 */
public class ServiceLocator {

	private static Cache _cache = new Cache();

	public static Service getService(String jndiName) {
		Service service = _cache.getService(jndiName);

		if (Validator.isNull(service)) {
			InitialContext initialContext = new InitialContext();

			service = (Service) initialContext.lookup(jndiName);

			_cache.addService(service);
		}

		return service;
	}

}