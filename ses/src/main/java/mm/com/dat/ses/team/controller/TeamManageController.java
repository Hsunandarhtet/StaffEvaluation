/***************************************************************
 * Author       :							
 * Created Date :
 * Updated Date :
 * Version      : 
 * Dev History  :
***************************************************************/


package mm.com.dat.ses.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamManageController {
	
	//Team Lists
	@RequestMapping("/team_lists")
	public ModelAndView showTeamLists() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/team_lists");

		return model;
	}
	
	//Department Registration Form 
	@RequestMapping("/teamRegister")
	public ModelAndView showTeamRegister() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/team_register");

		return model;
	}
	
	//Department Registration Form 
	@RequestMapping("/teamEdit")
	public ModelAndView showTeamUpdate() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("redirect:/teamRegister");

		return model;
	}

}
