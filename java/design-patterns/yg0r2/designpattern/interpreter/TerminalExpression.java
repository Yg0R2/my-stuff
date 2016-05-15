/**
 * 
 */
package yg0r2.designpattern.interpreter;

/**
 * @author Yg0R2
 */
public class TerminalExpression implements Expression {

	private String _data;

	/**
	 * 
	 */
	public TerminalExpression(String data) {
		_data = data;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.interpreter.Expression#interpret(java.lang.String)
	 */
	@Override
	public boolean interpret(String context) {
		return context.contains(_data);
	}

}