/**
 * 
 */
package yg0r2.designpattern.frontcontroller;

/**
 * @author Yg0R2
 */
public class FrontController {

	private Dispatcher _dispatcher;

	public FrontController() {
		_dispatcher = new Dispatcher();
	}

	public void dispatchRequest(String request) {
		_trackRequest(request);

		if (_isUserAuthenticated()) {
			_dispatcher.dispatch(request);
		}
	}

	private boolean _isUserAuthenticated() {
		System.out.println("User is authenticated successfully.");

		return true;
	}

	private void _trackRequest(String request) {
		System.out.println("Page request: " + request);
	}

}