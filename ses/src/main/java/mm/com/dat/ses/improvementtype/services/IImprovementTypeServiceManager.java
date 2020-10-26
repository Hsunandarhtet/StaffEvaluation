/***************************************************************
 * Author       :	Min Arkar Mon					
 * Created Date :	22/10/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.improvementtype.services;

import java.util.List;

import mm.com.dat.ses.improvementtype.entity.ImprovementTypeEntity;
import mm.com.dat.ses.improvementtype.reqdto.ImprovementTypeManageReqDto;

public interface IImprovementTypeServiceManager {

	List<ImprovementTypeEntity> findAll();
	
	List<ImprovementTypeEntity> findAllImptType(int pageNumber,int rowPerPage);

	ImprovementTypeEntity getImpTypeById(Long improvement_type_id);

	Boolean saveImpType(ImprovementTypeManageReqDto improvementTypeManageReqDto);
	
	Boolean deleteImpType(Long improvement_type_id);
	
	long count();

}
