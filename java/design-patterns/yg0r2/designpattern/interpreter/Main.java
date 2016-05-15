/**
 * 
 */
package yg0r2.designpattern.interpreter;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/interpreter_pattern.htm
 */
public class Main {

	//Rule: Robert and John are male
	public static Expression getMaleExpression() {
		Expression robertExpression = new TerminalExpression("Robert");
		Expression johnExpression = new TerminalExpression("John");

		return new OrExpression(robertExpression, johnExpression);
	}

	//Rule: Julie is a married women
	public static Expression getMarriedWomanExpression() {
		Expression julieExpression = new TerminalExpression("Julie");
		Expression marriedExpression = new TerminalExpression("married");

		return new AndExpression(julieExpression, marriedExpression);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();

		System.out.println("John is male? " + isMale.interpret("John"));
		System.out.println("Julie is a married women? " + isMarriedWoman.interpret("married Julie"));
	}

}