/**
 * 
 */
package yg0r2.spring.jdbc.programmatic_transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


/**
 * @author Yg0R2
 */
public class StudentMarksMapper implements RowMapper<StudentMarks> {

	@Override
	public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentMarks studentMarks = new StudentMarks();

		studentMarks.setId(rs.getInt("id"));
		studentMarks.setName(rs.getString("name"));
		studentMarks.setAge(rs.getInt("age"));
		studentMarks.setSid(rs.getInt("sid"));
		studentMarks.setMarks(rs.getInt("marks"));
		studentMarks.setYear(rs.getInt("year"));

		return studentMarks;
	}

}
