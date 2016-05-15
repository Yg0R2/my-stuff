/**
 * 
 */
package yg0r2.designpattern.strategy;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Context context = new Context(new OperationAdd());		
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationSubstract());		
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationMultiply());		
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	}

}