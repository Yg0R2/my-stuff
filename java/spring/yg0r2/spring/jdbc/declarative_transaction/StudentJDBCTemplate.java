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
package yg0r2.spring.jdbc.declarative_transaction;

import java.util.List;

import org.springframework.dao.DataAccessException;

import yg0r2.spring.jdbc.example.StudentDAO;
import yg0r2.spring.jdbc.programmatic_transaction.StudentMarksMapper;

/**
 * @author Yg0R2
 */
public class StudentJDBCTemplate extends yg0r2.spring.jdbc.example.StudentJDBCTemplate implements StudentDAO {

	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		try {
			String sql1 = "INSERT INTO Student(name, age) values (?, ?);";
			jdbcTemplate.update(sql1, name, age);

			// Get the latest student id to be used in Marks table
			String sql2 = "SELECT MAX(id) FROM Student;";
			int sid = jdbcTemplate.queryForObject(sql2, Integer.class);

			String sql3 = "INSERT INTO Marks(sid, marks, year) values (?, ?, ?);";
			jdbcTemplate.update(sql3, sid, marks, year);

			System.out.println(
				"Created Name: " + name + ", Age: " + age + ", Sid: " + sid + ", marks: " + marks + ", year: " + year);

			// to simulate the exception.
			throw new RuntimeException("simulate Error condition");
		}
		catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");

			throw e;
		}
	}

	@Override
	public List<?> listStudents() {
		String sql = "SELECT * FROM Student, Marks WHERE Student.id = Marks.sid";

		return jdbcTemplate.query(sql, new StudentMarksMapper());
	}

}
