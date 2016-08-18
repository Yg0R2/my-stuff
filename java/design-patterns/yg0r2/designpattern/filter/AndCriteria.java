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
package yg0r2.designpattern.filter;

import java.util.List;

/**
 * @author Yg0R2
 */
public class AndCriteria implements Criteria {

	private Criteria _criteria1;
	private Criteria _criteria2;

	public AndCriteria(Criteria criteria1, Criteria criteria2) {
		_criteria1 = criteria1;
		_criteria2 = criteria2;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.filter.Criteria#meetCriteria(java.util.List)
	 */
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> personsAfterCriteria1 = _criteria1.meetCriteria(persons);

		return _criteria2.meetCriteria(personsAfterCriteria1);
	}

}
