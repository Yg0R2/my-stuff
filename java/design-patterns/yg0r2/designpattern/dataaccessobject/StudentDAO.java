/**
 * 
 */
package yg0r2.designpattern.dataaccessobject;

import java.util.List;

/**
 * @author Yg0R2
 */
public interface StudentDAO {

	public void deleteStudent(Student student);

	public List<Student> getAllStudents();

	public Student getStudent(int rollNo);

	public void updateStudent(Student student);

}