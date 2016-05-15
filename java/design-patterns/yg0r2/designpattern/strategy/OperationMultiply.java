/**
 * 
 */
package yg0r2.designpattern.strategy;

/**
 * @author Yg0R2
 */
public class OperationMultiply implements Strategy {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.strategy.Strategy#doOperation(int, int)
	 */
	@Override
	public int doOperation(int number1, int number2) {
		return number1 * number2;
	}

}