/**
 * 
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