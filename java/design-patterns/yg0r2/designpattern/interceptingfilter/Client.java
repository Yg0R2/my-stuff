/**
 * 
 */
package yg0r2.designpattern.interceptingfilter;

/**
 * @author Yg0R2
 */
public class Client {

	private FilterManager _filterManager;

	public void setFilterManager(FilterManager filterManager) {
		_filterManager = filterManager;
	}

	public void setRequest(String request) {
		_filterManager.filterRequest(request);
	}

}