package mm.com.dat.ses.user.repository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import mm.com.dat.ses.user.entity.UserEntity;

@Repository
public interface UserManageRepository extends PagingAndSortingRepository<UserEntity, Long>,
JpaSpecificationExecutor<UserEntity> {
	
}

