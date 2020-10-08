/***************************************************************
 * Author       :	Hsu Nandar Htet						
 * Created Date :	
 * Updated Date :
 * Version      : 
 * Dev History  :
***************************************************************/

package mm.com.dat.ses.department.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import mm.com.dat.ses.department.entity.DepartmentEntity;

@Repository
public interface DepartmentManageRepository extends PagingAndSortingRepository<DepartmentEntity,Long>, 
JpaSpecificationExecutor<DepartmentEntity>{
	
}