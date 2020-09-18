package mm.com.dat.ses.user.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;
import mm.com.dat.ses.team.entity.TeamEntity;

@Data
@Entity
@Table(name = "user_team_history")
public class UserTeamHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private long history_id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity userId;
	
	@ManyToOne
	@JoinColumn(name="team_id")
	private TeamEntity teamId;
	
	@Column(name = "updated_by",length = 8)
	private String updatedBy;
	
	@Column(name = "updated_time")
	private Timestamp updatedTime;
}
