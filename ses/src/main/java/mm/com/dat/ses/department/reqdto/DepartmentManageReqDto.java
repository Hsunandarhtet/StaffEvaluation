/***************************************************************
 * Author       :							
 * Created Date :
 * Updated Date :
 * Version      : 
 * Dev History  :
***************************************************************/

package mm.com.dat.ses.department.reqdto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class DepartmentManageReqDto {
	
	private Long dept_id;

	private String deptName;

	private Short delFlag;

	private Long createdBy;
	
	private Timestamp createdTime;

	private Long updatedBy;
	
	private Timestamp updatedTime;
}
