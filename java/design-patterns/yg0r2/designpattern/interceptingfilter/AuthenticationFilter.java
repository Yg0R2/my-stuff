/**
 * 
 */
package yg0r2.designpattern.interceptingfilter;

/**
 * @author Yg0R2
 */
public class AuthenticationFilter implements Filter {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.interceptingfilter.Filter#execute(java.lang.String)
	 */
	@Override
	public void execute(String request) {
		System.out.println("Authenticating request: " + request);
	}

}