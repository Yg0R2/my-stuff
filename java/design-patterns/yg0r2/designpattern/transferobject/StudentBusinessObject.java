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
package yg0r2.designpattern.transferobject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 */
public class StudentBusinessObject {

	// This list is our Database
	private List<StudentTransferObject> _students;

	public StudentBusinessObject() {
		_students = new ArrayList<>();

		_students.add(new StudentTransferObject("Robert", 0));
		_students.add(new StudentTransferObject("John", 1));
	}

	public void deleteStudent(StudentTransferObject student) {
		_students.remove(student.getRollNo());

		System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database.");
	}

	public List<StudentTransferObject> getAllStudents() {
		return _students;
	}

	public StudentTransferObject getStudent(int rollNo) {
		return _students.get(rollNo);
	}

	public void updateStudent(StudentTransferObject updatedStudent) {
		int rollNo = updatedStudent.getRollNo();

		StudentTransferObject storedStudent = _students.get(rollNo);

		storedStudent.setName(updatedStudent.getName());

		System.out.println("Student: Roll No " + rollNo + ", deleted from database.");
	}

}
