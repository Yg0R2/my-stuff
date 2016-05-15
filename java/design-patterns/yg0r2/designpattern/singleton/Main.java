/**
 * 
 */
package yg0r2.designpattern.singleton;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//The constructor SingletonObject() is not visible
		//SingletonObject singletonObject = new SingletonObject();

		SingletonObject singletonObject = SingletonObject.getInstance();

		singletonObject.showMessage();
	}

}