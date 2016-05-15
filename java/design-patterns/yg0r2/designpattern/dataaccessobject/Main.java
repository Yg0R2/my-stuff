/**
 * 
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

		System.out.println("Student: [ RollNo : " + updatedStudent.getRollNo() + ", Name : " + updatedStudent.getName()
			+ " ]");
	}

}