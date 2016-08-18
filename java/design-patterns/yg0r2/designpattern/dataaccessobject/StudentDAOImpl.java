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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 */
public class StudentDAOImpl implements StudentDAO {

	// This list is our database now
	private List<Student> _students;

	public StudentDAOImpl() {
		_students = new ArrayList<>();

		_students.add(new Student("Robert", 0));
		_students.add(new Student("John", 1));
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.dataaccessobject.StudentDAO#deleteStudent(yg0r2.designpattern.dataaccessobject.Student)
	 */
	@Override
	public void deleteStudent(Student student) {
		int rollNo = student.getRollNo();

		_students.remove(rollNo);

		System.out.println("Student: Roll No " + rollNo + ", deleted from database.");
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.dataaccessobject.StudentDAO#getAllStudents()
	 */
	@Override
	public List<Student> getAllStudents() {
		return _students;
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.dataaccessobject.StudentDAO#getStudent(int)
	 */
	@Override
	public Student getStudent(int rollNo) {
		return _students.get(rollNo);
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.dataaccessobject.StudentDAO#updateStudent(yg0r2.designpattern.dataaccessobject.Student)
	 */
	@Override
	public void updateStudent(Student updateStudent) {
		int rollNo = updateStudent.getRollNo();

		Student storedStudent = _students.get(rollNo);

		storedStudent.setName(updateStudent.getName());

		System.out.println("Student: Roll No " + rollNo + ", updated in the database.");
	}

}
