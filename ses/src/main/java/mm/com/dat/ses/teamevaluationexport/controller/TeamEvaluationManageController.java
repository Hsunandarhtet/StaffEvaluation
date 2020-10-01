/***************************************************************
 * Author       :							
 * Created Date :
 * Updated Date :
 * Version      : 
 * Dev History  :
***************************************************************/


package mm.com.dat.ses.teamevaluationexport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamEvaluationManageController {
	
	//Team Lists
	@RequestMapping("/team_evaluation")
	public ModelAndView showTeamLists() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/team_eavl_export");

		return model;
	}
	

}
