package mm.com.dat.ses.rating.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RatingManageController {

	// Rating Lists
	@RequestMapping("/rating_lists")
	public ModelAndView showRatingLists() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/rating_lists");

		return model;
	}

	// Rating Register
	@RequestMapping("/rating_register")
	public ModelAndView ratingRegister() {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/rating_register");

		return model;
	}

	// Rating Update
	@RequestMapping("/rating_update")
	public ModelAndView impromentTypeUpdate() {

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/rating_register");

		return model;
	}

}
