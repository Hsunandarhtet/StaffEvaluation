/***************************************************************
 * Author       :							
 * Created Date :
 * Updated Date :
 * Version      : 
 * Dev History  :
***************************************************************/


package mm.com.dat.ses.evaluationpoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EvaluationPointManageController {
	
	//Evaluation Point Register
	@RequestMapping("/eval_point")
	public ModelAndView showEvalRegForm() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/evaluation_point");

		return model;
	}

}
