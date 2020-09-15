/***************************************************************
 * Author       :							
 * Created Date :
 * Updated Date :
 * Version      : 
 * Dev History  :
***************************************************************/


package mm.com.dat.ses.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectManageController {
	
	//project Lists
	@RequestMapping("/project_lists")
	public ModelAndView showProjectLists() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/project_lists");

		return model;
	}
	
	//project Registration Form 
	@RequestMapping("/projectRegister")
	public ModelAndView showProjectRegister() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/project_register");

		return model;
	}
	
	//project Registration Form 
	@RequestMapping("/projectEdit")
	public ModelAndView showProjectUpdate() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("redirect:/projectRegister");

		return model;
	}

}
