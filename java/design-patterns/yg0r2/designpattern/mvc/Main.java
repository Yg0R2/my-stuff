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
package yg0r2.designpattern.mvc;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/mvc_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student studentModel = retriveStudentFromDatabase();

		StudentView studentView = new StudentView();

		StudentController studentController = new StudentController(studentModel, studentView);

		studentController.updateView();

		studentController.setStudentName("John");

		studentController.updateView();
	}

	private static Student retriveStudentFromDatabase() {
		Student student = new Student();

		student.setName("Robert");
		student.setRollNo("10");

		return student;
	}

}
