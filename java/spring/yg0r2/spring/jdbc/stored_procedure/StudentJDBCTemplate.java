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
package yg0r2.spring.jdbc.stored_procedure;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import yg0r2.spring.jdbc.example.Student;

/**
 * @author Yg0R2
 */
public class StudentJDBCTemplate extends yg0r2.spring.jdbc.example.StudentJDBCTemplate {

	private SimpleJdbcCall _jdbcCall;

	@Override
	public Student getStudent(Integer id) {
		SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);

		Map<String, Object> out = _jdbcCall.execute(in);

		Student student = new Student();
		student.setId(id);
		student.setName((String) out.get("out_name"));
		student.setAge((Integer) out.get("out_age"));

		return student;
	}

	@Override
	public void setDataSource(DataSource ds) {
		super.setDataSource(ds);

		_jdbcCall = new SimpleJdbcCall(ds).withProcedureName("getRecord");
	}

}
