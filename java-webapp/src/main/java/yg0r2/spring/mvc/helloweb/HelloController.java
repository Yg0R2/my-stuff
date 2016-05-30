/**
 * 
 */
package yg0r2.spring.mvc.helloweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_web_mvc_framework.htm
 * @see http://www.tutorialspoint.com/spring/spring_mvc_hello_world_example.htm
 *
 * @access http://localhost:8080/MyStuff-Webapp/helloweb
 */
@Controller
@RequestMapping("/helloweb")
public class HelloController{

	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");

		return "hello";
	}

}
