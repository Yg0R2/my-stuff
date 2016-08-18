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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/filter_pattern.htm
 */
public class Main {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();

		persons.add(new Person("Robert", "MALE", "SINGLE"));
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

	public static void printPersons(List<Person> persons) {
		for (Person person : persons) {
			System.out.println("Person : [ Name : " + person.getName() + ", Gender : " + person.getGender()
				+ ", Marital Status : " + person.getMaritalStatus() + " ]");
		}
	}
}
