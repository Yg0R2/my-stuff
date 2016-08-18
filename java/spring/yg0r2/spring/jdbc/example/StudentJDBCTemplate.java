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
package yg0r2.spring.jdbc.example;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Yg0R2
 */
public class StudentJDBCTemplate implements StudentDAO {

	protected JdbcTemplate jdbcTemplate;

	private DataSource _dataSource;

	/*
	 * (non-Javadoc)
	 * @see yg0r2.spring.jdbc.StudentDAO#create(java.lang.String, java.lang.Integer)
	 */
	@Override
	public void create(String name, Integer age) {
		String sql = "INSERT INTO Student (name, age) VALUES (?, ?)";

		jdbcTemplate.update(sql, name, age);

		System.out.println("Record created with: Name = '" + name + "', Age = '" + age + "'");
	}

	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * @see yg0r2.spring.jdbc.StudentDAO#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM Student WHERE id = ?";

		jdbcTemplate.update(sql, id);

		System.out.println("Record deleted with: Id = '" + id + "'");
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/*
	 * (non-Javadoc)
	 * @see yg0r2.spring.jdbc.StudentDAO#getStudent(java.lang.Integer)
	 */
	@Override
	public Student getStudent(Integer id) {
		String sql = "SELECT * FROM Student WHERE id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new StudentMapper());
	}

	/*
	 * (non-Javadoc)
	 * @see yg0r2.spring.jdbc.StudentDAO#listStudents()
	 */
	@Override
	public List<?> listStudents() {
		String sql = "SELECT * FROM Student";

		return jdbcTemplate.query(sql, new StudentMapper());
	}

	/*
	 * (non-Javadoc)
	 * @see yg0r2.spring.jdbc.StudentDAO#setDataSource(javax.sql.DataSource)
	 */
	@Override
	public void setDataSource(DataSource ds) {
		_dataSource = ds;

		jdbcTemplate = new JdbcTemplate(_dataSource);
	}

	/*
	 * (non-Javadoc)
	 * @see yg0r2.spring.jdbc.StudentDAO#update(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void update(Integer id, Integer age) {
		String sql = "UPDATE Student SET age = ? WHERE id = ?";

		jdbcTemplate.update(sql, age, id);

		System.out.println("Record updated with: age = '" + age + "'; where: id = '" + id + "'");
	}

}
