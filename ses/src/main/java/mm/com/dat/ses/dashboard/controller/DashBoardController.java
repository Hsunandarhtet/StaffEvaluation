/***************************************************************
 * Author       :	Min Arkar Mon							
 * Created Date :	30/9/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashBoardController {
	
		// Dashboard Screen
		@RequestMapping("/ses/dashboard")
		public ModelAndView dashboard() {

			ModelAndView model = new ModelAndView();
			model.setViewName("admin/dashboard");

			return model;
		}

}
