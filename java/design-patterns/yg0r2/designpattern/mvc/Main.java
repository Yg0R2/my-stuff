/**
 * 
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