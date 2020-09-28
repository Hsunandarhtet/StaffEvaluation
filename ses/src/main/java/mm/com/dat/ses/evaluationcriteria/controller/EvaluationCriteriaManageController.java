/***************************************************************
 * Author       :	Hsu Nandar Htet						
 * Created Date :	18/9/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.evaluationcriteria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EvaluationCriteriaManageController {

	// Evaluation Criteria Lists
	@RequestMapping("/evalCriteria_lists")
	public ModelAndView showEvalCriteriaLists() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/evalcriteria_lists");

		return model;
	}

	// Evaluation Criteria Register
	@RequestMapping("/evalCriteria_register")
	public ModelAndView evalCriteriaRegister() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/evalcriteria_register");

		return model;
	}

	// Evaluation Criteria Update
	@RequestMapping("/evalCriteria_update")
	public ModelAndView evalCriteriaUpdate() {

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/evalCriteria_register");

		return model;
	}

	/*****************************/

	// Evaluation Criteria Detail Lists
	@RequestMapping("/evalCriteriaDetail_lists")
	public ModelAndView showEvalCriteriaDetailLists() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/evalcriteriadetail_lists");

		return model;
	}

	// Evaluation Criteria Detail Register
	@RequestMapping("/evalCriteriaDetail_register")
	public ModelAndView evalCriteriaDetailRegister() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/evalcriteriadetail_register");

		return model;
	}

	// Evaluation Criteria Detail Update
	@RequestMapping("/evalCriteriaDetail_update")
	public ModelAndView evalCriteriaDetailUpdate() {

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/evalCriteriaDetail_register");

		return model;
	}

}
