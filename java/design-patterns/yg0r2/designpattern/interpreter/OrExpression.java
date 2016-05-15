/**
 * 
 */
package yg0r2.designpattern.interpreter;

/**
 * @author Yg0R2
 */
public class OrExpression implements Expression {

	private Expression _expression1;
	private Expression _expression2;

	/**
	 * 
	 */
	public OrExpression(Expression expression1, Expression expression2) {
		_expression1 = expression1;
		_expression2 = expression2;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.interpreter.Expression#interpret(java.lang.String)
	 */
	@Override
	public boolean interpret(String context) {
		return _expression1.interpret(context) || _expression2.interpret(context);
	}

}