package mm.com.dat.ses.user.services;

import java.util.List;

import mm.com.dat.ses.user.entity.UserEntityTest;
import mm.com.dat.ses.user.reqdto.UserManageReqDto;

public interface IUserServiceManager {

	List<UserEntityTest> findAll();
	
	List<UserEntityTest> findAllUser(int pageNumber, int rowPerPagev);
	
	UserEntityTest getUserById(long id);

    void saveUser(UserManageReqDto usr);

    void deleteUser(long id);
    
    long count();

}
