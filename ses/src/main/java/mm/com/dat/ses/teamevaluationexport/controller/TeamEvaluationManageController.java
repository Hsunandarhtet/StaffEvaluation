/***************************************************************
 * Author       : Aung Ko Lin						
 * Created Date : 10/01/2020
 * Updated Date : -
 * Version      : 1.0
 * Dev History  : Firstly Created
***************************************************************/


package mm.com.dat.ses.teamevaluationexport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamEvaluationManageController {
	
	//Team Lists
	@RequestMapping("/ses/team_evaluation")
	public ModelAndView showTeamLists() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/team_eavl_export");

		return model;
	}
	

}
