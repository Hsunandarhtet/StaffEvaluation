/***************************************************************
 * Author       :	Hsu Nandar Htet					
 * Created Date :	
 * Updated Date :	-	
 * Version      : 	1.0
 * Dev History  :	Firstly Created
***************************************************************/

package mm.com.dat.ses.department.reqbean;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class DepartmentManageReqBean {
	
	private Long dept_id;

	private String deptName;

	private Short degFlag;

	private Long createdBy;
	
	private Timestamp createdTime;

	private Long updatedBy;
	
	private Timestamp updatedTime;
}
