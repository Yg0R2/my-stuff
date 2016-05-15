/**
 * 
 */
package yg0r2.designpattern.visitor;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/visitor_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComputerPart computer = new Computer();

		computer.accept(new ComputerPartDisplayVisitor());
	}

}