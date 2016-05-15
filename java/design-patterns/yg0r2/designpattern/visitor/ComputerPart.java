/**
 * 
 */
package yg0r2.designpattern.visitor;

/**
 * @author Yg0R2
 */
public interface ComputerPart {

	public void accept(ComputerPartVisitor computerPartVisitor);

}