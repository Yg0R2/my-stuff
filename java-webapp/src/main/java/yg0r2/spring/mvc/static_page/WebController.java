/**
 * 
 */
package yg0r2.spring.mvc.static_page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/spring/spring_web_mvc_framework.htm
 * @see http://www.tutorialspoint.com/spring/spring_static_pages_example.htm
 *
 * @access http://localhost:8080/MyStuff-Webapp/static-index
 */
@Controller
public class WebController {

	@RequestMapping(value = "/static-index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/staticPage", method = RequestMethod.GET)
	public String redirect() {
		return "redirect:/static-page/pages/final.htm";
	}

}
