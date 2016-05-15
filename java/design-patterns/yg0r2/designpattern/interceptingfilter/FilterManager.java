/**
 * 
 */
package yg0r2.designpattern.interceptingfilter;

/**
 * @author Yg0R2
 */
public class FilterManager {

	private FilterChain _filterChain;

	public FilterManager(Target target) {
		_filterChain = new FilterChain();

		_filterChain.setTarget(target);
	}

	public void filterRequest(String request) {
		_filterChain.execute(request);
	}

	public void setFilter(Filter filter) {
		_filterChain.addFilter(filter);
	}

}