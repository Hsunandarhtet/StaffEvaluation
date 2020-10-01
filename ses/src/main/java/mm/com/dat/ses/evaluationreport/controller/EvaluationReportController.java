/***************************************************************
 * Author       :	Min Arkar Mon							
 * Created Date :	28/9/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.evaluationreport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EvaluationReportController {
	
		// Evaluation Report Lists
		@RequestMapping("/evalReport_lists")
		public ModelAndView showEvalReport() {

			ModelAndView model = new ModelAndView();
			model.setViewName("admin/evalReport_lists");

			return model;
		}
}
