/**
 * 
 */
package yg0r2.spring.mvc.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_web_mvc_framework.htm
 * @see http://www.tutorialspoint.com/spring/spring_exception_handling_example.htm
 *
 * @access http://localhost:8080/MyStuff-Webapp/student-exception
 */
@Controller
public class StudentController {

	@RequestMapping(value = "/student-exception", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("student", "command", new Student());
	}

	@RequestMapping(value = "/addStudent-exception", method = RequestMethod.POST)
	@ExceptionHandler({SpringException.class})
	public String addStudent(@ModelAttribute("MyStuff-Webapp")Student student, ModelMap model) {
		if (student.getName().length() < 5) {
			throw new SpringException("Given name is too short.");
		}

		if ((student.getAge() == null) || (student.getAge() < 10)) {
			throw new SpringException("Given age is too low.");
		}

		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getId());
		model.addAttribute("name", student.getName());

		return "result";
	}

}
