/***************************************************************
 * Author       :	Min Arkar Mon							
 * Created Date :	30/9/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginContoller {

	// Login to Application
	@RequestMapping("/login")
	public ModelAndView login() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/login");

		return model;
	}

}
