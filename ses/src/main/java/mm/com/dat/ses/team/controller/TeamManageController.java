/***************************************************************
 * Author       : Aung Ko Lin						
 * Created Date : 10/01/2020
 * Updated Date : -
 * Version      : 1.0
 * Dev History  : Firstly Created
***************************************************************/


package mm.com.dat.ses.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamManageController {
	
	//Team Lists
	@RequestMapping("/ses/team_lists")
	public ModelAndView showTeamLists() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/team_lists");

		return model;
	}
	
	//Department Registration Form 
	@RequestMapping("/ses/teamRegister")
	public ModelAndView showTeamRegister() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/team_register");

		return model;
	}
	
	//Department Registration Form 
	@RequestMapping("/ses/teamEdit")
	public ModelAndView showTeamUpdate() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("redirect:/ses/teamRegister");

		return model;
	}

}
