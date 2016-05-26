/**
 * 
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
