/**
 * 
 */
package yg0r2.designpattern.visitor;

/**
 * @author Yg0R2
 */
public interface ComputerPartVisitor {

	public void visit(Computer computer);

	public void visit(Keyboard keyboard);

	public void visit(Monitor monitor);

	public void visit(Mouse mouse);

}