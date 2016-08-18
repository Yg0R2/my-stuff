/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
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
