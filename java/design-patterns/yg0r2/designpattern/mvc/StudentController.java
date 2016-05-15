/**
 * 
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