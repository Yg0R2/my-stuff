/**
 * 
 */
package yg0r2.designpattern.visitor;

/**
 * @author Yg0R2
 */
public class Computer implements ComputerPart {

	private ComputerPart[] _parts = { new Mouse(), new Keyboard(), new Monitor() };

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		for (int i = 0; i < _parts.length; i++) {
			_parts[i].accept(computerPartVisitor);
		}

		computerPartVisitor.visit(this);
	}

}