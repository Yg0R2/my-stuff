/**
 * 
 */
package yg0r2.designpattern.observer;

/**
 * @author Yg0R2
 */
public class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		this.subject = subject;

		this.subject.attach(this);
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.observer.Observer#update()
	 */
	@Override
	public void update() {
		System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
	}

}