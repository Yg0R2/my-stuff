/**
 * 
 */
package yg0r2.spring.jdbc.example;

/**
 * @author Yg0R2
 */
public class Student {

	private Integer _age;
	private Integer _id;
	private String _name;

	/**
	 * @return the _age
	 */
	public Integer getAge() {
		return _age;
	}

	/**
	 * @return the _id
	 */
	public Integer getId() {
		return _id;
	}

	/**
	 * @return the _name
	 */
	public String getName() {
		return _name;
	}

	public void printThrowException() {
		System.out.println("Exception raised.");

		throw new IllegalArgumentException();
	}

	/**
	 * @param id the _id to set
	 */
	public void setId(Integer id) {
		_id = id;
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
