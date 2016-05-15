/**
 * 
 */
package yg0r2.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/filter_pattern.htm
 */
public class Main {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();

		persons.add(new Person("Robert","MALE", "SINGLE"));
		persons.add(new Person("John", "MALE", "MARRIED"));
		persons.add(new Person("Laura", "FEMALE", "MARRIED"));
		persons.add(new Person("Diana", "FEMALE", "SINGLE"));
		persons.add(new Person("Mike", "MALE", "SINGLE"));
		persons.add(new Person("Bobby", "MALE", "SINGLE"));

		Criteria male = new CriteriaMale();
		Criteria female = new CriteriaFemale();
		Criteria single = new CriteriaSingle();
		Criteria singleMale = new AndCriteria(single, male);
		Criteria singleOrFemale = new OrCriteria(single, female);

		System.out.println("Males: ");
		printPersons(male.meetCriteria(persons));

		System.out.println("\nFemales: ");
		printPersons(female.meetCriteria(persons));

		System.out.println("\nSingle Males: ");
		printPersons(singleMale.meetCriteria(persons));

		System.out.println("\nSingle Or Females: ");
		printPersons(singleOrFemale.meetCriteria(persons));
	}

	public static void printPersons(List<Person> persons){
		for (Person person : persons) {
			System.out.println("Person : [ Name : " + person.getName() + ", Gender : " + person.getGender() + ", Marital Status : " + person.getMaritalStatus() + " ]");
		}
	}
}