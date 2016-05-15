/**
 * 
 */
package yg0r2.designpattern.observer;

/**
 * @author Yg0R2
 */
public class OctalObserver extends Observer {

	public OctalObserver(Subject subject) {
		this.subject = subject;

		this.subject.attach(this);
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.observer.Observer#update()
	 */
	@Override
	public void update() {
		System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
	}

}