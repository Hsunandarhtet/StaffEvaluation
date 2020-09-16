package mm.com.dat.ses.improvementtype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImprovementTypeManageController {

	// ImprovementType Lists
	@RequestMapping("/impromentType_lists")
	public ModelAndView showimpromentTypeLists() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/improvementtype_lists");

		return model;
	}

	// ImprovementType Register
	@RequestMapping("/impromentType_register")
	public ModelAndView impromentTypeRegister() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/improvementtype_register");

		return model;
	}

	// ImprovementType Update
	@RequestMapping("/impromentType_update")
	public ModelAndView impromentTypeUpdate() {

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/impromentType_register");

		return model;
	}

}
