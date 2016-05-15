/**
 * 
 */
package yg0r2.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 */
public class OrCriteria implements Criteria {

	private Criteria _criteria1;
	private Criteria _criteria2;

	public OrCriteria(Criteria criteria1, Criteria criteria2) {
		_criteria1 = criteria1;
		_criteria2 = criteria2;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.filter.Criteria#meetCriteria(java.util.List)
	 */
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> personsAfterCriteria1 = _criteria1.meetCriteria(persons);
		List<Person> personsAfterCriteria2 = _criteria2.meetCriteria(persons);

		List<Person> result = new ArrayList<Person>();
		result.addAll(personsAfterCriteria1);

		for (Person person : personsAfterCriteria2) {
			if (!result.contains(person)) {
				result.add(person);
			}
		}

		return result;
	}

}