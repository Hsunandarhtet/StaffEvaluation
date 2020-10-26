/***************************************************************
 * Author       :	Hsu Nandar Htet					
 * Created Date :	23.10.2020
 * Updated Date :	-	
 * Version      : 	1.0
 * Dev History  :	Firstly Created
***************************************************************/

package mm.com.dat.ses.team.reqbean;

import java.sql.Timestamp;

import lombok.Data;
import mm.com.dat.ses.department.entity.DepartmentEntity;

@Data
public class TeamManageReqBean {
	
	private Long team_id;
	
	private DepartmentEntity deptEntity;

	private String teamShortName;
	
	private String teamFullName;

	private Short delFlag;

	private Long createdBy;
	
	private Timestamp createdTime;
	
	private Long updatedBy;
	
	private Timestamp updatedTime;
}
