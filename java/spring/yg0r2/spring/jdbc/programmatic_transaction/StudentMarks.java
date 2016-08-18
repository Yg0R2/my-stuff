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
