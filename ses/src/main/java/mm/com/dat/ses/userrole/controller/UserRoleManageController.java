/***************************************************************
 * Author       :	Min Arkar Mon							
 * Created Date :	07/10/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.userrole.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRoleManageController {

	// User Role Lists
	@RequestMapping("/ses/userRole_Lists")
	public ModelAndView showUserRoleLists() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/userrole_lists");

		return model;
	}

	// User Role Register
	@RequestMapping("/ses/userRole_register")
	public ModelAndView rolePermissRegister() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/userRole_register");

		return model;
	}

	// User Role Lists
	@RequestMapping("/ses/userRolePermission_Lists")
	public ModelAndView showUserRolePermissionLists() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/userrolepermission_lists");

		return model;
	}

}
