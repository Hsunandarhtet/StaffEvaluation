package mm.com.dat.ses.evaluation.scoreHead.entity;

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
import mm.com.dat.ses.financialbudgetyear.entity.BudgetYearEntity;
import mm.com.dat.ses.team.entity.TeamEntity;
import mm.com.dat.ses.user.entity.UserEntity;

@Data
@Entity
@Table(name="eval_score_head")
public class EvalScoreHeadEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private Long eval_score_head_id;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserEntity userId;
	
	@ManyToOne
	@JoinColumn(name="team_id",nullable=false)
	private TeamEntity teamId;
	
	@ManyToOne
	@JoinColumn(name="budget_year_id",nullable=false)
	private BudgetYearEntity budgetYearId;
	
	@Column(name = "del_flag", nullable = false)
	private Short delFlag;

	@Column(name = "created_by",nullable = false)
	private Long createdBy;
	
	@Column(name = "created_time", nullable = false)
	private Timestamp createdTime;
	
	@Column(name = "updated_by")
	private Long updatedBy;
	
	@Column(name = "updated_time")
	private Timestamp updatedTime;
	
}
