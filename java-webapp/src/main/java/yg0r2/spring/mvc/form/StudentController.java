/**
 * 
 */
package yg0r2.spring.mvc.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_web_mvc_framework.htm
 * @see http://www.tutorialspoint.com/spring/spring_mvc_form_handling_example.htm
 *
 * @access http://localhost:8080/MyStuff-Webapp/student
 */
@Controller
public class StudentController {

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("student", "command", new Student());
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("SpringWeb")Student student, ModelMap model) {
		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getId());
		model.addAttribute("name", student.getName());

		return "result";
	}

}
