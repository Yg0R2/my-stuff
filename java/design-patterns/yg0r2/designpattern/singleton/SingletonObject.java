/**
 * 
 */
package yg0r2.designpattern.singleton;

/**
 * @author Yg0R2
 */
public class SingletonObject {

	private static SingletonObject instance = new SingletonObject();

	private SingletonObject() {
	}

	public static SingletonObject getInstance() {
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello World!");
	}

}