/**
 * 
 */
package yg0r2.spring.mvc.exception;


/**
 * @author Yg0R2
 */
@SuppressWarnings("serial")
public class SpringException extends RuntimeException {

	private String _exceptionMsg;

	public SpringException(String exceptionMsg) {
		_exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return _exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		_exceptionMsg = exceptionMsg;
	}

}
