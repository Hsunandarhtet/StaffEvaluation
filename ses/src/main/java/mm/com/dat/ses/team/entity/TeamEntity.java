/***************************************************************
 * Author       :	Hsu Nandar Htet						
 * Created Date :	18/9/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.team.entity;

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
import mm.com.dat.ses.department.entity.DepartmentEntity;

@Data
@Entity
@Table(name = "team")
public class TeamEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private long team_id;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private DepartmentEntity deptEntity;

	@Column(name = "team_short_name", nullable = false)
	private String teamShortName;
	
	@Column(name = "team_full_name", nullable = false)
	private String teamFullName;

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
