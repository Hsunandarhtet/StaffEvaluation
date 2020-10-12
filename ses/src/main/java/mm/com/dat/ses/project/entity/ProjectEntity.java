package mm.com.dat.ses.project.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;
import mm.com.dat.ses.team.entity.TeamEntity;
import mm.com.dat.ses.user.entity.UserEntity;

@Data
@Entity
@Table(name="project")
public class ProjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private Long project_id;
	
	@ManyToOne
	@JoinColumn(name="team_id",nullable=false)
	private TeamEntity teamId;
	
	@Column(name="project_id_name",nullable=false)
	private String projectIdName;
	
	@Column(name="project_name",nullable=false)
	private String projectName;
	
	@ManyToMany(mappedBy = "projectId")
	private Set<UserEntity> userId;
	
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
