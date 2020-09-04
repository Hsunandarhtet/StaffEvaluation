package mm.com.dat.ses.user.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mm.com.dat.ses.user.entity.UserEntity;
import mm.com.dat.ses.user.repository.UserManageRepository;
import mm.com.dat.ses.user.reqdto.UserManageReqDto;

@Service
public class UserManageService implements IUserServiceManager {

	@Autowired
	private UserManageRepository repository;

	@Override
	public List<UserEntity> findAll() {

		return (List<UserEntity>) repository.findAll();
	}

	@Override
	public UserEntity getUserById(long id) {
		return repository.findById(id).get();
	}

	@Override
	public void saveUser(UserManageReqDto usr) {

		UserEntity usrEnt = new UserEntity();
		usrEnt.setId(usr.getId());
		usrEnt.setName(usr.getName());
		usrEnt.setAge(usr.getAge());
		usrEnt.setAddress(usr.getAddress());

		repository.save(usrEnt);

	}

	@Override
	public void deleteUser(long id) {

		repository.deleteById(id);

	}

	@Override
	public long count() {

		return repository.count();
	}

	@Override
	public List<UserEntity> findAllUser(int pageNumber, int rowPerPage) {

		List<UserEntity> usrList = new ArrayList<>();

		Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,

				Sort.by("id").ascending());

		repository.findAll(sortedByIdAsc).forEach(usrList::add);

		return usrList;
	}

}
