package mm.com.dat.ses.user.entity;

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
@Table(name = "user_team")
public class UserTeamEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private long user_team_id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity userId;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private TeamEntity teamId;

	@Column(name = "mainly_belong")
	private short mainly_belong;

}
