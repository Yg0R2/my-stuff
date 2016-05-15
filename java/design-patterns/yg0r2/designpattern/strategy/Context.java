/**
 * 
 */
package yg0r2.designpattern.strategy;

/**
 * @author Yg0R2
 */
public class Context {

	private Strategy _strategy;

	public Context(Strategy strategy) {
		_strategy = strategy;
	}

	public int executeStrategy(int number1, int number2) {
		return _strategy.doOperation(number1, number2);
	}

}