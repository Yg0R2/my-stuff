/**
 * 
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
