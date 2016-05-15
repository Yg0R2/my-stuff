/**
 * 
 */
package yg0r2.designpattern.nullobject;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/null_object_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
		AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
		AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
		AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

		System.out.println("Customers");

		System.out.println(customer1.getName());
		System.out.println(customer2.getName());
		System.out.println(customer3.getName());
		System.out.println(customer4.getName());
	}

}