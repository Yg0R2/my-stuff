/**
 * 
 */
package yg0r2.designpattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 */
public class CareTaker {

	private List<Memento> _mementoList = new ArrayList<>();

	public void add(Memento memento) {
		_mementoList.add(memento);
	}

	public Memento get(int index) {
		return _mementoList.get(index);
	}

}