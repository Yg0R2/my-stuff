/**
 * 
 */
package yg0r2.spring.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Yg0R2
 */
public class DBUtils {

	private static Logger logger = LoggerFactory.getLogger(DBUtils.class);

	public static void createMarksTable(JdbcTemplate jdbcTemplate, boolean dropTable) {
		if (dropTable) {
			jdbcTemplate.execute("DROP TABLE Marks IF EXISTS;");

			logger.debug("Drop 'Marks' table.");
		}

		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE Marks (");
		sql.append("    SID INT NOT NULL,");
		sql.append("    MARKS INT NOT NULL,");
		sql.append("    YEAR INT NOT NULL");
		sql.append(");");

		jdbcTemplate.execute(sql.toString());

		logger.debug("Create 'Marks' table.");
	}

	public static void createStoredProcedure(JdbcTemplate jdbcTemplate) {
		jdbcTemplate.execute("DROP PROCEDURE IF EXISTS getRecord;");

		StringBuilder sql = new StringBuilder();

		sql.append("CREATE PROCEDURE getRecord (");
		sql.append("IN in_id INT, OUT out_name VARCHAR(20), OUT out_age INT) ");
		sql.append("READS SQL DATA ");
		sql.append("BEGIN ATOMIC");
		sql.append("   SET out_name = (SELECT name FROM Student where id = in_id);");
		sql.append("   SET out_age = (SELECT age FROM Student where id= in_id);");
		sql.append("END");

		jdbcTemplate.execute(sql.toString());

		logger.debug("Create 'getRecord' stored procedure.");
	}

	public static void createStudentTable(JdbcTemplate jdbcTemplate, boolean dropTable) {
		if (dropTable) {
			jdbcTemplate.execute("DROP TABLE Student IF EXISTS;");

			logger.debug("Drop 'Student' table.");
		}

		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE Student (");
		sql.append("    ID INT IDENTITY PRIMARY KEY,");
		sql.append("    NAME VARCHAR(20) NOT NULL,");
		sql.append("    AGE INT NOT NULL");
		sql.append(");");

		jdbcTemplate.execute(sql.toString());

		logger.debug("Create 'Student' table.");
	}

}
