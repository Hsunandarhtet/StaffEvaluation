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
import mm.com.dat.ses.project.entity.ProjectEntity;
import mm.com.dat.ses.team.entity.TeamEntity;
import mm.com.dat.ses.user.entity.UserEntity;

@Data
@Entity
@Table(name="eval_score_head")
public class EvalScoreHeadEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private long eval_score_head_id;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserEntity userId;
	
	@ManyToOne
	@JoinColumn(name="team_id",nullable=false)
	private TeamEntity teamId;
	
	@ManyToOne
	@JoinColumn(name="budget_year_id",nullable=false)
	private BudgetYearEntity budgetYearId;
	
	@ManyToOne
	@JoinColumn(name="project_id",nullable=false)
	private ProjectEntity projectId;
	
	@Column(name = "deg_flag", nullable = false)
	private Short degFlag;

	@Column(name = "created_by", nullable = false,length = 8)
	private String createdBy;
	
	@Column(name = "created_time", nullable = false)
	private Timestamp createdTime;

	@Column(name = "updated_by",length = 8)
	private String updatedBy;
	
	@Column(name = "updated_time")
	private Timestamp updatedTime;
	
}
