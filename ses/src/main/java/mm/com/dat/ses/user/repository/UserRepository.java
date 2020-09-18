package mm.com.dat.ses.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mm.com.dat.ses.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

}
