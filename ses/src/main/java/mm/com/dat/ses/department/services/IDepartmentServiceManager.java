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
import mm.com.dat.ses.department.resbean.DepartmentManageResbean;

public interface IDepartmentServiceManager {
	
	List<DepartmentEntity> findAll();
	
	List<DepartmentEntity> findAllDept(int pageNumber,int rowPerPage);
	
	DepartmentEntity getDeptById(long dept_id);
	
	void saveDept(DepartmentManageReqDto dept);
	
	void deleteDept(Long dept_id);
	
	long count();
	
}
