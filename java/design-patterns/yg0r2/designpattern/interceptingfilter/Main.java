/**
 * 
 */
package yg0r2.designpattern.interceptingfilter;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/intercepting_filter_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FilterManager filterManager = new FilterManager(new Target());

		filterManager.setFilter(new AuthenticationFilter());
		filterManager.setFilter(new DebugFilter());

		Client client = new Client();

		client.setFilterManager(filterManager);

		client.setRequest("HOME");
	}

}