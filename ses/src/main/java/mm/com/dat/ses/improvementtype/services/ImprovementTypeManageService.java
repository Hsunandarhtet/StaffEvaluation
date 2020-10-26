/***************************************************************
 * Author       :	Min Arkar Mon					
 * Created Date :	23/10/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.improvementtype.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import mm.com.dat.ses.improvementtype.entity.ImprovementTypeEntity;
import mm.com.dat.ses.improvementtype.repository.ImprovementTypeManageRepository;
import mm.com.dat.ses.improvementtype.reqdto.ImprovementTypeManageReqDto;

@Service
public class ImprovementTypeManageService implements IImprovementTypeServiceManager{

	@Autowired
	ImprovementTypeManageRepository improvementTypeManageRepository;

	 @Override 
	public List<ImprovementTypeEntity> findAll() {

		return (List<ImprovementTypeEntity>) improvementTypeManageRepository.findAll();
	}

	 @Override 
	public List<ImprovementTypeEntity> findAllImptType(int pageNumber, int rowPerPage) {

		List<ImprovementTypeEntity> imptTypeList = new ArrayList<>();

		Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage, Sort.by("improvement_type_id").ascending());

		improvementTypeManageRepository.findAll(sortedByIdAsc).forEach(imptTypeList::add);

		return imptTypeList;
	}

	 @Override 
	public ImprovementTypeEntity getImpTypeById(Long improvement_type_id) throws ResourceNotFoundException {

		Optional<ImprovementTypeEntity> imptType = improvementTypeManageRepository.findById(improvement_type_id);

		if (imptType.isPresent()) {
			return imptType.get();
		} else {
			throw new ResourceNotFoundException();
		}
	}

	 @Override 
	public Boolean saveImpType(ImprovementTypeManageReqDto improvementTypeManageReqDto) {

		Boolean status = true;

		if (improvementTypeManageReqDto.getImprovement_type_id() == null) {

			ImprovementTypeEntity createImptType = new ImprovementTypeEntity();

			createImptType.setImprovement_type_id(improvementTypeManageReqDto.getImprovement_type_id());
			createImptType.setImprovementType(improvementTypeManageReqDto.getImprovementType());
			createImptType.setDelFlag(improvementTypeManageReqDto.getDelFlag());
			createImptType.setCreatedBy(improvementTypeManageReqDto.getCreatedBy());
			createImptType.setCreatedTime(improvementTypeManageReqDto.getCreatedTime());
			createImptType.setUpdatedBy(improvementTypeManageReqDto.getUpdatedBy());
			createImptType.setUpdatedTime(improvementTypeManageReqDto.getUpdatedTime());

			try {
				improvementTypeManageRepository.save(createImptType);
			} catch (Exception e) {
				status = false;
			}

		} else {
			Optional<ImprovementTypeEntity> imptTypeInfo = improvementTypeManageRepository
					.findById(improvementTypeManageReqDto.getImprovement_type_id());

			if (imptTypeInfo.isPresent()) {

				Long updatedBy = (long) 25 - 00001;
				Timestamp updatedTime = new Timestamp(System.currentTimeMillis());

				ImprovementTypeEntity updateImptType = imptTypeInfo.get();
				updateImptType.setImprovement_type_id(improvementTypeManageReqDto.getImprovement_type_id());
				updateImptType.setImprovementType(improvementTypeManageReqDto.getImprovementType());
				updateImptType.setDelFlag(improvementTypeManageReqDto.getDelFlag());
				updateImptType.setCreatedBy(improvementTypeManageReqDto.getCreatedBy());
				updateImptType.setCreatedTime(improvementTypeManageReqDto.getCreatedTime());
				updateImptType.setUpdatedBy(updatedBy);
				updateImptType.setUpdatedTime(updatedTime);

				try {
					improvementTypeManageRepository.save(updateImptType);
				} catch (Exception e) {
					status = false;
				}
			}

		}
		return status;
	}

	 @Override 
	public Boolean deleteImpType(Long improvement_type_id) {

		Boolean delstatus = true;
		try {
			improvementTypeManageRepository.delImpType(improvement_type_id);
		} catch (PersistenceException e) {
			System.out.println(e);
			delstatus = false;
		}
		return delstatus;
	}

	 @Override 
	public long count() {

		return improvementTypeManageRepository.count();
	}

}
