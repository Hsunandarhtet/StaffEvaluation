/***************************************************************
 * Author       :	Hsu Nandar Htet						
 * Created Date :	23.10.2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	Firstly Created
***************************************************************/

package mm.com.dat.ses.team.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mm.com.dat.ses.team.entity.TeamEntity;

@Repository
public interface TeamManageRepository extends PagingAndSortingRepository<TeamEntity,Long>, 
JpaSpecificationExecutor<TeamEntity>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update TeamEntity t set t.delFlag=1 where t.team_id=:team_id")
	public void delTeam(@Param("team_id") Long team_id);
}
