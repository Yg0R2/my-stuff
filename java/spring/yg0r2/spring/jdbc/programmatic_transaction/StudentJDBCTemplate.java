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

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import yg0r2.spring.jdbc.example.StudentDAO;

/**
 * @author Yg0R2
 */
public class StudentJDBCTemplate extends yg0r2.spring.jdbc.example.StudentJDBCTemplate implements StudentDAO {

	private PlatformTransactionManager _transactionManager;

	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();

		TransactionStatus status = _transactionManager.getTransaction(transactionDefinition);

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

			_transactionManager.commit(status);
		}
		catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");

			_transactionManager.rollback(status);

			throw e;
		}
	}

	@Override
	public List<?> listStudents() {
		String sql = "SELECT * FROM Student, Marks WHERE Student.id = Marks.sid";

		return jdbcTemplate.query(sql, new StudentMarksMapper());
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		_transactionManager = transactionManager;
	}

}
