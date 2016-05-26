/**
 * 
 */
package yg0r2.spring.jdbc.declarative_transaction;

import java.util.List;

import org.springframework.context.ApplicationContext;

import yg0r2.spring.core.Utils;
import yg0r2.spring.jdbc.DBUtils;
import yg0r2.spring.jdbc.example.StudentDAO;
import yg0r2.spring.jdbc.programmatic_transaction.StudentMarks;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_transaction_management.htm
 * @see http://www.tutorialspoint.com/spring/declarative_management.htm
 */
public class MainApp {

	private static final ApplicationContext CONTEXT = Utils.getApplicationContext(MainApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StudentDAO studentJDBCTemplateBean = CONTEXT.getBean("studentJDBCTemplate", StudentDAO.class);

		System.out.println("------- Create table -------");

		DBUtils.createStudentTable(studentJDBCTemplateBean.getJdbcTemplate(), true);
		DBUtils.createMarksTable(studentJDBCTemplateBean.getJdbcTemplate(), true);

		System.out.println("------Records creation--------" );

		studentJDBCTemplateBean.create("Zara", 11, 99, 2010);
		studentJDBCTemplateBean.create("Nuha", 20, 97, 2010);
		studentJDBCTemplateBean.create("Ayan", 25, 100, 2011);

		System.out.println("------Listing all the records--------" );

		@SuppressWarnings("unchecked")
		List<StudentMarks> studentMarks = (List<StudentMarks>) studentJDBCTemplateBean.listStudents();

		for (StudentMarks record : studentMarks) {
			System.out.print("Id: " + record.getId() );
			System.out.print(", Name: " + record.getName() );
			System.out.print(", Marks: " + record.getMarks());
			System.out.print(", Year: " + record.getYear());
			System.out.println(", Age: " + record.getAge());
		}
	}

}
