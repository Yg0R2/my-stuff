/**
 * 
 */
package yg0r2.spring.mvc.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_web_mvc_framework.htm
 * @see http://www.tutorialspoint.com/spring/spring_page_redirection_example.htm
 *
 * @access http://localhost:8080/MyStuff-Webapp/index
 */
@Controller
public class WebController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String redirect() {
		return "redirect:finalPage";
	}

	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
	public String finalPage() {
		return "final";
	}

}
