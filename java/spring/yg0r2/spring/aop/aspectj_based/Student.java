/**
 * 
 */
package yg0r2.spring.aop.aspectj_based;

/**
 * @author Yg0R2
 */
public class Student {

	private Integer _age;
	private String _name;

	/**
	 * @return the _age
	 */
	public Integer getAge() {
		System.out.println("Age: " + _age);

		return _age;
	}

	/**
	 * @return the _name
	 */
	public String getName() {
		System.out.println("Name: " + _name);

		return _name;
	}

	public void printThrowException() {
		System.out.println("Exception raised.");

		throw new IllegalArgumentException();
	}

	/**
	 * @param age the _age to set
	 */
	public void setAge(Integer age) {
		_age = age;
	}

	/**
	 * @param name the _name to set
	 */
	public void setName(String name) {
		_name = name;
	}
}
