/***************************************************************
 * Author       :	Min Arkar Mon					
 * Created Date :	22/10/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.improvementtype.reqdto;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class ImprovementTypeManageReqDto {
	
	private Long improvement_type_id;

	private String improvementType;

	private Short delFlag;

	private Long createdBy;

	private Timestamp createdTime;

	private Long updatedBy;

	private Timestamp updatedTime;

}
