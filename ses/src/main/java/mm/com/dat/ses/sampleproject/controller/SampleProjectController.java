package mm.com.dat.ses.sampleproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleProjectController {
	
	//project Lists
		@RequestMapping("/sampleproject_lists")
		public ModelAndView showProjectLists() {

			ModelAndView model = new ModelAndView();			
			model.setViewName("admin/sampleproject_list");

			return model;
		}

}
