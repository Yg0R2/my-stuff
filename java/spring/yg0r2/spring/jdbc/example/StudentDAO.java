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
public interface StudentDAO {

	/**
	 * This is the method to be used to create a record in the Student table.
	 */
	public void create(String name, Integer age);

	/**
	 * This is the method to be used to create a record in the Student and Marks tables.
	 */
	public void create(String name, Integer age, Integer marks, Integer year);

	/**
	 * This is the method to be used to delete a record from the Student table corresponding to a passed student id.
	 */
	public void delete(Integer id);

	public JdbcTemplate getJdbcTemplate();

	/**
	 * This is the method to be used to list down a record from the Student table corresponding to a passed student id.
	 */
	public Student getStudent(Integer id);

	/**
	 * This is the method to be used to list down all the records from the Student table.
	 */
	public List<?> listStudents();

	/**
	 * This is the method to be used to initialize database resources ie. connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to update a record into the Student table.
	 */
	public void update(Integer id, Integer age);
}
