/***************************************************************
 * Author       :							
 * Created Date :
 * Updated Date :
 * Version      : 
 * Dev History  :
***************************************************************/


package mm.com.dat.ses.department.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentManageController {
	
	//Department Lists
	@RequestMapping("/dept_lists")
	public ModelAndView showUserLists() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/dept_lists");

		return model;
	}
	
	//Department Registration Form 
	@RequestMapping("/deptRegister")
	public ModelAndView showStaffRegister() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/dept_register");

		return model;
	}
	
	//Department Registration Form 
	@RequestMapping("/deptEdit")
	public ModelAndView showDeptUpdate() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("redirect:/deptRegister");

		return model;
	}

}
