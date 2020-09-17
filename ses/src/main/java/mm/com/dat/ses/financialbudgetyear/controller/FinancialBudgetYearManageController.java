package mm.com.dat.ses.financialbudgetyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FinancialBudgetYearManageController {

	// Financial Budget Year Lists
	@RequestMapping("/finBudYear_lists")
	public ModelAndView showFinBudYearLists() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/financialbudgetyear_lists");

		return model;
	}

	// Financial Budget Year Register
	@RequestMapping("/finBudYear_register")
	public ModelAndView finBudYearRegister() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/financialbudgetyear_register");

		return model;
	}

	// Financial Budget Year Update
	@RequestMapping("/finBudYear_update")
	public ModelAndView finBudYearUpdate() {

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/finBudYear_register");

		return model;
	}

}
