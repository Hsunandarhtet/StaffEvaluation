/***************************************************************
 * Author       : Aung Ko Lin						
 * Created Date : 10/01/2020
 * Updated Date : -
 * Version      : 1.0
 * Dev History  : Firstly Created
***************************************************************/


package mm.com.dat.ses.department.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentManageController {
	
	//Department Lists
	@RequestMapping("/ses/dept_lists")
	public ModelAndView showUserLists() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/dept_lists");

		return model;
	}
	
	//Department Registration Form 
	@RequestMapping("/ses/deptRegister")
	public ModelAndView showStaffRegister() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/dept_register");

		return model;
	}
	
	//Department Registration Form 
	@RequestMapping("/ses/deptEdit")
	public ModelAndView showDeptUpdate() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("redirect:/ses/deptRegister");

		return model;
	}

}
