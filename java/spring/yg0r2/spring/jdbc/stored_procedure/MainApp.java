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

import java.util.List;

import org.springframework.context.ApplicationContext;

import yg0r2.spring.core.Utils;
import yg0r2.spring.jdbc.DBUtils;
import yg0r2.spring.jdbc.example.Student;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_jdbc_framework.htm
 * @see http://www.tutorialspoint.com/spring/calling_stored_procedure.htm
 *
 *      HSQL Database Engine is not one of the databases fully supported for procedure calls
 */
public class MainApp {

	private static final ApplicationContext CONTEXT = Utils.getApplicationContext(MainApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		StudentJDBCTemplate studentJDBCTemplateBean = CONTEXT.getBean("studentJDBCTemplate", StudentJDBCTemplate.class);

		System.out.println("------- Create table -------");

		DBUtils.createStudentTable(studentJDBCTemplateBean.getJdbcTemplate(), true);

		System.out.println("------- Create stored procedure -------");

		DBUtils.createStoredProcedure(studentJDBCTemplateBean.getJdbcTemplate());

		System.out.println("------- Record creation -------");

		studentJDBCTemplateBean.create("Zara", 11);
		studentJDBCTemplateBean.create("Nuha", 2);
		studentJDBCTemplateBean.create("Ayan", 15);

		System.out.println("------- Listing records -------");

		@SuppressWarnings("unchecked")
		List<Student> students = (List<Student>) studentJDBCTemplateBean.listStudents();

		for (Student student : students) {
			System.out.print("Id: '" + student.getId() + "'");
			System.out.print(", Name: '" + student.getName() + "'");
			System.out.println(", Age: '" + student.getAge() + "'");
		}

		System.out.println("------- Updating record with ID = 2 -------");

		studentJDBCTemplateBean.update(2, 20);

		System.out.println("------- Listing record with ID = 2 -------");

		/*Student student = studentJDBCTemplateBean.getStudent(2);
		
		System.out.print("Id: " + student.getId());
		System.out.print(", Name: " + student.getName());
		System.out.println(", Age: " + student.getAge());*/
	}

}
