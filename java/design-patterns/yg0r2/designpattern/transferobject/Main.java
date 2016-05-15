/**
 * 
 */
package yg0r2.designpattern.transferobject;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/transfer_object_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StudentBusinessObject studentBusinessObject = new StudentBusinessObject();

		// Print all students

		for (StudentTransferObject student : studentBusinessObject.getAllStudents()) {
			System.out.println("Student: [ RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
		}

		// Update a student

		int rollNo = 0;

		StudentTransferObject student = studentBusinessObject.getStudent(rollNo);

		student.setName("Michael");

		studentBusinessObject.updateStudent(student);

		// Get the updated Student

		student = studentBusinessObject.getStudent(rollNo);

		System.out.println("Student: [ RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
	}

}