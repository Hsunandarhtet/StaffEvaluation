package mm.com.dat.ses.user.services;

import java.util.List;

import mm.com.dat.ses.user.entity.UserEntity;
import mm.com.dat.ses.user.reqdto.UserManageReqDto;

public interface IUserServiceManager {

	List<UserEntity> findAll();
	
	List<UserEntity> findAllUser(int pageNumber, int rowPerPagev);
	
	UserEntity getUserById(long id);

    void saveUser(UserManageReqDto usr);

    void deleteUser(long id);
    
    long count();

}
