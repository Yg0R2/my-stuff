/**
 * 
 */
package yg0r2.designpattern.visitor;

/**
 * @author Yg0R2
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.visitor.ComputerPartVisitor#visit(yg0r2.designpattern.visitor.Computer)
	 */
	@Override
	public void visit(Computer computer) {
		System.out.println("Displaying Computer");
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.visitor.ComputerPartVisitor#visit(yg0r2.designpattern.visitor.Keyboard)
	 */
	@Override
	public void visit(Keyboard keyboard) {
		System.out.println("Displaying Keyboard");
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.visitor.ComputerPartVisitor#visit(yg0r2.designpattern.visitor.Monitor)
	 */
	@Override
	public void visit(Monitor monitor) {
		System.out.println("Displaying Monitor");
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.visitor.ComputerPartVisitor#visit(yg0r2.designpattern.visitor.Mouse)
	 */
	@Override
	public void visit(Mouse mouse) {
		System.out.println("Displaying Mouse");
	}

}