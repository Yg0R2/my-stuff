/**
 * 
 */
package yg0r2.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 */
public class Subject {

	private List<Observer> _observerList = new ArrayList<>();
	private int _state;

	public void attach(Observer observer) {
		_observerList.add(observer);
	}

	public int getState() {
		return _state;
	}

	public void notifyAllObservers() {
		for (Observer observer : _observerList) {
			observer.update();
		}
	}

	public void setState(int state) {
		_state = state;

		notifyAllObservers();
	}

}