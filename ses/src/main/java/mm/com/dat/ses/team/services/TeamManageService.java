/***************************************************************
 * Author       :	Hsu Nandar Htet					
 * Created Date :	23.10.2020
 * Updated Date :	-	
 * Version      : 	1.0
 * Dev History  :	Firstly Created
***************************************************************/

package mm.com.dat.ses.team.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import mm.com.dat.ses.team.entity.TeamEntity;
import mm.com.dat.ses.team.repository.TeamManageRepository;
import mm.com.dat.ses.team.reqdto.TeamManageReqDto;

@Service
public class TeamManageService implements ITeamServiceManager{

	@Autowired
	private TeamManageRepository teamRepo;
	
	@Override
	public List<TeamEntity> findAll() {
		
		return (List<TeamEntity>) teamRepo.findAll();
	}

	@Override
	public TeamEntity getTeamById(Long team_id) throws ResourceNotFoundException{
		
		Optional<TeamEntity> team=teamRepo.findById(team_id);
		
		if(team.isPresent()) {
			return team.get();
		}else {
			throw new ResourceNotFoundException();
		}
	}

	@Override
	public Boolean saveTeam(TeamManageReqDto team) {
		
		Boolean status=true;
		
		if(team.getTeam_id() == null) {
			TeamEntity createTeam=new TeamEntity();
			
			createTeam.setTeam_id(team.getTeam_id());
			createTeam.setTeamShortName(team.getTeamShortName());
			createTeam.setTeamFullName(team.getTeamFullName());
			createTeam.setDeptEntity(team.getDeptEntity());
			createTeam.setDelFlag(team.getDelFlag());
			createTeam.setCreatedBy(team.getCreatedBy());
			createTeam.setCreatedTime(team.getCreatedTime());
			
			try {
				teamRepo.save(createTeam);
			}catch(PersistenceException e) {
				status=false;
			}
		}
		else {
			
			Optional<TeamEntity> teamInfo=teamRepo.findById(team.getTeam_id());
			
			if(teamInfo.isPresent()) {
				Long updatedBy=(long) 1;
				Timestamp updatedTime = new Timestamp(System.currentTimeMillis());
				TeamEntity updateTeam=teamInfo.get();
				
				updateTeam.setTeam_id(team.getTeam_id());
				updateTeam.setTeamShortName(team.getTeamShortName());
				updateTeam.setTeamFullName(team.getTeamFullName());
				updateTeam.setDeptEntity(team.getDeptEntity());
				updateTeam.setUpdatedBy(updatedBy);
				updateTeam.setUpdatedTime(updatedTime);
				
				try {
					teamRepo.save(updateTeam);
				}catch (PersistenceException e) {
					status=false;
				}
			}
		}
		return status;
	}

	@Override
	public Boolean deleteTeam(Long team_id) {
		Boolean delstatus=true;
		try{
			teamRepo.delTeam(team_id);
			
		}catch (PersistenceException e) {
			delstatus=false;
			
		}
		return delstatus;
	}

	
}
