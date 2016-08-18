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
package yg0r2.designpattern.dataaccessobject;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StudentDAO studentDAO = new StudentDAOImpl();

		// Print all students

		for (Student student : studentDAO.getAllStudents()) {
			System.out.println("Student: [ RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
		}

		// Update a student

		int rollNo = 0;

		Student student = studentDAO.getStudent(rollNo);

		student.setName("Michael");

		studentDAO.updateStudent(student);

		// Get the updated student

		Student updatedStudent = studentDAO.getStudent(rollNo);

		System.out.println(
			"Student: [ RollNo : " + updatedStudent.getRollNo() + ", Name : " + updatedStudent.getName() + " ]");
	}

}
