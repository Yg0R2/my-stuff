/**
 * 
 */
package yg0r2.designpattern.visitor;

/**
 * @author Yg0R2
 */
public class Mouse implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}

}