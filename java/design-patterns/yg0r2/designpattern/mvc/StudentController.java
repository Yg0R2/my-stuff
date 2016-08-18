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
 */
public class StudentController {

	private Student _model;
	private StudentView _view;

	public StudentController(Student model, StudentView view) {
		_model = model;

		_view = view;
	}

	public String getStudentName() {
		return _model.getName();
	}

	public String getStudentRollNo() {
		return _model.getRollNo();
	}

	public void setStudentName(String name) {
		_model.setName(name);
	}

	public void setStudentRollNo(String rollNo) {
		_model.setRollNo(rollNo);
	}

	public void updateView() {
		_view.printStudentDetails(_model.getName(), _model.getRollNo());
	}

}
