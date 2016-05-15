/**
 * 
 */
package yg0r2.designpattern.interceptingfilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 */
public class FilterChain {

	private List<Filter> _filters = new ArrayList<>();
	private Target _target;

	public void addFilter(Filter filter) {
		_filters.add(filter);
	}

	public void execute(String request) {
		for (Filter filter : _filters) {
			filter.execute(request);
		}

		_target.execute(request);
	}

	public void setTarget(Target target) {
		_target = target;
	}

}