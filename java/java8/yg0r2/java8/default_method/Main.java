/**
 * 
 */
package yg0r2.java8.default_method;


/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java8/java8_default_methods.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vehicle car = new Car();

		car.print();
	}

}

interface Vehicle {

	default void print() {
		System.out.println("I am a vehicle.");
	}

	static void blowHorn() {
		System.out.println("Blowing horn!");
	}

}

interface FourWheeler {

	default void print() {
		System.out.println("I am a four wheeler.");
	}

}

class Car implements Vehicle, FourWheeler {

	@Override
	public void print() {
		Vehicle.super.print();

		FourWheeler.super.print();

		Vehicle.blowHorn();

		System.out.println("I am a car.");
	}

}