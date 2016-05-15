/**
 * 
 */
package yg0r2.designpattern.frontcontroller;

/**
 * @author Yg0R2
 */
public class Dispatcher {

	public static final String STUDENT = "student";
	public static final String HOME = "home";

	private HomeView _homeView;
	private StudentView _studentView;

	public Dispatcher() {
		_homeView = new HomeView();

		_studentView = new StudentView();
	}

	public void dispatch(String request) {
		if (request.equals(STUDENT)) {
			_studentView.show();
		}
		else {
			_homeView.show();
		}
	}

}