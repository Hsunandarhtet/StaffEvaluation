/***************************************************************
 * Author       : Aung Ko Lin						
 * Created Date : 10/01/2020
 * Updated Date : -
 * Version      : 1.0
 * Dev History  : Firstly Created
***************************************************************/


package mm.com.dat.ses.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectManageController {
	
	//project Lists
	@RequestMapping("/ses/project_lists")
	public ModelAndView showProjectLists() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/project_lists");

		return model;
	}
	
	//project Registration Form 
	@RequestMapping("/ses/projectRegister")
	public ModelAndView showProjectRegister() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/project_register");

		return model;
	}
	
	//project Registration Form 
	@RequestMapping("/ses/projectEdit")
	public ModelAndView showProjectUpdate() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("redirect:/ses/projectRegister");

		return model;
	}

}
