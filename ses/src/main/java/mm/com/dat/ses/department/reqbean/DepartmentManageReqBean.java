/***************************************************************
 * Author       :							
 * Created Date :
 * Updated Date :
 * Version      : 
 * Dev History  :
***************************************************************/

package mm.com.dat.ses.department.reqbean;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class DepartmentManageReqBean {
	
	private Long dept_id;

	private String deptName;

	private Short degFlag;

	private long createdBy;
	
	private Timestamp createdTime;

	private long updatedBy;
	
	private Timestamp updatedTime;
}
