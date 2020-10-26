/***************************************************************
 * Author       :	Min Arkar Mon					
 * Created Date :	22/10/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.improvementtype.resdto;

import lombok.Data;

@Data
public class ImprovementTypeManageResDto {

	private Long improvement_type_id;

	private String improvementType;

	private Long createdBy;

	private Long updatedBy;

}
