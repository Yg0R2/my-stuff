/**
 * 
 */
package yg0r2.spring.jdbc.programmatic_transaction;

import yg0r2.spring.jdbc.example.Student;

/**
 * @author Yg0R2
 */
public class StudentMarks extends Student {

	private Integer _marks;
	private Integer _sid;
	private Integer _year;
	
	/**
	 * @return the _marks
	 */
	public Integer getMarks() {
		return _marks;
	}
	
	/**
	 * @return the _sid
	 */
	public Integer getSid() {
		return _sid;
	}
	
	/**
	 * @return the _year
	 */
	public Integer getYear() {
		return _year;
	}
	
	/**
	 * @param marks the _marks to set
	 */
	public void setMarks(Integer marks) {
		_marks = marks;
	}
	
	/**
	 * @param sid the _sid to set
	 */
	public void setSid(Integer sid) {
		_sid = sid;
	}
	
	/**
	 * @param year the _year to set
	 */
	public void setYear(Integer year) {
		_year = year;
	}

}
