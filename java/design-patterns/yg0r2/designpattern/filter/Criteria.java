/**
 * 
 */
package yg0r2.designpattern.filter;

import java.util.List;

/**
 * @author Yg0R2
 */
public interface Criteria {

	public List<Person> meetCriteria(List<Person> persons);

}