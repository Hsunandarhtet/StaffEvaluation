/***************************************************************
 * Author       :							
 * Created Date :
 * Updated Date :
 * Version      : 
 * Dev History  :
***************************************************************/

package mm.com.dat.ses.department.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import mm.com.dat.ses.department.entity.DepartmentEntity;
import mm.com.dat.ses.department.repository.DepartmentManageRepository;
import mm.com.dat.ses.department.reqbean.DepartmentManageReqBean;
import mm.com.dat.ses.department.reqdto.DepartmentManageReqDto;

@Service
public class DepartmentManageService implements IDepartmentServiceManager{

	@Autowired
	private DepartmentManageRepository deptRepo;

	@Override
	public List<DepartmentEntity> findAll() {
		
		return (List<DepartmentEntity>) deptRepo.findAll();
	}

	@Override
	public List<DepartmentEntity> findAllDept(int pageNumber, int rowPerPage) {
		
		List<DepartmentEntity> deptList=new ArrayList<>();
		
		Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,

				Sort.by("dept_id").ascending());
		
		deptRepo.findAll(sortedByIdAsc).forEach(deptList::add);
		
		return deptList;
	}

	@Override
	public DepartmentEntity getDeptById(long dept_id) throws ResourceNotFoundException{
		
		Optional<DepartmentEntity> dept=deptRepo.findById(dept_id);
		
		if(dept.isPresent()) {
			return dept.get();
		}else {
			throw new ResourceNotFoundException();
		}
	}

	@Override
	public void saveDept(DepartmentManageReqDto dept) {
		
		
		if(dept.getDept_id() == null){
			DepartmentEntity createDept=new DepartmentEntity();
			createDept.setDept_id(dept.getDept_id());
			createDept.setDeptName(dept.getDeptName());
			createDept.setDelFlag(dept.getDelFlag());
			createDept.setCreatedBy(dept.getCreatedBy());
			createDept.setCreatedTime(dept.getCreatedTime());
			createDept.setUpdatedBy(dept.getUpdatedBy());
			createDept.setUpdatedTime(dept.getUpdatedTime());
			deptRepo.save(createDept);
		}
		else {
			Optional<DepartmentEntity> deptInfo=deptRepo.findById(dept.getDept_id());
			
			if(deptInfo.isPresent()) {
				Long updatedBy=(long) 1;
				Timestamp updatedTime = new Timestamp(System.currentTimeMillis());
				DepartmentEntity updateDept=deptInfo.get();
				updateDept.setDept_id(dept.getDept_id());
				updateDept.setDeptName(dept.getDeptName());
				updateDept.setDelFlag(dept.getDelFlag());
				updateDept.setCreatedBy(dept.getCreatedBy());
				updateDept.setCreatedTime(dept.getCreatedTime());
				updateDept.setUpdatedBy(updatedBy);
				updateDept.setUpdatedTime(updatedTime);
				
				deptRepo.save(updateDept);
			}
			
			
		}
		
	}

	@Override
	public void deleteDept(Long dept_id) {
		
		deptRepo.deleteById(dept_id);
	}

	@Override
	public long count() {
		
		return deptRepo.count();
	}
	
}
