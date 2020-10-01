/***************************************************************
 * Author       : Aung Ko Lin						
 * Created Date : 10/01/2020
 * Updated Date : -
 * Version      : 1.0
 * Dev History  : Firstly Created
***************************************************************/


package mm.com.dat.ses.evaluationpoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EvaluationPointManageController {
	
	//Evaluation Point Register
	@RequestMapping("/ses/eval_point")
	public ModelAndView showEvalRegForm() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/evaluation_point");

		return model;
	}

}
