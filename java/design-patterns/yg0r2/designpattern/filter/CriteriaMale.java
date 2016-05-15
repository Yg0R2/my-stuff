/**
 * 
 */
package yg0r2.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 */
public class CriteriaMale implements Criteria {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.filter.Criteria#meetCriteria(java.util.List)
	 */
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> malePersons = new ArrayList<Person>();

		for (Person person : persons) {
			if (person.getGender().equals("MALE")) {
				malePersons.add(person);
			}
		}

		return malePersons;
	}

}