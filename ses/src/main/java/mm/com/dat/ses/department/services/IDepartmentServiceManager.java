/***************************************************************
 * Author       :							
 * Created Date :
 * Updated Date :
 * Version      : 
 * Dev History  :
***************************************************************/

package mm.com.dat.ses.department.services;

import java.util.List;

import mm.com.dat.ses.department.entity.DepartmentEntity;
import mm.com.dat.ses.department.reqdto.DepartmentManageReqDto;

public interface IDepartmentServiceManager {
	
	List<DepartmentEntity> findAll();
	
	List<DepartmentEntity> findAllDept(int pageNumber,int rowPerPage);
	
	DepartmentEntity getDeptById(Long dept_id);
	
	Boolean saveDept(DepartmentManageReqDto dept);
	
	Boolean deleteDept(Long dept_id);
	
	long count();
	
}
