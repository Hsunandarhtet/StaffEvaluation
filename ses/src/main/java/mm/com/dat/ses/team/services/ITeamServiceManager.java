/***************************************************************
 * Author       :	Hsu Nandar Htet					
 * Created Date :	23.10.2020
 * Updated Date :	-	
 * Version      : 	1.0
 * Dev History  :	Firstly Created
***************************************************************/

package mm.com.dat.ses.team.services;

import java.util.List;

import mm.com.dat.ses.team.entity.TeamEntity;
import mm.com.dat.ses.team.reqdto.TeamManageReqDto;
public interface ITeamServiceManager {

	List<TeamEntity> findAll();
	
	TeamEntity getTeamById(Long team_id);
	
	Boolean saveTeam(TeamManageReqDto team);
	
	Boolean deleteTeam(Long team_id);
	
	
}
