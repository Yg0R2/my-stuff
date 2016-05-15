/**
 * 
 */
package yg0r2.designpattern.mediator;

import java.util.Date;

/**
 * @author Yg0R2
 */
public class ChatRoom {

	public static void showMessage(User user, String message) {
		Date now = new Date();

		System.out.println(now.toString() + " [" + user.getName() + "] : " + message);
	}

}