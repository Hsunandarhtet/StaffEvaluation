/***************************************************************
 * Author       :	Min Arkar Mon					
 * Created Date :	22/10/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.improvementtype.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mm.com.dat.ses.improvementtype.entity.ImprovementTypeEntity;

@Repository
public interface ImprovementTypeManageRepository extends PagingAndSortingRepository<ImprovementTypeEntity, Long>,
		JpaSpecificationExecutor<ImprovementTypeEntity> {

	@Transactional

	@Modifying(clearAutomatically = true)

	@Query("update ImprovementTypeEntity it set it.delFlag=1 where it.improvement_type_id=:improvement_type_id")
	public void delImpType(@Param("improvement_type_id") Long improvement_type_id);

}
