/**
 * 
 */
package yg0r2.designpattern.nullobject;

import org.apache.commons.lang.ArrayUtils;

/**
 * @author Yg0R2
 */
public class CustomerFactory {

	public static final String[] NAMES = {"Rob", "Joe", "Julie"};

	public static AbstractCustomer getCustomer(String name) {
		if (ArrayUtils.contains(NAMES, name)) {
			return new RealCustomer(name);
		}

		return new NullCustomer();
	}

}