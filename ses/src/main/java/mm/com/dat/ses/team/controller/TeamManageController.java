/***************************************************************
 * Author       : Aung Ko Lin						
 * Created Date : 10/01/2020
 * Updated Date : 10/25/2020
 * Version      : 1.0
 * Dev History  : Firstly Created
***************************************************************/


package mm.com.dat.ses.team.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jayway.jsonpath.Option;

import mm.com.dat.ses.department.entity.DepartmentEntity;
import mm.com.dat.ses.department.services.IDepartmentServiceManager;
import mm.com.dat.ses.team.entity.TeamEntity;
import mm.com.dat.ses.team.reqbean.TeamManageReqBean;
import mm.com.dat.ses.team.reqdto.TeamManageReqDto;
import mm.com.dat.ses.team.resbean.TeamManageResbean;
import mm.com.dat.ses.team.services.ITeamServiceManager;

@Controller
@RequestMapping("/ses")
public class TeamManageController {
	
	@Autowired
	private ITeamServiceManager teamService;
	
	@Autowired
	private IDepartmentServiceManager deptService;
	
	private static Logger logger=org.slf4j.LoggerFactory.getLogger(SLF4JLogger.class);

	
	//Team Lists
	@RequestMapping("/team_lists")
	public ModelAndView showTeamLists() {
		
		logger.info("Starting the getTeamList() For all searching...");

		ModelAndView model = new ModelAndView();	
		
		List<TeamEntity> teamList=new ArrayList<TeamEntity>();
		
		teamService.findAll().forEach(teamList::add);
		
		List<TeamManageResbean>  teamResList=new ArrayList<TeamManageResbean>();
		
		for(TeamEntity team:teamList) {
			
			TeamManageResbean teamResBean=new TeamManageResbean();
			
			teamResBean.setTeam_id(team.getTeam_id());
			teamResBean.setTeamShortName(team.getTeamShortName());
			teamResBean.setTeamFullName(team.getTeamFullName());
			teamResBean.setDeptEntity(team.getDeptEntity());
			
			teamResList.add(teamResBean);
			
		}
		model.addObject("teamList",teamResList);
		model.setViewName("admin/team_lists");

		return model;
	}
	
	//Team Registration Form 
	@RequestMapping({"/teamRegister","/teamEdit/{id}"})
	public ModelAndView showTeamRegister(@PathVariable("id") Optional<Long> teamId) {
		ModelAndView model = new ModelAndView();	
		
		String titleName="";
		List<DepartmentEntity> dept=deptService.findAll();
		
		//For Update Process
		if(teamId.isPresent()) {
			
			titleName="Update Team Information";
			TeamEntity team=teamService.getTeamById(teamId.get());
			model.addObject("titleName",titleName);
			model.addObject("team",team);
		}
		//For Registration Process
		else {
			
			titleName="Team Registration";
			model.addObject("titleName",titleName);
			model.addObject("team",new TeamManageReqBean());
		}
		model.addObject("dept",dept);
		model.setViewName("admin/team_register");

		return model;
	}
	
	//Team Registration
	@RequestMapping(path="/createTeam",method = RequestMethod.POST)
	public ModelAndView addNewTeam(@Valid @ModelAttribute("team") TeamManageReqBean teamBean,BindingResult bindRes) {
		
		 if (bindRes.hasErrors()) {
	            System.out.println("BINDING RESULT ERROR");
	            
	        } else {
		
		Long createdBy=(long) 1;
		Short delFlag=0;
		
		Timestamp createdTime = new Timestamp(System.currentTimeMillis());
		TeamManageReqDto team=new TeamManageReqDto();
		team.setTeam_id(teamBean.getTeam_id());
		team.setTeamShortName(teamBean.getTeamShortName());
		team.setTeamFullName(teamBean.getTeamFullName());
		team.setDeptEntity(teamBean.getDeptEntity());
		team.setDelFlag(delFlag);
		team.setCreatedBy(createdBy);
		team.setCreatedTime(createdTime);
		
		teamService.saveTeam(team);
	        }
		return new ModelAndView("redirect:/ses/team_lists");
	        
	}
	
	@RequestMapping("/delTeam/{id}")
	public ModelAndView delTeam(@PathVariable("id") Long teamId) {
		
		Boolean status=teamService.deleteTeam(teamId);
		
		return new ModelAndView("redirect:/ses/team_lists");
	}
}
