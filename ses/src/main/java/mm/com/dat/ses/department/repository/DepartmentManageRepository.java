/***************************************************************
 * Author       :	Hsu Nandar Htet						
 * Created Date :	
 * Updated Date :
 * Version      : 
 * Dev History  :
***************************************************************/

package mm.com.dat.ses.department.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mm.com.dat.ses.department.entity.DepartmentEntity;

@Repository
public interface DepartmentManageRepository extends PagingAndSortingRepository<DepartmentEntity,Long>, 
JpaSpecificationExecutor<DepartmentEntity>{
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update DepartmentEntity d set d.delFlag=1 where d.dept_id=:dept_id") 
	 public void delDept(@Param("dept_id") Long dept_id);
}